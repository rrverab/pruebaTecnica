package com.product.tecnico.product.controlador;

import com.product.tecnico.product.entidades.Product;
import com.product.tecnico.product.entidades.ProductClient;
import com.product.tecnico.product.exceptions.NotFoundException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")

public class ProductController {

        @Autowired
        ProductClient client;

        @GetMapping("/{id}")
        public Product getProductById(@PathVariable("id") Integer id){
            try {
                return (client.getProductById(id));
            } catch (FeignException e) {
                if(e.status() == 404){
                    throw new NotFoundException("Product Not Found");
                }else{
                    throw  new RuntimeException();
                }
            }
        }



    @GetMapping("/{id}/similarids")
    public ResponseEntity <List<Integer>> getProductSimilar(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(client.getSimilarids(id).getBody());
        } catch (FeignException e) {
            if(e.status() == 404){
                throw new NotFoundException("Product Not Found");
            }else{
                throw  new RuntimeException();
            }
        }


    }







}
