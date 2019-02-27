package maiati.comercial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UploadException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UploadException(String msg) {
		super(msg);
		
	}

}
