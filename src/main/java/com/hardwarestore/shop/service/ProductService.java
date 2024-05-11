package com.hardwarestore.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hardwarestore.shop.entity.Product;
import com.hardwarestore.shop.repository.ProductRepository;

@Service
public class ProductService {

ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
}

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getOneProductbyId(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product newProduct) {
        Optional<Product> product=productRepository.findById(productId);
        if(product.isPresent()){
            Product foundProduct=product.get();
            foundProduct.setProductName(newProduct.getProductName());
            foundProduct.setProductPrice(newProduct.getProductPrice());
            foundProduct.setProductType(newProduct.getProductType());
            foundProduct.setProductDescription(newProduct.getProductDescription());
            productRepository.save(foundProduct);
            return newProduct;
        }
        else
        return null;
    }

    public void deleteOneProduct(Long productId) {
        productRepository.deleteById(productId);
    }
    
}
