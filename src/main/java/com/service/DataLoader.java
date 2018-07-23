package com.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.domain.*;
import com.repository.*;

@Service
public class DataLoader {

	private Postrepository postRepository;
	private Authorrepository authorRepository;
	
	@Autowired
	public DataLoader(Postrepository postRepository, Authorrepository authorRepository) {
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}
	
	@PostConstruct
	void loadData() {
		Author av = new Author("Malla","Akash");
		authorRepository.save(av);
		Post posts = new Post("Spring Data Rocks");
		posts.setBody("Post Body is here");
		posts.setPostedOn(new Date());
		posts.setAuthor(av);
		postRepository.save(posts);
	}
}
