package sn.meum.openlabcustomerservice.services;

import sn.meum.openlabcustomerservice.dto.CustomerRequestDTO;
import sn.meum.openlabcustomerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
