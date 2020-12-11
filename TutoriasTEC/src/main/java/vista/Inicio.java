/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.formdev.flatlaf.FlatDarculaLaf;

/**
 *
 * @author mhidalgos0708
 */
public class Inicio {
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    static InicioAdmin frameInicioAdmin;
    static RegistrarTutor frameRegistrarTutor;
    static RevisarEstadisticas frameRevisarEstadisticas;
    static HabilitarAula frameHabilitarAula;

    public static void center(JFrame J) {
        J.setLocation(dim.width / 2 - J.getSize().width / 2, dim.height / 2 - J.getSize().height / 2);
    }

    public static void VentanaInicioAdmin(boolean visibilidad)
    {
        frameInicioAdmin.setTitle("Inicio - Administrador");
        frameInicioAdmin.setVisible(visibilidad);
        frameInicioAdmin.setBounds(560, 140, 600, 400);
        center(frameInicioAdmin);
        frameInicioAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicioAdmin.setResizable(false);
    }
    public static void VentanaRegistrarTutor(boolean visibilidad)
    {
        frameRegistrarTutor.setTitle("Registrar un tutor - Administrador");
        frameRegistrarTutor.setVisible(visibilidad);
        frameRegistrarTutor.setBounds(560, 140, 600, 400);
        center(frameRegistrarTutor);
        frameRegistrarTutor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarTutor.setResizable(false);
    }
    
    public static void VentanaRevisarEstadisticas(boolean visibilidad)
    {
        frameRevisarEstadisticas.setTitle("Revisar Estadísticas - Administrador");
        frameRevisarEstadisticas.setVisible(visibilidad);
        frameRevisarEstadisticas.setBounds(560, 140, 600, 400);
        center(frameRevisarEstadisticas);
        frameRevisarEstadisticas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRevisarEstadisticas.setResizable(false);
    }
    
    public static void VentanaHabilitarAula(boolean visibilidad)
    {
        frameHabilitarAula.setVisible(visibilidad);
        frameHabilitarAula.setBounds(560, 140, 600, 400);
        center(frameHabilitarAula);
        frameHabilitarAula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHabilitarAula.setResizable(false);
    }

    public static void main(String[] args) {
        frameInicioAdmin = new InicioAdmin();
        frameRegistrarTutor = new RegistrarTutor();
        frameRevisarEstadisticas = new RevisarEstadisticas();
        frameHabilitarAula = new HabilitarAula();
        VentanaInicioAdmin(true);
    }
}
