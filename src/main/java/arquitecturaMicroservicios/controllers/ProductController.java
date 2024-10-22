package arquitecturaMicroservicios.controllers;

import arquitecturaMicroservicios.domain.Product;
import arquitecturaMicroservicios.service.ProductService;
import arquitecturaMicroservicios.service.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productsService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);
    }

}
