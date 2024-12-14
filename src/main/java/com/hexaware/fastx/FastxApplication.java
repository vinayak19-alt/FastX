package com.hexaware.fastx;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FastxApplication {

	//Logger logger=LoggerFactory.getLogger(class_name);
	public static void main(String[] args) {
		SpringApplication.run(FastxApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }


}
