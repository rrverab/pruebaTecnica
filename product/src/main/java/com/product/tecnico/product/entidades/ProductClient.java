package com.product.tecnico.product.entidades;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name="productClient",url="http://localhost:3001")
public interface ProductClient {

    @GetMapping("product/{productid}")
    public Product getProductById(@PathVariable("productid") Integer id);

    @GetMapping("product/{productid}/similarids")
    public ResponseEntity <List<Integer>> getSimilarids(@PathVariable("productid") Integer id);






}
