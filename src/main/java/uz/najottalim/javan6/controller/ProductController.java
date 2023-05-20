package uz.najottalim.javan6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.javan6.entity.ProductEntity;
import uz.najottalim.javan6.service.ProductService;

import java.util.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products/all")
    public List<ProductEntity> getAll(){
        return productService.getAll();
    }
    @PostMapping("product/add")
    public String addProduct(@RequestBody ProductEntity product){
        return productService.addProduct(product);
    }
    @PutMapping("product/update/{id}")
    public String updateProduct(@PathVariable Long id,@RequestBody ProductEntity product){
        return productService.updateproduct(id,product);
    }
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/product/{id}")
    public ProductEntity getProductById(@PathVariable Long id){
        return productService.getById(id);
    }
    @GetMapping("/products/resources/limit/{limit}/offset/{offset}")
    public List<ProductEntity> getResourceLimitOffset(@PathVariable Long limit,@PathVariable Long offset){
        return productService.getResourceLimitOffset(limit,offset);
    }
}
