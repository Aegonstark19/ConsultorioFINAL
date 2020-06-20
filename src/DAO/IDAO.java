package DAO;
import java.util.List;
/**
* @authors Alanstark & DiegoRoque
* @param <T> (hace referencia a un dato especificado por el usuario; un paciente) 
* @param <K> (hace referencia a un dato primitivo o a su clase correspondiente; int-INTEGER) 
* La a es el nombre de la variable o del objeto.
*/
public interface IDAO <T, K>{
    void insertar (T a) throws DAOException;//el método recibe un tipo de dato genérico, que debe de corresponder con el de una clase DAO que se tenga y que debe ser igual al de la declaración de la interface
    void modificar (T a) throws DAOException;//T hace referencia a la clase autores (o cualquiera de las clases de la lógica de negocio)
    void eliminar (K id) throws DAOException;//la K (key) al tipo de dato correspondiente al id de la tabla (int, string, el que corresponda con la clave primaria de la tabla).
    List<T> obtenerTodos() throws DAOException;
    T obtener (K id) throws DAOException;
   
}//fin de la interface
