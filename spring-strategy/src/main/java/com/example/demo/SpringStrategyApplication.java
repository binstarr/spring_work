package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStrategyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStrategyApplication.class, args);
		
		SBS sbs = new SBS();
		KBS kbs = new KBS();
		RemoteController remoteController = new RemoteController(sbs);
		
		System.out.println(remoteController.change());
		
		
	}

}
