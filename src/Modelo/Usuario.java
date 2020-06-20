package Modelo;
/**
 * la clase Usuario contendrá únicamente los campos que representen la 
 * estructura de la tabla receta con sus constructores y 
 * los descriptores de acceso (getters y setters).
 * @authors Alanstark & DiegoRoque
 */
public class Usuario {
    //la contraseña y el nombre
    private String idUsuario ="";// = "docsimi";
    private String password ="";// = 38192607;
    
//constructor
    public Usuario() {
    }
//constructor no vacío

    public Usuario(String idUsuario, String password) {
        this.idUsuario = idUsuario;
        this.password = password;
    }
    
       
    //getters
    public String getIdUsuario() {
        return this.idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}//fin de la clase Usuario
