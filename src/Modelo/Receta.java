package Modelo;
/**
 * la clase Receta contendrá únicamente los campos que representen la estructura 
 * de la tabla receta con sus constructores y los descriptores 
 * de acceso (getters y setters).
 * @authors Alanstark & DiegoRoque
 */
public class Receta {
//campos
    private int idReceta;
    private String diagnostico;
    private String medicamentos;
    private int idPaciente;
    
//constructor vacío 
    public Receta() {
    }
    
//constructor sin el idReceta
    public Receta(String diagnostico, String medicamentos, int idPaciente) {
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
        this.idPaciente = idPaciente;
    }

//constructor con todos los campos    
    public Receta(int idReceta, String diagnostico, String medicamentos, int idPaciente) {
        this.idReceta = idReceta;
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
        this.idPaciente = idPaciente;
    }
//getters y setters
    //getters
    public int getIdReceta() {
        return idReceta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public int getIdPaciente() {
        return idPaciente;
    }
    
    //setters
    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    @Override
    public String toString(){
        return (this.diagnostico);
    }
}//fin de la clase Receta
