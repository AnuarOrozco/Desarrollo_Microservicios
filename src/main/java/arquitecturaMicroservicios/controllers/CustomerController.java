package arquitecturaMicroservicios.controllers;

import arquitecturaMicroservicios.domain.Customer;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/customers")
    public Customer postCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer putCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null; // This is a bad practice do NOT replicate!!
    }

    @DeleteMapping("/customers/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getID() == id) {
                customers.remove(c);

                return c;
            }
        }
        return null;
    }




}
