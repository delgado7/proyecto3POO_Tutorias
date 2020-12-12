package Vista;

import Controlador.Controlador;
import Controlador.Utilitaria;
import Modelo.Aula;
import Modelo.Estudiante;
import Modelo.TModalidad;
import Modelo.Tutor;
import Modelo.Tutoría;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        Controlador Sistema = new Controlador();
        Sistema.cargarInformacionJSON("Estudiante.json", "Estudiante");
        Sistema.cargarInformacionJSON("Tutor.json", "Tutor");
        Sistema.cargarInformacionJSON("Aula.json", "Aula");
        Sistema.cargarInformacionJSON("Tutoría.json", "Tutría");
       
       
        
        
        
    }
}
