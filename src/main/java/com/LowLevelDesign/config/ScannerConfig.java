package com.LowLevelDesign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Scanner;

@Configuration
public class ScannerConfig {
  @Bean
  @Primary
  Scanner getScanner(){
    return new Scanner(System.in);
  }
}
