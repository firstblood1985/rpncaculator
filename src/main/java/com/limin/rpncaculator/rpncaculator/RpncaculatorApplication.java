package com.limin.rpncaculator.rpncaculator;

import com.limin.rpncaculator.rpncaculator.operator.UnknownOperator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RpncaculatorApplication {


	public static void main(String[] args) {
		SpringApplication.run(RpncaculatorApplication.class, args);

	}
}
