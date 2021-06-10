package com.RBG.Blog.Servico.SImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RBG.Blog.Entidades.Post;
import com.RBG.Blog.Repositorios.PostRepositorio;
import com.RBG.Blog.Servico.Servico;

/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\/<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Classe que irá construir os métodos de listar todos os posts, listar
um post específico, salvar e excluir um post no banco de dados
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/\<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

@Service
public class SImple implements Servico{

	@Autowired
	PostRepositorio postRep;
	
	@Override
	public List<Post> findAll() {		
		return postRep.findAll();
	}

	@Override
	public Post findByID(long id) {		
		return postRep.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return postRep.save(post);
	}
	
	@Override
	public void deleteByID(long id) {
		postRep.deleteById(id);
	}

}
