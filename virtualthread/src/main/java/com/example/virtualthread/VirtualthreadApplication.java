package com.example.virtualthread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class VirtualthreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualthreadApplication.class, args);
	}

}
