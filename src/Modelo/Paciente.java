package Modelo;
/**
 * la clase Paciente contendrá únicamente los campos que representen la 
 * estructura de la tabla pacintes con sus constructores y los descriptores 
 * de acceso (getters y setters).
 * @authors Alanstark & DiegoRoque
 */
public class Paciente {
    //campos
    private int idPaciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String direccionPaciente;
    private String telefonoPaciente;
    private String emailPaciente;
    private int edadPaciente;
    
    /**
     * Declaracion del constructor vacío
     */
    public Paciente(){
        
    }
    
//declaracion del constructor con seis parámetros 
    public Paciente(String nombrePaciente, String apellidoPaciente, String direccionPaciente, String telefonoPaciente, String emailPaciente, int edadPaciente) {
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.direccionPaciente = direccionPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.emailPaciente = emailPaciente;
        this.edadPaciente = edadPaciente;
    }
    
//declaracion del constructor con todos los parámetros 
    public Paciente(int idPaciente, String nombrePaciente, String apellidoPaciente, String direccionPaciente, String telefonoPaciente, String emailPaciente, int edadPaciente) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.direccionPaciente = direccionPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.emailPaciente = emailPaciente;
        this.edadPaciente = edadPaciente;
    }
    
//declaracion de getters y setters
    //getters
    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }
    //setters

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }
    
    @Override
    public String toString(){
        return (this.nombrePaciente);
    }
    
}//fin de la clase Paciente
