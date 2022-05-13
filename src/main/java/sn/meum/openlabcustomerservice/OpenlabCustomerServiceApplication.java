package sn.meum.openlabcustomerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.meum.openlabcustomerservice.dto.CustomerRequestDTO;
import sn.meum.openlabcustomerservice.services.CustomerService;

@SpringBootApplication
public class OpenlabCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabCustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01","OpenLab","open@openlab.com"));
            customerService.save(new CustomerRequestDTO("C02","Adria","adria@adria.com"));
        };
    }
}
