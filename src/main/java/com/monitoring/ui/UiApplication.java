package com.monitoring.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication

public class UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
		System.out.println("Started spring application");
	}

}
