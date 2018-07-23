package com.mydb;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.domain.*;
import com.service.*;

import com.repository.Postrepository;

//(scanBasePackages={"com.repository"})
@SpringBootApplication 
@EntityScan(basePackages= {"com.domain"})
@EnableJpaRepositories("com.repository")
@ComponentScan({"com.service"})
public class H2dbApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(H2dbApplication.class);

	@Autowired
	Postrepository postRepository;
	
	@Autowired
	DataLoader dataloader;
	
	
	public static void main(String[] args) {
		SpringApplication.run(H2dbApplication.class, args);
		logger.info("App is running");
	}
	
	@PostConstruct
	void seePosts() {
		logger.info("seePosts method called....");
		for(Post posts : postRepository.findAll()) {
			logger.info(posts.toString());
		}
	}
	
}
