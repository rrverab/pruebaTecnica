package com.product.tecnico.product.servicio;

import com.product.tecnico.product.entidades.Product;
import com.product.tecnico.product.exceptions.NotFoundException;
import com.product.tecnico.product.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product FindById(Long id){

        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new NotFoundException("Product whit id " + id + " Not Found");
        }

        return product.get();

    }








}
