package DAOMySQL;

import DAO.DAOException;
import DAO.IRecetaDAO;
import Modelo.Receta;
import MySQLConexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @authors Alanstark & DiegoRoque
 */
public class MySQLRecetaDAO implements IRecetaDAO  {
    //propiedades para manipular  la base de datos 
    private  Connection conn;// = null;
    private ResultSet rs;//= null;
    private PreparedStatement ps;// = null;   
    
    //Consultas SQL preconfiguradas
    private final String INSERT = "INSERT INTO receta (diagnostico, medicamentos, idPaciente)" + " VALUES (?,?,?)";
    private final String UPDATE = "UPDATE receta SET idReceta = ?, diagnostico = ?, medicamentos = ?" + " WHERE receta.idPaciente = ?";
    private final String DELETE = "DELETE FROM receta WHERE receta.idReceta = ?";
    private final String GETALL = "SELECT idReceta, diagnostico, medicamentos, idPaciente FROM receta";
    private final String GETONE = "SELECT idReceta, diagnostico, medicamentos, idPaciente FROM receta WHERE receta.idReceta = ?";

    @Override
    public void insertar(Receta receta) throws DAOException {
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);//la constante RETURN_GENERATED_KEYS de la interfaz PreparedStatement, 
            //ya que se desea obtener el número de la cita generada por el DBMS al insertar una nueva.
            ps.setString(1, receta.getDiagnostico());
            ps.setString(2, receta.getMedicamentos());
            ps.setInt(3, receta.getIdPaciente());
            
            //ejecutamos la consulta y especificamos los parámetros  de entrada
            if(ps.executeUpdate() == 0){//if 1.0
                throw new  DAOException("No se pudo guardar la nueva receta");
            }else{
                rs = ps.getGeneratedKeys();
                if(rs.next()){//if 1.1
                    receta.setIdReceta(rs.getInt(1));//obtención y asignación a la propiedad del objeto cita
                }else{
                    throw new  DAOException("No se pudo asignar el numero de esta receta");
                }//fin del if 1.1
            }//fin del if 1.0
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }//fin del método insertar

    @Override
    public void modificar(Receta receta) throws DAOException {
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(UPDATE);
            ps.setInt(1, receta.getIdReceta());
            ps.setString(2, receta.getDiagnostico());
            ps.setString(3, receta.getMedicamentos());
            ps.setInt(4, receta.getIdPaciente());
           
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0){//si es igual con 0 es que hubo un problema 
                throw new  DAOException("Hubo un problema y no se guardaron los cambios");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }//fin del método modificar

    @Override
    public void eliminar(Integer id) throws DAOException {
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(DELETE);
            ps.setInt(1, id);
           
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0){//si es igual con 0 es que hubo un problema 
                throw new  DAOException("Hubo un problema y no se pudo eliminar la receta");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }//fin del método eliminar
////idReceta, diagnostico, medicamentos, idPaciente
    @Override
    public List<Receta> obtenerTodos() throws DAOException {
        //lista de citas a retornar
        List <Receta> misRecetas = new ArrayList<Receta>();
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(GETALL);
           
            //ejecutamos la consulta y almacenamos el resultado el un objeto ResultSet
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item  al arrayList
            while(rs.next()){
                Receta miReceta = new Receta();
                miReceta.setIdReceta(rs.getInt("idReceta"));
                miReceta.setDiagnostico(rs.getString("diagnostico"));
                miReceta.setMedicamentos(rs.getString("medicamentos"));
                miReceta.setIdPaciente(rs.getInt("idPaciente"));
                misRecetas.add(miReceta);
            }//fin del while
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
        return(misRecetas);
    }//fin del método obtener todos

    @Override
    public Receta obtener(Integer id) throws DAOException {
        //lista de recetas 
        Receta miReceta = null;
             try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y definimos sus parametros que recibe la consulta
            ps =  conn.prepareStatement(GETONE);
            ps.setInt(1, id);
           
            //ejecutamos la consulta y almacenamos el resultado el un objeto ResultSet
            rs = ps.executeQuery();
            
            //verificamos  si el resultSet obtuvo un resultado y lo asignamos  al objeto correspondiente 
             if(rs.next()){
                miReceta = new Receta();
                miReceta.setIdReceta(rs.getInt("idReceta"));
                miReceta.setDiagnostico(rs.getString("diagnostico"));
                miReceta.setMedicamentos(rs.getString("medicamentos"));
                miReceta.setIdPaciente(rs.getInt("idPaciente"));
            }else {
                throw new DAOException("No se encontro el elemento");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
        return (miReceta);  
    }//fin del método obtener
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
}//fin de la clase
