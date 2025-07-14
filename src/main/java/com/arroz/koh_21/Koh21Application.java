package com.arroz.koh_21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Koh21Application {

    public static void main(String[] args) {
        SpringApplication.run(Koh21Application.class, args);
    }

}
