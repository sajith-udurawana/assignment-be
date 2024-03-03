package com.sajith.udurawana.CRUDDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	/**
	 * CommandLineRunner bean for testing user registration.
	 * Registers a user with predefined credentials and prints the generated token.
	 * Uncomment and configure as needed for testing purposes.
	 */
	// @Bean
	// CommandLineRunner commandLineRunner(AuthService service) {
	// return args -> {
	// var user =
	// RegisterRequest.builder().email("user@company.com").password("password")
	// .role(Role.USER).build();
	// System.out.print("Token: " + service.register(user).getToken());
	// };
	// }
}
