package DAOMySQL;
import DAO.DAOManager;
import DAO.ICitaDAO;
import DAO.IPacienteDAO;//para el objeto paciente
import DAO.IRecetaDAO;
import DAO.IUsuarioDAO;
/**
 * En esta clase usamos el patrón singleton para reutilizar objetos si ya han 
 * sido creados
 * El patron singleton permite restringir la creación de objetos pertenecientes 
 * a una clase o el valor de un tipo a un único objeto.
 * @authors Alanstark & DiegoRoque
 */
public class MySQLDAOManager implements DAOManager {
    private IPacienteDAO pacientes = null;
    private ICitaDAO citas = null;
    private IRecetaDAO recetas = null;
    private IUsuarioDAO usuario = null;
    
    @Override
    public IRecetaDAO getRecetaDAO() {
        if(recetas == null){
           recetas = (IRecetaDAO)new MySQLRecetaDAO();
        }
        return (recetas);
    }// fin de  getRecetaDAO
    
    @Override
    public IPacienteDAO getPacienteDAO() {
       if(pacientes == null){
            pacientes = new MySQLPacienteDAO();
        }
        return (pacientes);
    }// fin de  getPacienteDAO
    
    @Override
    public ICitaDAO getCitaDAO() {
       if(citas == null){
            citas = new MySQLCitaDAO();
        }
        return (citas);
    }// fin de  getCitaDAO

    public IUsuarioDAO getUsuarioDAO() {
       if(usuario == null){
            usuario = new MySQLUsuarioDAO();
        }
        return (usuario);
    }// fin de  getCitaDAO
     
}//fin de la clase
