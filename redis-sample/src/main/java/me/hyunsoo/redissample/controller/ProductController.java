package me.hyunsoo.redissample.controller;


import lombok.RequiredArgsConstructor;
import me.hyunsoo.redissample.beans.Product;
import me.hyunsoo.redissample.cache.ProductRepository;
import me.hyunsoo.redissample.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class ProductController {

   private final ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        Product selectedProduct = productService.getProduct(id);
        return selectedProduct;
    }

}
