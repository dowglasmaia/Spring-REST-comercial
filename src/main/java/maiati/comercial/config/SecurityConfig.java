package maiati.comercial.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated();		
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
