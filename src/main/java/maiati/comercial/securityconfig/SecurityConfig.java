package maiati.comercial.securityconfig;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

	/* liberando acessos de padrão */
	private static final String[] PUBLIC_MATCHERs_GETS = { "/**", "images/**", };

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// liberando todos os acessos quando em fase de test. para usar o profeli de
		// test e acesso o h2-console
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.cors().and().csrf().disable();

		http.authorizeRequests().antMatchers(PUBLIC_MATCHERs_GETS).permitAll().anyRequest().authenticated().and()

				/* filtragem do login - passando pela class SecurityAuthentication */
				.addFilterBefore(new SecurityAuthentication("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)

				/* filtragem das requisições - passando pela class JWTFilter */
				.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	/*
	 * Configuração para Realizar a autenticação do usuario - Pegando suas
	 * credencias e autorizações
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT login, senha, 1 as enabled FROM usuario WHERE login=?")
				.authoritiesByUsernameQuery("SELECT login, 'ROLE USER' FROM usuario WHERE login=?")
				.passwordEncoder(new BCryptPasswordEncoder()); // faz a criptografia da senha do Usuairo
	}

	/* Configuração do Cors da Aplicação */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;

	}

	/* Customizando as Datas */
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer dateCustomizer() {
		return new Jackson2ObjectMapperBuilderCustomizer() {

			@Override
			public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
				
				jacksonObjectMapperBuilder.simpleDateFormat("dd-MM-yyyy");

				
			}

		};
	}

}
