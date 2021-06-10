package com.RBG.Blog.Autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\/<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
Classe que irá habilitar a segurança do Blog, solicitando, quando necessário, o
usuário e a senha para acessar as funções importantes do site.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/\<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{

		@Override
	    public void configure(WebSecurity web) throws Exception{
	        web.ignoring().antMatchers("/css/**","/img/**");
	    }
		    
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("Admin").password("{noop}Admin").roles("ADMIN");		
		}

	    @Override
	    protected void configure(HttpSecurity http) throws Exception{
	        http.csrf().disable().authorizeRequests()
	                .antMatchers("/Blog","/Blog/{id}").permitAll()
	                .anyRequest().authenticated()
	                .and().formLogin().loginPage("/login").permitAll()
	                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/Logout")).logoutSuccessUrl("/Blog");
	    }    
}