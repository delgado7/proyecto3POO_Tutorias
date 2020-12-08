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
    
    private int carné = -1;
    private final String correoEstudinatil;
    private final String contraseña;
    private boolean isActive = false;
    private Tutoría matriculadoEn;

    public Estudiante(int carné, String correoEstudinatil, String contraseña, String nombre, String profesión) {
        super(nombre, "Estudiante");
        this.carné = carné;
        this.correoEstudinatil = correoEstudinatil;
        this.contraseña = contraseña;
    }
    
    public Estudiante(String correoEstudinatil, String contraseña, String nombre) {
        super(nombre, "Estudiante");
        this.correoEstudinatil = correoEstudinatil;
        this.contraseña = contraseña;
    }

    public int getCarné() {
        return carné;
    }

    public String getCorreoEstudinatil() {
        return correoEstudinatil;
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

    public Tutoría getTutoríaMatriculada() {
        return matriculadoEn;
    }

    public void MatricularEn(Tutoría matriculadoEn) {
        this.matriculadoEn = matriculadoEn;
    }
}
