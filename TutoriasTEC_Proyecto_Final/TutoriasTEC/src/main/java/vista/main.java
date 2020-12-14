/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import static vista.Inicio.frameInicioTutor;
import static vista.Inicio.frameAsistenciaTutoria;
import static vista.Inicio.frameAsistenciaLista;
import static vista.Inicio.frameHabilitarTutoria;
import static vista.Inicio.frameInicioAdmin;
import static vista.Inicio.frameRegistrarTutor;
import static vista.Inicio.frameRevisarEstadisticas;
import static vista.Inicio.frameHabilitarAula;
import static vista.Inicio.frameMenuPrincipal;
import Controlador.*;

/**
 *
 * @author mhidalgos0708
 */
public class main {
    
    public static Controlador control = new Controlador();
    
    public static void main(String[] args) {
        FlatLightLaf.install();
        
        control.cargarInformacionJSON("Estudiante.json", "Estudiante");
        control.cargarInformacionJSON("Tutor.json", "Tutor");
        control.cargarInformacionJSON("Aula.json", "Aula");
        control.cargarInformacionJSON("Tutoría.json", "Tutoría");
        control.prepararDiccionarios();
        
        frameInicioTutor = new InicioTutor();
        frameAsistenciaTutoria = new AsistenciaTutoria();
        frameAsistenciaLista = new AsistenciaLista();
        frameHabilitarTutoria = new HabilitarTutoria();
        frameInicioAdmin = new InicioAdmin();
        frameRegistrarTutor = new RegistrarTutor();
        frameRevisarEstadisticas = new RevisarEstadisticas();
        frameHabilitarAula = new HabilitarAula();
        frameMenuPrincipal = new MenuPrincipal();
        
        Inicio.VentanaMenuPrincipal(true);
    }
}
