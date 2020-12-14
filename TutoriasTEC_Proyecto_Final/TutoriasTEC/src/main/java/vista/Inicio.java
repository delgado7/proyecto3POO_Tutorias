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
    static InicioAdmin frameInicioAdmin;
    static RegistrarTutor frameRegistrarTutor;
    static RevisarEstadisticas frameRevisarEstadisticas;
    static HabilitarAula frameHabilitarAula;
    static Bienvenida frameBienvenida;
    static RegistroEstudiante frameRegistroEstudiante;
    static IniciarSesion frameIniciarSesion;
    static InicioEstudiante frameInicioEstudiante;
    static ConsultarTutorias frameConsultarTutorias;
    
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
    
    public static void VentanaInicioAdmin(boolean visibilidad)
    {
        frameInicioAdmin.setTitle("Tutorías TEC - Administrador");
        frameInicioAdmin.setVisible(visibilidad);
        frameInicioAdmin.setBounds(560, 140, 600, 400);
        center(frameInicioAdmin);
        frameInicioAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicioAdmin.setResizable(false);
        frameInicioAdmin.getContentPane().setBackground(Color.white);
        frameInicioAdmin.setIconImage(img.getImage());
    }
    
    public static void VentanaRegistrarTutor(boolean visibilidad)
    {
        frameRegistrarTutor.setTitle("Tutorías TEC - Registrar Tutor");
        frameRegistrarTutor.setVisible(visibilidad);
        frameRegistrarTutor.setBounds(560, 140, 600, 400);
        center(frameRegistrarTutor);
        frameRegistrarTutor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarTutor.setResizable(false);
        frameRegistrarTutor.getContentPane().setBackground(Color.white);
        frameRegistrarTutor.setIconImage(img.getImage());
    }
    
    public static void VentanaRevisarEstadisticas(boolean visibilidad)
    {
        frameRevisarEstadisticas.setTitle("Tutorías TEC - Revisar Estadísticas");
        frameRevisarEstadisticas.setVisible(visibilidad);
        frameRevisarEstadisticas.setBounds(560, 140, 600, 400);
        center(frameRevisarEstadisticas);
        frameRevisarEstadisticas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRevisarEstadisticas.setResizable(false);
        frameRevisarEstadisticas.setIconImage(img.getImage());
    }
    
    public static void VentanaHabilitarAula(boolean visibilidad)
    {
        frameHabilitarAula.setTitle("Tutorías TEC - Habilitar Aula");
        frameHabilitarAula.setVisible(visibilidad);
        frameHabilitarAula.setBounds(560, 140, 600, 400);
        center(frameHabilitarAula);
        frameHabilitarAula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHabilitarAula.setResizable(false);
        frameHabilitarAula.setIconImage(img.getImage());
    }
    
    public static void VentanaBienvenida(boolean visibilidad) {
        frameBienvenida.setTitle("Tutorías TEC");
        frameBienvenida.setVisible(visibilidad);
        frameBienvenida.setBounds(560, 140, 600, 400);
        center(frameBienvenida);
        frameBienvenida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBienvenida.getContentPane().setBackground(Color.white);
        frameBienvenida.setResizable(false);
        frameBienvenida.setIconImage(img.getImage());
    }
    
    public static void VentanaRegistroEstudiante(boolean visibilidad) {
        frameRegistroEstudiante.setTitle("Tutorías TEC");
        frameRegistroEstudiante.setVisible(visibilidad);
        frameRegistroEstudiante.setBounds(560, 140, 600, 400);
        center(frameRegistroEstudiante);
        frameRegistroEstudiante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistroEstudiante.getContentPane().setBackground(Color.white);
        frameRegistroEstudiante.setResizable(false);
        frameRegistroEstudiante.setIconImage(img.getImage());
    }
    
    public static void VentanaIniciarSesion(boolean visibilidad) {
        frameIniciarSesion.setTitle("Tutorías TEC");
        frameIniciarSesion.setVisible(visibilidad);
        frameIniciarSesion.setBounds(560, 140, 600, 400);
        center(frameIniciarSesion);
        frameIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameIniciarSesion.getContentPane().setBackground(Color.white);
        frameIniciarSesion.setResizable(false);
        frameIniciarSesion.setIconImage(img.getImage());
    }
    
    public static void VentanaInicioEstudiante(boolean visibilidad) {
        frameInicioEstudiante.setTitle("Tutorías TEC - Estudiante");
        frameInicioEstudiante.setVisible(visibilidad);
        frameInicioEstudiante.setBounds(560, 140, 600, 400);
        center(frameInicioEstudiante);
        frameInicioEstudiante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicioEstudiante.getContentPane().setBackground(Color.white);
        frameInicioEstudiante.setResizable(false);
        frameInicioEstudiante.setIconImage(img.getImage());
    }
    
    public static void VentanaConsultarTutorias(boolean visibilidad) {
        frameConsultarTutorias.setTitle("Tutorías TEC - Consulta");
        frameConsultarTutorias.setVisible(visibilidad);
        frameConsultarTutorias.setBounds(560, 140, 600, 400);
        center(frameConsultarTutorias);
        frameConsultarTutorias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConsultarTutorias.getContentPane().setBackground(Color.white);
        frameConsultarTutorias.setResizable(false);
        frameConsultarTutorias.setIconImage(img.getImage());
    }
    
    public static void center(JFrame J) {
        J.setLocation(dim.width / 2 - J.getSize().width / 2, dim.height / 2 - J.getSize().height / 2);
    }
    
}
