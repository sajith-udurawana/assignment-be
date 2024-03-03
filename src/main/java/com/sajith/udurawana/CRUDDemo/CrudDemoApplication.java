package com.sajith.udurawana.CRUDDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;
import com.sajith.udurawana.CRUDDemo.entity.Role;
import com.sajith.udurawana.CRUDDemo.service.AuthService;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	// Seeding a default user
	@Bean
	CommandLineRunner commandLineRunner(AuthService service) {
		return args -> {
//			var user = RegisterRequest.builder().email("user@company.com").password("password")
//					.role(Role.USER).build();
//			System.out.print("Token: " + service.register(user).getToken());
		};
	}

}
