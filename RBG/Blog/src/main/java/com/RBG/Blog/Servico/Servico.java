package com.RBG.Blog.Servico;

import java.util.*;

import com.RBG.Blog.Entidades.Post;

/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\/<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Interface que irá definir como os métodos de listar todos os posts, mostrar
um post específico, salvar e excluir um post serão construidos
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/\<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

public interface Servico {

	List<Post> findAll();
	Post findByID(long id);
	Post save(Post post);
	void deleteByID(long id);
}
