package arquitecturaMicroservicios.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @GetMapping({"/greeting/{name}", "/hi/{name}"})
    public String greeting(@PathVariable String name) {
        return "Hello " + name;
    }

}
