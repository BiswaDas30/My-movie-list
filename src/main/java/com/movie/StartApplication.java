package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
public class StartApplication {
    public static void main(String[] args) {
//        java.security.Security.setProperty("sun.net.spi.nameservice.nameservers", "10.35.35.35");
        SpringApplication.run(StartApplication.class, args);
    }
}
