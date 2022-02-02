package pe.com.oh.domain.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OhException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	private Object success;

}
