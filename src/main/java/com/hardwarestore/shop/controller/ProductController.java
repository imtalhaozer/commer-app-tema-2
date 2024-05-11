package com.hardwarestore.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardwarestore.shop.entity.Product;
import com.hardwarestore.shop.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    } 

    @GetMapping("/{productId}")
    public Product getOneProductbyId(@PathVariable Long productId){
        return productService.getOneProductbyId(productId);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product newProduct){
        return productService.updateProduct(productId,newProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteOneProduct(@PathVariable Long productId){
        productService.deleteOneProduct(productId);
    }
    
}
