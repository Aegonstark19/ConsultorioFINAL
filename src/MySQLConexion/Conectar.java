package MySQLConexion;
//importando las librerias necesarias, en la línea 8 a 10, se hace referencia al paquete java.sql.   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * En la clase Conectar, definimos los parámetros de conexión a la base de datos
 * @authors Alanstark & DiegoRoque
 */
public class Conectar {
//propiedades para la conexion a la base de datos
    //De la línea 20 a 23  definimos unas constantes de tipo String para los parámetros que nos requerirán los métodos que sean llamados para realizar la conexión a la base de datos.
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";//nombre del controlador jdbc
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String URL_BASEDEDATOS = "jdbc:mysql://localhost:3306/Consultorio?useSSL=false";
    private static  Connection conn = null;//el objeto de tipo connection
    
    /**
     * Realizamos la  conexión con la base de datos 
     * @return
     * @throws SQLException 
     */
    public static Connection realizarConexion() throws SQLException{
        try {
            Class.forName(CONTROLADOR);//carga la clase controlador
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);//establece la conexión a la base de datos 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (conn);   
    }//fin del método realizarConexion
    
    /**
     * Realiza la desconexion de la base de datos 
     * @throws SQLException 
     */
    public static void realizarDesconexion()throws SQLException{
        if( conn!= null){
            conn.close();//cierra la conexion a la base de datos
        }//fin del if
    }//fon del método realizarDesconexión        
}//fin de la clase Conectar
