package com.male;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * @author mingfangxu
 */
@SpringBootApplication
@Controller
public class GbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GbcApplication.class, args);
	}
}