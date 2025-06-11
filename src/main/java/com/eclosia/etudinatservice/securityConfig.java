package com.eclosia.etudinatservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class securityConfig {
  @Bean
  public SecurityWebFilterChain securityWebFilterChain(@Autowired ServerHttpSecurity http) {
    http
       .csrf(csrf -> csrf.disable())
       .authorizeExchange(exchanges -> exchanges.anyExchange().permitAll());
    return http.build();
  }
}
