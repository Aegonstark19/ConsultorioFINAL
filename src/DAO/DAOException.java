package DAO;
/**
 * @authors Alanstark & DiegoRoque
 * esta clase se encargará de regresar el mensaje de error causado 
 * por la aplicación, si es que sucede 
 */
public class DAOException extends Exception {
    
    public DAOException (String message){
        super(message);
    }
    
    public DAOException (String message, Throwable cause){
        super(message, cause);
    }
    
    public DAOException (Throwable cause){
        super(cause);
    }   
}//fin de la clase
