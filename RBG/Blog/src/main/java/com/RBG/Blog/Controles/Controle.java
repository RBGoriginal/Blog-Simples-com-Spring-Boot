package com.RBG.Blog.Controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RBG.Blog.Entidades.Post;
import com.RBG.Blog.Servico.Servico;

import java.time.LocalDate;
import java.util.*;

import javax.validation.Valid;

/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\/<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Classe que irá definir os controles do blog, executando os métodos para 
visualizar, criar, editar, excluir posts e autenticar quando necessário 
por meio do endereço web especificado
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/\<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

@Controller
public class Controle {

	@Autowired
	private Servico postagem;
		
	@GetMapping("/Blog")
	public ModelAndView posts(){
		ModelAndView MV = new ModelAndView("posts");
		List<Post> posts = postagem.findAll();
		MV.addObject("posts",posts);
		return MV;
	}
	
	@GetMapping("/Blog/{id}")
	public ModelAndView postEspecifc(@PathVariable("id") long id){
		ModelAndView MV = new ModelAndView("postEspecifico");
		Post postE = postagem.findByID(id);
		MV.addObject("post",postE);
		return MV;
	}
		
	@GetMapping("/NovoPost")
	public String CriarPost() {
		return "novoPost";
	}
	
	@PostMapping("/NovoPost")
	public String publicarPost(@Valid Post post, BindingResult result, RedirectAttributes atributo ) {
		if(result.hasErrors()){
			atributo.addFlashAttribute("Erro","Algum campo não foi preenchido!!!");
			return "redirect:/NovoPost";
		}		
		post.setDataCriacao(LocalDate.now().toString());
		postagem.save(post);
		return "redirect:/Blog";		
	}
	
	@GetMapping("/Editar/{id}")
	public ModelAndView editarPost(@PathVariable("id") long id){
		ModelAndView MV = new ModelAndView("editaPost");
		Post post = postagem.findByID(id);
		MV.addObject("post",post);
		return MV;
	}
	
	@PostMapping("/Alterar")
	public ModelAndView editarPost(@Valid Post post, BindingResult result, RedirectAttributes atributo ) {
		ModelAndView MV = new ModelAndView();
		if(result.hasErrors()){
			atributo.addFlashAttribute("Erro","Algum campo não foi preenchido!!!");
			MV.setViewName("redirect:/Editar/"+post.getId());
			return MV;
		}
		post.setId(post.getId());
		post.setDataCriacao(LocalDate.now().toString());
		postagem.save(post);
		MV.setViewName("redirect:/Blog/"+post.getId());
		return MV;				
	}
	
	@GetMapping("/Excluir/{id}")
	public String excluirPost(@PathVariable("id") long id) {
		postagem.deleteByID(id);
		return "redirect:/Blog";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
