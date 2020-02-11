package com.wentao.hmsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HmsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsManagerApplication.class, args);
	}

}
