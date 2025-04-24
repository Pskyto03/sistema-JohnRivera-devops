package com.example.matriculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // <-- Habilita Feign
public class MatriculasServicioApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatriculasServicioApplication.class, args);
    }
}
