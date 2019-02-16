package maiati.comercial.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()  /* Usar o .csrf().disable() - somente em Ambiente de Desenvolvimento  */
		.antMatchers("/login").permitAll()
		.antMatchers("/error").permitAll()
		.anyRequest().authenticated()
		.and()
		
		/* filtragem do login - passando pela class SecurityAuthentication*/
		.addFilterBefore(new SecurityAuthentication("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		
		/*filtragem das requisições - passando pela class JWTFilter */
		.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class);	
	
	}	
	
	/* Configuração para Realizar a autenticação do usuario -  Pegando suas credencias e autorizações*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT login, senha, 1 as enabled FROM usuario WHERE login=?")
		.authoritiesByUsernameQuery("SELECT login, 'ROLE USER' FROM usuario WHERE login=?") 
		.passwordEncoder(new BCryptPasswordEncoder()); // faz a criptografia da senha do Usuairo
	}

}
