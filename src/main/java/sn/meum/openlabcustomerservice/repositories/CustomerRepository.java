package sn.meum.openlabcustomerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.meum.openlabcustomerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
