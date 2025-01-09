package com.travel.prihanshTravel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrihanshTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrihanshTravelApplication.class, args);

		//call auto-generated method
		

		System.out.println("Wellcome to Prihansh Travel");
		
	}
	



	//ModelMapper bean
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
