/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author mhidalgos0708
 */
public class Inicio {
    
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    static ImageIcon img = new ImageIcon("src\\main\\java\\img\\icon.png");

    static InicioTutor frameInicioTutor;
    static AsistenciaTutoria frameAsistenciaTutoria;
    static AsistenciaLista frameAsistenciaLista;
    static HabilitarTutoria frameHabilitarTutoria;
    
    public static void VentanaInicioTutor(boolean visibilidad) {
        frameInicioTutor.setTitle("Tutorías TEC - Tutor");
        frameInicioTutor.setVisible(visibilidad);
        frameInicioTutor.setBounds(560, 140, 600, 400);
        frameInicioTutor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicioTutor.setResizable(false);
        frameInicioTutor.getContentPane().setBackground(Color.white);
        frameInicioTutor.setIconImage(img.getImage());
        center(frameInicioTutor);
    }
    
    public static void VentanaAsistenciaTutoria(boolean visibilidad) {
        frameAsistenciaTutoria.setTitle("Tutorías TEC - Asistencia");
        frameAsistenciaTutoria.setVisible(visibilidad);
        frameAsistenciaTutoria.setBounds(560, 140, 600, 400);
        frameAsistenciaTutoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAsistenciaTutoria.setResizable(false);
        frameAsistenciaTutoria.getContentPane().setBackground(Color.white);
        frameAsistenciaTutoria.setIconImage(img.getImage());
        center(frameAsistenciaTutoria);
    }
    
    public static void VentanaAsistenciaLista(boolean visibilidad) {
        frameAsistenciaLista.setTitle("Tutorías TEC - Verificar Asistencia");
        frameAsistenciaLista.setVisible(visibilidad);
        frameAsistenciaLista.setBounds(560, 140, 600, 400);
        frameAsistenciaLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAsistenciaLista.setResizable(false);
        frameAsistenciaLista.getContentPane().setBackground(Color.white);
        frameAsistenciaLista.setIconImage(img.getImage());
        center(frameAsistenciaLista);
    }
    
    public static void VentanaHabilitarTutoria(boolean visibilidad) {
        frameHabilitarTutoria.setTitle("Tutorías TEC - Habilitar tutoría");
        frameHabilitarTutoria.setVisible(visibilidad);
        frameHabilitarTutoria.setBounds(560, 140, 600, 400);
        frameHabilitarTutoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHabilitarTutoria.setResizable(false);
        frameHabilitarTutoria.getContentPane().setBackground(Color.white);
        frameHabilitarTutoria.setIconImage(img.getImage());
        center(frameHabilitarTutoria);
    }
    
    public static void center(JFrame J) {
        J.setLocation(dim.width / 2 - J.getSize().width / 2, dim.height / 2 - J.getSize().height / 2);
    }
    
}
