package com.RBG.Blog.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\/<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Classe que irá definir as entidades a serem salvas na tebela Post do 
banco de dados
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/\<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String author;
	
	@NotBlank
	private String titulo;	
	
	@NotBlank
	@Lob
	private String body;
	
	private String DataCriacao;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDataCriacao() {
		return DataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.DataCriacao = dataCriacao;
	}
	
	
}
