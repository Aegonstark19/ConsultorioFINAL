package DAO;
import Modelo.Paciente;
import java.util.Map;
import net.sf.jasperreports.engine.JasperPrint;
/**
 * @authors Alanstark & DiegoRoque
 */
public interface IPacienteDAO extends IDAO <Paciente, Integer> {
    /**
     * Este método se usa para imprimir los reportes
     * @param path es la ubicación del reporte .jasper
     * @return un objeto de tipo JasperPrint
     * @throws DAOException 
     */
    public JasperPrint imprimirReporte(String path) throws DAOException;
    
    public JasperPrint imprimirReporte(String path, Map parametro) throws DAOException;
    
}
