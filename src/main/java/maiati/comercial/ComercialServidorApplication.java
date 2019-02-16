package maiati.comercial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ComercialServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComercialServidorApplication.class, args);
		
		//gerarSenha();
	}
	
	/* test para criptografar a senha
	private static void gerarSenha() {
		System.out.println(new BCryptPasswordEncoder().encode("0123"));
	}
	*/

}

