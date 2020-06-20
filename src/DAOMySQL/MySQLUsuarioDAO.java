package DAOMySQL;

import DAO.DAOException;
import DAO.IUsuarioDAO;
import Modelo.Usuario;
import MySQLConexion.Conectar;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * @author Alanstark & DiegoRoque
 */
public class MySQLUsuarioDAO implements IUsuarioDAO {
    
    //propiedades para manipular  la base de datos 
    private  Connection conn;// = null;
    private ResultSet rs;//= null;
    private PreparedStatement ps;// = null;  
    
    //Consultas SQL preconfiguradas
    private final String VALIDAR = "SELECT * FROM usuario WHERE idUsuario = ? AND password = md5(?)";

    @Override
    public int validar(Usuario a) throws DAOException {
          int count = 0;
             try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y definimos sus parametros que recibe la consulta
            ps =  conn.prepareStatement(VALIDAR);
            ps.setString(1, a.getIdUsuario());
            ps.setString(2, a.getPassword());
  
            //ejecutamos la consulta y almacenamos el resultado el un objeto ResultSet
            rs = ps.executeQuery();
            if ( rs.next() ){
                count = 1;
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
         return (count);        
    }//fin del método validar
    
    @Override
    public void insertar(Usuario a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Usuario a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtener(String idusuario) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
     private void cerrarConexiones
            (PreparedStatement ps, ResultSet rs, Connection conn) throws  DAOException{
                try{
                    if(rs != null){
                        rs.close();
                    }
                    if(ps != null){
                        ps.close();
                    }
                    if(conn != null){
                        conn.close();
                    }
                }catch(SQLException ex) {
                    throw new DAOException("Error en  SQL", ex);
                }
            }//fin del método cerrarConexiones
}//fin de la clase MySQLUsuarioDAO
