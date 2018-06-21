//package com.codeup.blog.controllers;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class RepositoryDemoController {
//    private ProductRepository extends repository;
//
//    public RepositoryDemoController(ProductRepository repository){
//        this.repository = repository;
//    }
//
//
//    @GetMapping("/product-test")
//    @ResponseBody public String test(){
//
//        Product product = new Product();
//        product.setName ("widget");
//        product.setPrice(12.99);
//
//        repository.save(product);
//
//        return "check the console";
//    }
//
//
//    public String test(){
//    long count = repository.count();
//    return "check the console";
//
//    }
//}
