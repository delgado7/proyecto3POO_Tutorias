import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

//import com.formdev.flatlaf.FlatDarculaLaf;

public class Inicio {
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    static InicioAdmin frameInicioAdmin;
    static RegistrarTutor frameRegistrarTutor;

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

    public static void main(String[] args) {
        frameInicioAdmin = new InicioAdmin();
        frameRegistrarTutor = new RegistrarTutor();
        VentanaRegistrarTutor(true);
    }

}
