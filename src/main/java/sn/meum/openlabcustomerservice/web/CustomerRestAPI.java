package sn.meum.openlabcustomerservice.web;

import org.springframework.web.bind.annotation.*;
import sn.meum.openlabcustomerservice.dto.CustomerRequestDTO;
import sn.meum.openlabcustomerservice.dto.CustomerResponseDTO;
import sn.meum.openlabcustomerservice.services.CustomerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }
}
