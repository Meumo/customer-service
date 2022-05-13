package sn.meum.openlabcustomerservice.mappers;

import org.mapstruct.Mapper;
import sn.meum.openlabcustomerservice.dto.CustomerRequestDTO;
import sn.meum.openlabcustomerservice.dto.CustomerResponseDTO;
import sn.meum.openlabcustomerservice.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
