package com.learn;

import com.learn.models.User;
import com.learn.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityLearnApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setEmail("aswad@123");
		user.setPassword(this.bCryptPasswordEncoder.encode("123"));
		user.setUsername("Asvad");
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);

		User user1=new User();
		user1.setEmail("sahbaz@123");
		user1.setPassword(this.bCryptPasswordEncoder.encode("123786"));
		user1.setUsername("sahbaz");
		user1.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
	}

}
