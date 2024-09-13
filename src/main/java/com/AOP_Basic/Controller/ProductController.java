package com.AOP_Basic.Controller;

import com.AOP_Basic.AOPService.AOPService;
import com.AOP_Basic.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private AOPService aopService;

    @PostMapping
    Product productSave(@RequestBody Product product) {
        System.out.println("save product from controller method()");
        Product save = aopService.saveProduct(product);
        return save;
    }

    @GetMapping("/{id}")
    Product productGet(@PathVariable("id") String Id) {
        Product product = aopService.getProduct(Id);
        return product;
    }

    @GetMapping
    List<Product> productGet() {
        List<Product> product = aopService.getAllProduct();
        return product;
    }
}
