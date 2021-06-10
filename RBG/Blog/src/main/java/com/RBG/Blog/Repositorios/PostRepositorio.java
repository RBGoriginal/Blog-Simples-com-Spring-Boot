package com.RBG.Blog.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RBG.Blog.Entidades.Post;

/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\/<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Interface que irá definir o JPA que tem diversos métodos para facilitar a 
manipulação dos dados do Blog no banco de dados 
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/\<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

public interface PostRepositorio extends JpaRepository<Post, Long>{

}
