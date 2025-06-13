package com.eclosia.etudinatservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EtudinatServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EtudinatServiceApplication.class, args);
  }

}
