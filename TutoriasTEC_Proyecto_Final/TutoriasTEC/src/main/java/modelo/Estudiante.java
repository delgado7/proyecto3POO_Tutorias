/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fabri
 */
public class Estudiante extends Persona{
    
    private String carné;
    private final String correoEstudiantil;
    private final String contraseña;
    private boolean isActive = false;
    private String matriculadoEn="";

    public Estudiante(String carné, String correoEstudinatil, String contraseña, String nombre, String profesión) {
        super(nombre, "Estudiante");
        this.carné = carné;
        this.correoEstudiantil = correoEstudinatil;
        this.contraseña = contraseña;
    }
    
    public Estudiante(String correoEstudinatil, String contraseña, String nombre) {
        super(nombre, "Estudiante");
        this.correoEstudiantil = correoEstudinatil;
        this.contraseña = contraseña;
    }

    public Estudiante(String carné, String correoEstudiantil, String contraseña, String matriculadoEn, String nombre, String profesión) {
        super(nombre, profesión);
        this.carné = carné;
        this.correoEstudiantil = correoEstudiantil;
        this.contraseña = contraseña;
        this.matriculadoEn = matriculadoEn;
    }

    public void setMatriculadoEn(String matriculadoEn) {
        this.matriculadoEn = matriculadoEn;
    }

    public String getMatriculadoEn() {
        return this.matriculadoEn;
    }

    public String getCarné() {
        return carné;
    }

    public String getCorreoEstudiantil() {
        return correoEstudiantil;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getTutoríaMatriculada() {
        return matriculadoEn;
    }

    public void MatricularEn(String matriculadoEn) {
        this.matriculadoEn = matriculadoEn;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carn\u00e9=" + carné + ", correoEstudiantil=" + correoEstudiantil + ", contrase\u00f1a=" + contraseña + ", isActive=" + isActive + ", matriculadoEn=" + matriculadoEn + '}';
    }
    
    
}
