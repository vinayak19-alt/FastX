package com.hexaware.fastx;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class FastxApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastxApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }


}
