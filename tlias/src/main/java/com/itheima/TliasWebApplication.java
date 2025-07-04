package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TliasWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TliasWebApplication.class, args);
	}

}
