package com.sajith.udurawana.CRUDDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sajith.udurawana.CRUDDemo.entity.RegisterRequest;
import com.sajith.udurawana.CRUDDemo.entity.Role;
import com.sajith.udurawana.CRUDDemo.repository.UserRepository;
import com.sajith.udurawana.CRUDDemo.service.AuthService;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	/**
	 * CommandLineRunner bean for testing.
	 */
	@Bean
	CommandLineRunner commandLineRunner(AuthService service, UserRepository userRepo) {
		return args -> {
			var users = userRepo.count();
			if (users == 0) {
				var user = RegisterRequest.builder().email("user@email.com").password("password")
						.role(Role.USER).build();
				System.out.print("Token: " + service.register(user).getToken());
			}
		};
	}
}
