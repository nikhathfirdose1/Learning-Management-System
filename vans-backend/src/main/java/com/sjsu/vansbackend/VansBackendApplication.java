package com.sjsu.vansbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class VansBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VansBackendApplication.class, args);
    }

}
