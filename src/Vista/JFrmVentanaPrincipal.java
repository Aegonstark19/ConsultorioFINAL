package Vista;

import DAO.DAOException;
import DAO.DAOManager;
import DAOMySQL.MySQLDAOManager;
import Modelo.Paciente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 * @authors Alanstark & DiegoRoque
 */
public class JFrmVentanaPrincipal extends javax.swing.JFrame {
    //creamos un objeto del tipo interface IAutorDAO
        private DAOManager manager = null;
        
        //campos para almacenar los datos del formulario
        private int idPaciente;
        private String nombrePaciente;
        private String apellidoPaciente;
        private String direccionPaciente;
        private String telefonoPaciente;
        private String emailPaciente;
        private int edadPaciente;
        
        //seran variables globales los objetos de los JDialog para que no se sobrepongan
        JDCita miJDCita = new JDCita(null,true);
        JDReceta miJDReceta = new JDReceta(null,true);
        
    /**
     * Creates new form JFrmPrincipal
     */
    public JFrmVentanaPrincipal() {
        initComponents();
        this.manager = new MySQLDAOManager();
        //aparecera el Jdialog para que el usuario inicie sesión pero todavia no lo arreglo
        JDUsuario myJDUsuario = new JDUsuario(null, true);
        myJDUsuario.setLocationRelativeTo(null);
        myJDUsuario.setVisible(true);    
    }
     /**
     * Este método permite limpiar el formulario y ubicar el focus en la caja de texto del nombre
     */
    private void limpiarFormulario(){
        //asignamos el string -1 a la caja de texto del id.Paciente 
        txtIdPaciente.setText("-1");
        
        //limpiamos las otras cajas de texto 
        txtNombrePaciente.setText("");
        txtApellidoPaciente.setText("");
        txtDireccionPaciente.setText("");
        txtTelefonoPaciente.setText("");
        txtEmailPaciente.setText("");
        txtEdadPaciente.setText("");
        txtBuscarPorId.setText("");
        //ubicamos el focus en la caja de texto del nombre 
        txtNombrePaciente.requestFocusInWindow();
    }//fin del método limpiar formulario
    
    /**
     * Valida los datos de entrada del formulario
     * @return true si todos son validados correctamente,false en caso contrario  
     */
    private boolean validar(){
        boolean validacion = false;
        idPaciente = Integer.parseInt(txtIdPaciente.getText());
        nombrePaciente = txtNombrePaciente.getText();
        apellidoPaciente = txtApellidoPaciente.getText();
        direccionPaciente = txtDireccionPaciente.getText();
        telefonoPaciente = txtTelefonoPaciente.getText();
        emailPaciente = txtEmailPaciente.getText();
        edadPaciente = Integer.parseInt(txtEdadPaciente.getText());
        
        if(nombrePaciente.equals("")){
            JOptionPane.showMessageDialog(null, "Especifica el nombre del paciente");
            txtNombrePaciente.requestFocusInWindow();
            return (validacion);
        }
        if(apellidoPaciente.equals("")){
            JOptionPane.showMessageDialog(null, "Especifica el apellido del paciente");
            txtApellidoPaciente.requestFocusInWindow();
            return (validacion);
        }
        if(direccionPaciente.equals("")){
            JOptionPane.showMessageDialog(null, "Especifica la direccion del paciente");
            txtDireccionPaciente.requestFocusInWindow();
            return (validacion);
        }
         if(telefonoPaciente.equals("")){
            JOptionPane.showMessageDialog(null, "Especifica el telefono del paciente");
            txtTelefonoPaciente.requestFocusInWindow();
            return (validacion);
        }
          if(emailPaciente.equals("")){
            JOptionPane.showMessageDialog(null, "Especifica el email del paciente");
            txtEmailPaciente.requestFocusInWindow();
            return (validacion);
        }
           if(txtEdadPaciente.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Especifica la edad del paciente");
            txtEdadPaciente.requestFocusInWindow();
            return (validacion);
        }
        return (true);
    }//fin del método validar
    
    /**
     * Imprime un mensaje de error personalizado para aquellos errores que son producidos por el acceso a la base de datos 
     * @param ex objeto de tipo DAOException
     */
    public void imprimirMensajeDeErrorDAO(DAOException ex){
        //si getMessage existe obtenemos su valor 
        String mensajeError;
        try{
            mensajeError = "Mensaje "+ ex.getCause().getMessage();  
        }catch(NullPointerException error){
            mensajeError = "";
        }   
        JOptionPane.showMessageDialog(null, ex.getMessage()+ "\n"+mensajeError,"Error",JOptionPane.ERROR_MESSAGE);
    }//fin del método imprimirMensajeDeErrorDAO

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReportes = new javax.swing.JButton();
        btnAgregarCita = new javax.swing.JButton();
        btnAgregarReceta = new javax.swing.JButton();
        txtApellidoPaciente = new javax.swing.JTextField();
        txtNombrePaciente = new javax.swing.JTextField();
        txtIdPaciente = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarPorId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtDireccionPaciente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTelefonoPaciente = new javax.swing.JTextField();
        txtEmailPaciente = new javax.swing.JTextField();
        txtEdadPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnAgregarCita.setText("Agregar Cita");
        btnAgregarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCitaActionPerformed(evt);
            }
        });

        btnAgregarReceta.setText("Agregar Receta");
        btnAgregarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRecetaActionPerformed(evt);
            }
        });

        txtIdPaciente.setEditable(false);
        txtIdPaciente.setText("-1");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("Id. Paciente:");

        jLabel3.setText("Nombre:");

        jLabel6.setText("Apellido:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar una entrada por"));

        jLabel5.setText("Id. Paciente:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        jLabel7.setText("Dirección:");

        jLabel8.setText("Teléfono:");

        jLabel9.setText("Email:");

        jLabel10.setText("Edad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReportes)
                        .addGap(38, 38, 38)
                        .addComponent(btnAgregarReceta))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailPaciente, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTelefonoPaciente)
                                    .addComponent(txtEdadPaciente)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDireccionPaciente)
                                    .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminar))
                                    .addComponent(txtApellidoPaciente)
                                    .addComponent(txtNombrePaciente))))))
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEdadPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCita)
                    .addComponent(btnAgregarReceta)
                    .addComponent(btnReportes))
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
            //obtenemos el id del Paciente a buscar
            int idBuscar =(Integer) Integer.parseInt(txtBuscarPorId.getText());
            //obtenemos los datos del autor y lo asignamos al objeto miPaciente
            Paciente miPaciente = manager.getPacienteDAO().obtener(idBuscar);
            //mostramos los datos  en la caja de texto
            txtIdPaciente.setText(Integer.toString(miPaciente.getIdPaciente()));
            txtNombrePaciente.setText(miPaciente.getNombrePaciente());
            txtApellidoPaciente.setText(miPaciente.getApellidoPaciente());
            txtDireccionPaciente.setText(miPaciente.getDireccionPaciente());
            txtTelefonoPaciente.setText(miPaciente.getTelefonoPaciente());
            txtEmailPaciente.setText(miPaciente.getEmailPaciente());
            txtEdadPaciente.setText(Integer.toString(miPaciente.getEdadPaciente()));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Especifica un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            txtBuscarPorId.requestFocusInWindow();
            txtBuscarPorId.selectAll();
        }catch(DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //llamamos al método limpiarFormulario
        limpiarFormulario();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //llamamos la método validar para ver si procede guardar los datos
        if(validar()){
            //si idPaciente =-1 entonces insertamos el registro
            if(idPaciente == -1){
                //llamamos al contructor para crear un ojeto de tipo Paciente
                Paciente miPaciente = new Paciente(nombrePaciente, apellidoPaciente, direccionPaciente, telefonoPaciente, emailPaciente, edadPaciente);
                try{
                    manager.getPacienteDAO().insertar(miPaciente);
                    txtIdPaciente.setText(Integer.toString(miPaciente.getIdPaciente()));
                    JOptionPane.showMessageDialog(null,"Los datos han sido guardados");
                }catch(DAOException ex){
                    imprimirMensajeDeErrorDAO(ex);
                }//fin del catch
            }else{//si es diferente de -1 quiere decir que se esta realizando una modificación
                //llamamos al contructor para crear un ojeto de tipo Paciente
                Paciente miPaciente = new Paciente(idPaciente, nombrePaciente, apellidoPaciente, direccionPaciente, telefonoPaciente, emailPaciente, edadPaciente);
                try{
                    manager.getPacienteDAO().modificar(miPaciente);
                    txtIdPaciente.setText(Integer.toString(miPaciente.getIdPaciente()));
                    JOptionPane.showMessageDialog(null,"Los cambios han sido guardados");
                }catch(DAOException ex){
                    imprimirMensajeDeErrorDAO(ex);
                }//fin del catch
            }//fin del else
        }//fin del if validar
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //sólo se puede eliminar si el id Paciente es diferente de -1
        if(!txtIdPaciente.getText().equals("-1")){
            int idAutor = Integer.parseInt(txtIdPaciente.getText());
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar al paciente con id = "+txtIdPaciente.getText()+"?" ,"confirmar",0);
            if(respuesta == 0){
                try{
                    //eliminamos el Paciente
                    manager.getPacienteDAO().eliminar(idAutor);
                    //si no ocurre una excepción
                    JOptionPane.showMessageDialog(null,"El paciente ha sido eliminado");
                }catch(DAOException ex){
                    imprimirMensajeDeErrorDAO(ex);
                }//fin del catch
                limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(null,"Busca un paciente para poder eliminarlo");
            }//fin del else
        }//fin del if
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCitaActionPerformed
        miJDReceta.setVisible(false);//primero cerramos el otroJDialog para que no se sobreponga
        miJDCita.setTitle("Crear Cita");
        miJDCita.setLocationRelativeTo(null);
        miJDCita.setVisible(true);
        
        
    }//GEN-LAST:event_btnAgregarCitaActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
            try {
                miJDCita.setVisible(false);//primero cerramos el otroJDialog para que no se sobreponga
                miJDReceta.setVisible(false);//primero cerramos el otroJDialog para que no se sobreponga
                // creando el path para enviarlo al método de imprimir reporte de Pacientes
                String path = "src\\Reportes\\CitaPaciente.jasper";//agregarle el path donde esta el archivo .jasper
                JasperPrint jprint = manager.getPacienteDAO().imprimirReporte(path);
                JasperViewer view = new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);    
            } catch (DAOException ex) {
                Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnAgregarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRecetaActionPerformed
        miJDCita.setVisible(false);//primero cerramos el otroJDialog para que no se sobreponga
        miJDReceta.setTitle("Crear Receta");
        miJDReceta.setLocationRelativeTo(null);
        miJDReceta.setVisible(true);
        
    }//GEN-LAST:event_btnAgregarRecetaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmVentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCita;
    private javax.swing.JButton btnAgregarReceta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidoPaciente;
    private javax.swing.JTextField txtBuscarPorId;
    private javax.swing.JTextField txtDireccionPaciente;
    private javax.swing.JTextField txtEdadPaciente;
    private javax.swing.JTextField txtEmailPaciente;
    private javax.swing.JTextField txtIdPaciente;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtTelefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
