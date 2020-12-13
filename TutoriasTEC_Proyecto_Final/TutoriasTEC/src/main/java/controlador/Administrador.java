package Controlador;

import Modelo.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Administrador extends Persona {

    private String correo;
    private String contraseña;

    public Administrador(String nombre, String profesión, String correo, String contrseña) {
        super(nombre, profesión);
        this.correo = correo;
        this.contraseña =contrseña;
    }

}
