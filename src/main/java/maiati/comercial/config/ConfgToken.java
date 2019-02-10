package maiati.comercial.config;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/** 
 * Class Responsavel por Gerar e Verificar se o tem e Valido
 * 
 *  */
public class ConfgToken {
	
	private static String CHAVE = "maia-chave-token";
	
	//gerar Token - Algoritimmo para geração neste caso é o HS512 - https://jwt.io/
	public static String gerarToken (String subject) {
		String token = Jwts.builder()
					.setSubject(subject)
					.setExpiration(new Date(System.currentTimeMillis() + (1 * 60000)))
					.signWith(SignatureAlgorithm.HS512, "")
					.compact();
		return token;
	}

}