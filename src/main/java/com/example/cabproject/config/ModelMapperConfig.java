package com.example.cabproject.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }

}
