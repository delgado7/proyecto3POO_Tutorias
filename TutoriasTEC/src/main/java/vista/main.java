/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import static vista.Inicio.VentanaInicioTutor;
import static vista.Inicio.frameInicioTutor;
import static vista.Inicio.frameAsistenciaTutoria;
import static vista.Inicio.frameAsistenciaLista;
import static vista.Inicio.frameHabilitarTutoria;

/**
 *
 * @author mhidalgos0708
 */
public class main {
    public static void main(String[] args) {
        FlatLightLaf.install();
        frameInicioTutor = new InicioTutor();
        frameAsistenciaTutoria = new AsistenciaTutoria();
        frameAsistenciaLista = new AsistenciaLista();
        frameHabilitarTutoria = new HabilitarTutoria();
        VentanaInicioTutor(true);
    }
}
