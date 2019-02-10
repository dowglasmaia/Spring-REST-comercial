package maiati.comercial.config;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import maiati.comercial.model.cadastros.Usuario;
/** 
 * @author Dowglas Maia
 * Class  de Configuração do Token
 * */
public class SecurityAuthentication extends AbstractAuthenticationProcessingFilter {

	protected SecurityAuthentication(String url, AuthenticationManager manager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(manager);

	}

	/* Metodo para Realizar a Autenticação do usuario */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		// Convert JSON que vem da requisão para Objeto no caso aqui, o Usuario.
		Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

		/*Retorna as credencias e autorizações do usuario */
	return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						usuario.getLogin(), 
						usuario.getSenha(), 
						new ArrayList<>()));

	}
	
	/* Metodo chamado quando o usuario for autenticado -  com Sucesso*/
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		super.successfulAuthentication(request, response, chain, authResult);
	}

}
