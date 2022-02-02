package pe.com.oh.controller.util;

import pe.com.oh.domain.reponse.OhException;

public class Utils {

	public static final String MENSAJE_ERROR = "Se produjo el siguiente error: ";
	public static final String MENSAJE_UPDATE = "Registro actualizada exitosamente: ";
	public static final String MENSAJE_CREATE = "Registro creado exitosamente: ";
	public static final String MENSAJE_DELETE = "Registro eliminada exitosamente.";

	
	private Utils() {
	}
	
	public static void generateException(String message, Object object){
            throw new OhException(message, object);
    }
	
}
