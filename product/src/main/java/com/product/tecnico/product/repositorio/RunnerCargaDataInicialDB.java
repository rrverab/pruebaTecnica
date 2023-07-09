package com.product.tecnico.product.repositorio;
import com.product.tecnico.product.entidades.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class RunnerCargaDataInicialDB implements CommandLineRunner {


    private final ProductRepository productoRepository;


    public RunnerCargaDataInicialDB(ProductRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    @Transactional()
    public void run(String... args) throws Exception {



        productoRepository.save(
                Product .builder()
                        .id(1)
                        .name("camisa")
                        .price(10.00)
                        .availability(true)
                        .build());

        productoRepository.save(
                Product .builder()
                        .id(2)
                        .name("pantalon")
                        .price(30.00)
                        .availability(false)
                        .build());

        productoRepository.save(
                Product .builder()
                        .id(3)
                        .name("short")
                        .price(8.00)
                        .availability(true)
                        .build());







    }
}