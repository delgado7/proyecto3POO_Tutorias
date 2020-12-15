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

    public Tutor(TModalidad modalidad, String materiaTutoría, String correoEstudiantil, String contraseña, String nombre) {
        super(correoEstudiantil, contraseña, nombre);
        this.modalidad = modalidad;
        this.materiaTutoría = materiaTutoría;
        this.Active = false;
    }

    public TModalidad getModalidad() {
        return modalidad;
    }

    public String getMateriaTutoría() {
        return materiaTutoría;
    }

    public boolean isActive() {
        return this.Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }

    @Override
    public String toString() {
        return "Tutor{" + super.toString() + "modalidad=" + modalidad + ", materiaTutor\u00eda=" + materiaTutoría + ", Active=" + Active + '}';
    }
    
}
