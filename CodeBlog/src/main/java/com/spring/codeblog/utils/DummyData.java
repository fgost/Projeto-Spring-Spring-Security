package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {
	
	@Autowired
	CodeblogRepository codeblogRepository;
	
	//@PostConstruct
	public void savePosts(){
		
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("Matheus A. L. Firmiano");
		post1.setData(LocalDate.now());
		post1.setTitulo("O que é a realidade?");
		post1.setTexto("Existe uma realidade física que é independente de nós? A realidade objetiva existe? Ou a estrutura de tudo, incluindo o tempo e o espaço, é criada pelas percepções do observador?");
		
		Post post2 = new Post();
		post2.setAutor("Karina S. N Firmiano");
		post2.setData(LocalDate.now());
		post2.setTitulo("A perversa tradição europeia!");
		post2.setTexto("Os povos indígenas viveram na Floresta Amazônica por milênios sem causar perdas ou distúrbios detectáveis de espécies. Por outro lado, em 500 anos de cultura e tradição europeia, onde estão nossas florestas?");
		
		postList.add(post1);
		postList.add(post2);
		
		for(Post post: postList){
			Post postSaved = codeblogRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}
}