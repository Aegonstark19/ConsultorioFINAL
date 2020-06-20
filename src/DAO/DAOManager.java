package DAO;
/**
 * @authors Alanstark & DiegoRoque
 * mediante esta interfaz haremos una forma centralizada de pedir cualquier DAO,
 * del paciente, receta, cita y usuario 
 */
public interface DAOManager {
    
   IPacienteDAO getPacienteDAO();
   ICitaDAO getCitaDAO();
   IRecetaDAO getRecetaDAO();
   IUsuarioDAO getUsuarioDAO();
}//fin de la clase
