package sn.meum.openlabcustomerservice.services;

import org.springframework.stereotype.Service;
import sn.meum.openlabcustomerservice.dto.CustomerRequestDTO;
import sn.meum.openlabcustomerservice.dto.CustomerResponseDTO;
import sn.meum.openlabcustomerservice.entities.Customer;
import sn.meum.openlabcustomerservice.mappers.CustomerMapper;
import sn.meum.openlabcustomerservice.repositories.CustomerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {

      //  Mapping Objet Objet

       /*
         Customer customer=new Customer();
        customer.setId(customerRequestDTO.getId());
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customerRequestDTO.getEmail());
        */

        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        //customer.setId(UUID.randomUUID().toString());

        Customer customerSaved=customerRepository.save(customer);

       // Mapping Objet Objet

      /*
        CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
        customerResponseDTO.setId(customerSaved.getId());
        customerResponseDTO.setName(customerSaved.getName());
        customerResponseDTO.setEmail(customerSaved.getEmail());
        */
        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(customerSaved);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();

        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer customerUpdated = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(customerUpdated);
    }

    @Override

    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS=customers
                .stream()
                .map(customer -> customerMapper.customerToCustomerResponseDTO(customer)).collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
