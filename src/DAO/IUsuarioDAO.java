package DAO;
import Modelo.Usuario;
/**
 * @author Alanstark & DiegoRoque
 */
public interface IUsuarioDAO extends IDAO<Usuario, String> {
    /**
     * Este método valida si el usuario introducido corresponde con el usuario
     * guardado en la base de datos 
     * @param usuario recibe un objeto de tipo usuario
     * @return regresa 1 si el usuario existe o 0 si no existe
     * @throws DAOException 
     */
    int validar (Usuario usuario) throws DAOException;
}
