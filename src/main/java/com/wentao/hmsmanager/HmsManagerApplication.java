package com.wentao.hmsmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class HmsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsManagerApplication.class, args);
	}

}
