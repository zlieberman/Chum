package com.zlieberman.chum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.zlieberman.chum.model.AccountType;
import com.zlieberman.chum.model.ChumUser;
import com.zlieberman.chum.repository.UserRepository;

@SpringBootApplication
@EnableMongoRepositories
public class ChumApplication {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChumApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			ChumUser user = new ChumUser(
					"CannedMoles", 
					"Bryan", 
					"Wu", 
					"wupengclan@gmail.com", 
					AccountType.DEFAULT
			);
			
			userRepository.save(user);
		};
	}

}
