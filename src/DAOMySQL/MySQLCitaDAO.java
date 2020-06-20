package DAOMySQL;

import DAO.DAOException;
import DAO.ICitaDAO;
import Modelo.Cita;
import MySQLConexion.Conectar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @authors Alanstark & DiegoRoque
 */
public class MySQLCitaDAO implements ICitaDAO {
    
   //propiedades para manipular  la base de datos 
    private  Connection conn;// = null;
    private ResultSet rs;//= null;
    private PreparedStatement ps;// = null;   
    
    //Consultas SQL preconfiguradas
    private final String INSERT = "INSERT INTO cita (fechaCita, motivoCita, idPaciente)" + " VALUES (?,?,?)";
    private final String UPDATE = "UPDATE cita SET numeroCita = ?, fechaCita = ?, motivoCita = ?" + " WHERE cita.idPaciente = ?";
    private final String DELETE = "DELETE FROM cita WHERE cita.numeroCita = ?";
    private final String GETALL = "SELECT numeroCita, fechaCita, motivoCita, idPaciente FROM cita";
    private final String GETONE = "SELECT numeroCita, fechaCita, motivoCita, idPaciente FROM cita WHERE cita.numeroCita = ?";

    @Override
    public void insertar(Cita cita) throws DAOException {
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);//la constante RETURN_GENERATED_KEYS de la interfaz PreparedStatement, 
            //ya que se desea obtener el número de la cita generada por el DBMS al insertar una nueva.
            ps.setDate(1, (Date) cita.getFechaCita());
            ps.setString(2, cita.getMotivoCita());
            ps.setInt(3, cita.getIdPaciente());
                     
            //ejecutamos la consulta y especificamos los parámetros  de entrada
            if(ps.executeUpdate() == 0){//if 1.0
                throw new  DAOException("No se pudo guardar la nueva cita");
            }else{
                rs = ps.getGeneratedKeys();
                if(rs.next()){//if 1.1
                    cita.setNumeroCita(rs.getInt(1));//obtención y asignación a la propiedad del objeto cita
                }else{
                    throw new  DAOException("No se pudo asignar el numero de esta cita");
                }//fin del if 1.1
            }//fin del if 1.0
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }//fin del método sobrecargado insertar

    @Override
    public void modificar(Cita cita) throws DAOException {
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(UPDATE);
            ps.setInt(1, cita.getNumeroCita());
            ps.setDate(2, (Date) cita.getFechaCita());
            ps.setString(3, cita.getMotivoCita());
            ps.setInt(4, cita.getIdPaciente());
           
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0){//si es igual con 0 es que hubo un problema 
                throw new  DAOException("Hubo un problema y no se guardaron los cambios");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }

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
                throw new  DAOException("Hubo un problema y no se pudo eliminar la cita");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }//fin del método eliminar

    @Override
    public List<Cita> obtenerTodos() throws DAOException {
        //lista de citas a retornar
        List <Cita> misCitas = new ArrayList<Cita>();
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(GETALL);
           
            //ejecutamos la consulta y almacenamos el resultado el un objeto ResultSet
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item  al arrayList
            while(rs.next()){
                Cita miCita = new Cita();
                miCita.setNumeroCita(rs.getInt("numeroCita"));
                miCita.setFechaCita(rs.getDate("fechaCita"));
                miCita.setMotivoCita(rs.getString("motivoCita"));
                miCita.setIdPaciente(rs.getInt("idPaciente"));
                misCitas.add(miCita);
            }//fin del while
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
        return(misCitas);
    }//fin del método obtener todas las citas

    @Override
    public Cita obtener(Integer id) throws DAOException {
        //lista de citas 
        Cita miCita = null;
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
                miCita = new Cita();
                miCita.setNumeroCita(rs.getInt("numeroCita"));
                miCita.setFechaCita(rs.getDate("fechaCita"));
                miCita.setMotivoCita(rs.getString("motivoCita"));
                miCita.setIdPaciente(rs.getInt("idPaciente"));
            }else {
                throw new DAOException("No se encontro el elemento");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
        return (miCita);
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
    
}//fin de la interfaz
