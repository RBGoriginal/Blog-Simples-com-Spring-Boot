package com.RBG.Blog.PostDefault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RBG.Blog.Entidades.Post;
import com.RBG.Blog.Repositorios.PostRepositorio;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\/<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Classe que irá adicionar o primeiro post exemplo no banco de dados
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/\<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

@Component
public class PrimeiroPost {
	
	@Autowired
	PostRepositorio postRep;
	
	@PostConstruct
	public void saveDefault() {
		
		Post FirstPost = new Post();
		FirstPost.setAuthor("Rodrigo B.G.");
		FirstPost.setDataCriacao(LocalDate.now().toString());
		FirstPost.setTitulo("Primeiro Post");
		FirstPost.setBody("Fala pessoal, esse é o primeiro post do blog. Quem está postando é o Rodrigo B.G. e espero que esteja funcionando kk. Na verdade está, pois se você está lendo isso significa que o programa está funcional. Bom, acho que já deu para encher o body da minha postagem. Você que leu até aqui, tenha um bom dia, uma boa tarde e uma boa noite. E que a força esteja com você. Tan tan tan tan tantan tan tantan. Leia novamente imaginando o som tema do lord Darth Vader.");
		
		Post salvo = postRep.save(FirstPost);
		System.out.println(salvo.getId());
	}
	
}
