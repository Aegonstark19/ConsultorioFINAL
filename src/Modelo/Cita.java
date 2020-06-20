package Modelo;

import java.util.Date;

/**
 *la clase Cita contendrá únicamente los campos que representen la estructura de la
  tabla cita con sus constructores y los descriptores de acceso (getters y setters).
 * @authors Alanstark & DiegoRoque
 */
public class Cita {
    private int numeroCita;
    private Date fechaCita;
    private String motivoCita;
    private int idPaciente;
    
    //declaracion del constructor vacío 
    public Cita() {
    }
    
    //declaracion del constructor sin el número cita 
    public Cita(Date fechaCita, String motivoCita, int idPaciente) {
        this.fechaCita = fechaCita;
        this.motivoCita = motivoCita;
        this.idPaciente = idPaciente;
    }
    //declaracion del constructor con todos los campos para modificar toda la cita
    public Cita(int numeroCita, Date fechaCita, String motivoCita, int idPaciente) {
        this.numeroCita = numeroCita;
        this.fechaCita = fechaCita;
        this.motivoCita = motivoCita;
        this.idPaciente = idPaciente;
    }
    
//getters y setters
    //getters
    public int getNumeroCita() {
        return numeroCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }
    
    //setters
    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    @Override
    public String toString(){
        return (this.motivoCita);
    }
}//fin de la clase Cita
