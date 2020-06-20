package consultorioFinal;
import Vista.JDCita;
import Vista.JFrmVentanaPrincipal;
/**
 * @authors Alanstark & DiegoRoque
 */
public class ConsultorioFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //objeto para poder abrir el Jframe
        JFrmVentanaPrincipal miJFrmVentanaPrincipal = new JFrmVentanaPrincipal();
        miJFrmVentanaPrincipal.setTitle("Gestionar Consultorio");
        miJFrmVentanaPrincipal.setLocationRelativeTo(null);
        miJFrmVentanaPrincipal.setVisible(true);
    }//fin del método static void main
}//fin de la clase
