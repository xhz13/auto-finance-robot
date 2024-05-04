package com.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.finance.mapper") // 指定Mapper接口所在的包
public class FinancerobotApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinancerobotApplication.class, args);
	}
}
