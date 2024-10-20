package arquitecturaMicroservicios.controllers;

import arquitecturaMicroservicios.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "John Doe", "johndoe", "password123"),
            new Customer(2, "Mr. Sigma", "janesmith", "Whatasigma123"),
            new Customer(3, "Gonzalo Herrera", "gonzoohh", "xDDDppcdsalv"),
            new Customer(4, "David Medina", "Eldeivid", "password456")
    ));

    @RequestMapping(method = RequestMethod.GET) // Different way of simple @GetMapping
    //@GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {

        return ResponseEntity.ok(customers);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    //@GetMapping("/{username}")
    public ResponseEntity<?> getCustomer(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found by username: " + username);
    }

    @RequestMapping(method = RequestMethod.POST)
    //@PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer) {
        customers.add(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body("Customer was succesfully created: " + customer.getUsername());
    }

    @RequestMapping(method = RequestMethod.POST)
    //@PutMapping
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

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getID() == id) {
                customers.remove(c);

                return c;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    //@PatchMapping
    public Customer patchCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {

            if (c.getID() == customer.getID()) {
                if (c.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
            }
            return c;
        }
        return null;
    }


}
