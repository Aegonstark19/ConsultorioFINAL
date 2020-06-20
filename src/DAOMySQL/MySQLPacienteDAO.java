package DAOMySQL;
import MySQLConexion.Conectar;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import DAO.DAOException;
import DAO.IPacienteDAO;
import Modelo.Paciente;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @authors Alanstark & DiegoRoque
 */
public class MySQLPacienteDAO implements IPacienteDAO {
     //propiedades para manipular  la base de datos 
    private  Connection conn;// = null;
    private ResultSet rs;//= null;
    private PreparedStatement ps;// = null;   
    
    //Consultas SQL preconfiguradas
    private final String INSERT = "INSERT INTO paciente (nombrePaciente, apellidoPaciente, direccionPaciente, telefonoPaciente, emailPaciente, edadPaciente)" + " VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE paciente SET nombrePaciente = ?, apellidoPaciente = ?, direccionPaciente = ?, telefonoPaciente = ?,emailPaciente = ?, edadPaciente = ?" + " WHERE idPaciente = ?";
    private final String DELETE = "DELETE FROM paciente WHERE idPaciente = ?";
    private final String GETALL = "SELECT idPaciente, nombrePaciente, apellidoPaciente, direccionPaciente, telefonoPaciente, emailPaciente, edadPaciente FROM paciente";
    private final String GETONE = "SELECT idPaciente, nombrePaciente, apellidoPaciente, direccionPaciente, telefonoPaciente, emailPaciente, edadPaciente FROM paciente WHERE idPaciente = ?";

    @Override
    public void insertar(Paciente paciente) throws DAOException {
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);//la constante RETURN_GENERATED_KEYS de la interfaz PreparedStatement, 
            //ya que se desea obtener el Id. del paciente generado por el DBMS al insertar uno nuevo.
            ps.setString(1, paciente.getNombrePaciente());
            ps.setString(2, paciente.getApellidoPaciente());
            ps.setString(3, paciente.getDireccionPaciente());
            ps.setString(4, paciente.getTelefonoPaciente());
            ps.setString(5, paciente.getEmailPaciente());
            ps.setInt(6, paciente.getEdadPaciente());
                        
            //ejecutamos la consulta y especificamos los parámetros  de entrada
            if(ps.executeUpdate() == 0){//if 1.0
                throw new  DAOException("No se pudo guardar el nuevo paciente");
            }else{
                rs = ps.getGeneratedKeys();
                if(rs.next()){//if 1.1
                    paciente.setIdPaciente(rs.getInt(1));//obtención y asignación a la propiedad del objeto paciente
                }else{
                    throw new  DAOException("No se pudo asignar el ID de este paciente");
                }//fin del if 1.1
            }//fin del if 1.0
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }//fin del método insertar

    @Override
    public void modificar(Paciente paciente) throws DAOException {
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(UPDATE);
            ps.setString(1, paciente.getNombrePaciente());
            ps.setString(2, paciente.getApellidoPaciente());
            ps.setString(3, paciente.getDireccionPaciente());
            ps.setString(4, paciente.getTelefonoPaciente());
            ps.setString(5, paciente.getEmailPaciente());
            ps.setInt(6, paciente.getEdadPaciente());
            ps.setInt(7, paciente.getIdPaciente());
            
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
                throw new  DAOException("Hubo un problema y no se pudo eliminar el paciente");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
    }//fin del método eliminar

    @Override
    public List<Paciente> obtenerTodos() throws DAOException {
        //lista de autores a retornar
        List <Paciente> misPacientes = new ArrayList<Paciente>();
        try{
            //creamos la conexión a la base de datos 
            conn = Conectar.realizarConexion();
            
            //preparamos  la consulta y especificamos  los parametros  de entrada 
            ps =  conn.prepareStatement(GETALL);
            
           
            //ejecutamos la consulta y almacenamos el resultado el un objeto ResultSet
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item  al arrayList
            while(rs.next()){
                Paciente miPaciente = new Paciente();
                miPaciente.setIdPaciente(rs.getInt("idPaciente"));
                miPaciente.setNombrePaciente(rs.getString("nombrePaciente"));
                miPaciente.setApellidoPaciente(rs.getString("apellidoPaciente"));
                miPaciente.setDireccionPaciente(rs.getString("direccionPaciente"));
                miPaciente.setTelefonoPaciente(rs.getString("telefonoPaciente"));
                miPaciente.setEmailPaciente(rs.getString("emailPaciente"));
                miPaciente.setEdadPaciente(rs.getInt("edadPaciente"));
                
                misPacientes.add(miPaciente);
            }//fin del while
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
        return(misPacientes);
    }//fin del método obtener todos los pacientes

    @Override
    public Paciente obtener(Integer id) throws DAOException {
        //lista de autores 
        Paciente miPaciente = null;
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
                miPaciente = new Paciente();
                miPaciente.setIdPaciente(rs.getInt("idPaciente"));
                miPaciente.setNombrePaciente(rs.getString("nombrePaciente"));
                miPaciente.setApellidoPaciente(rs.getString("apellidoPaciente"));
                miPaciente.setDireccionPaciente(rs.getString("direccionPaciente"));
                miPaciente.setTelefonoPaciente(rs.getString("telefonoPaciente"));
                miPaciente.setEmailPaciente(rs.getString("emailPaciente"));
                miPaciente.setEdadPaciente(rs.getInt("edadPaciente"));
            }else {
                throw new DAOException("No se encontro el elemento");
            }
        }catch(SQLException ex){
            throw new DAOException ("Error de SQL; ",ex);
        }finally{
            cerrarConexiones(ps, rs, conn);//Los parámetros que recibe el método son los recursos que fueron utilizados en cada método.
        }//fin del finally
        return (miPaciente);
    }//fin del método obtener paciente
    
    
    @Override
    public JasperPrint imprimirReporte(String path) throws DAOException{
        
        JasperPrint jprint = null;
        JasperReport reporte = null;
        try{
            conn = Conectar.realizarConexion();
            try{
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                jprint = JasperFillManager.fillReport(reporte, null, conn);
            }catch( JRException ex){
                //usar Logger.
            }
        }catch(SQLException ex){
            throw new DAOException ( "Error en SQL: ", ex);
        }
        return jprint;
    }
    
    public JasperPrint imprimirReporte (String path, Map parametro) throws DAOException{
        JasperPrint jprint = null;
        JasperReport reporte = null;
        try{
            conn = Conectar.realizarConexion();
            try{
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            }catch( JRException ex){
                //usar Logger.
            }
        }catch(SQLException ex){
            throw new DAOException ( "Error en SQL: ", ex);
        }
        return jprint;
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
}//fin de la clase MySQLPacienteDAO
