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
public class Tutor extends Estudiante{
    
    private final TModalidad modalidad;
    private final String materiaTutoría;
    private boolean Active;

    public Tutor(TModalidad modalidad, String materiaTutoría, String correoEstudinatil, String contraseña, String nombre) {
        super(correoEstudinatil, contraseña, nombre);
        this.modalidad = modalidad;
        this.materiaTutoría = materiaTutoría;
    }

    public TModalidad getModalidad() {
        return modalidad;
    }

    public String getMateriaTutoría() {
        return materiaTutoría;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }
    
    

    
    
}
