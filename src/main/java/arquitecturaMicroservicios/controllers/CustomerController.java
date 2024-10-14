package arquitecturaMicroservicios.controllers;

import arquitecturaMicroservicios.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "John Doe", "johndoe", "password123"),
            new Customer(2, "Mr. Sigma", "janesmith", "Whatasigma123"),
            new Customer(3, "Gonzalo Herrera", "gonzoohh", "xDDDppcdsalv"),
            new Customer(4, "David Medina", "Eldeivid", "password456")
    ));

    @GetMapping("/customers")
    public List<Customer> getCustomers() {



        return customers;
    }

    @GetMapping("/customers/{username}")
    public Customer getCustomer(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }










}
