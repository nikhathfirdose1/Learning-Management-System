package com.sjsu.vansbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories // for repositiores to work, coz they are interfaces 
public class VansBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VansBackendApplication.class, args);
    }

}
