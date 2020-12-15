/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
/**
 *
 * @author mhidalgos0708
 */
public final class IniciarSesion extends JFrame implements ActionListener {
    
    Container container = getContentPane();
    
    JLabel mensajeTitulo = new JLabel("Iniciar sesión ");
    JLabel tituloUsuario = new JLabel("Usuario");
    JLabel tituloContraseña = new JLabel("Contraseña");
    JTextField TextFieldUsuario = new JTextField();
    JPasswordField TextFieldContraseña = new JPasswordField();
    JButton botonIniciarSesion = new JButton("Iniciar sesión");

    IniciarSesion() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        mensajeTitulo.setBounds(50, 25, 150, 30);
        tituloUsuario.setBounds(140, 125, 150, 30);
        tituloContraseña.setBounds(140, 175, 150, 30);
        TextFieldUsuario.setBounds(225, 125, 150, 30);
        TextFieldContraseña.setBounds(225, 175, 150, 30);
        botonIniciarSesion.setBounds(225, 225, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeTitulo);
        container.add(tituloUsuario);
        container.add(tituloContraseña);
        container.add(TextFieldUsuario);
        container.add(TextFieldContraseña);
        container.add(botonIniciarSesion);
    }

    public void addActionEvent() {
        botonIniciarSesion.addActionListener(this);
    }
    
    public void limpiarCampos() {
        TextFieldUsuario.setText("");
        TextFieldContraseña.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonIniciarSesion.equals(source)) {
            if(TextFieldUsuario.getText().equals("") || TextFieldContraseña.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un usuario y una contraseña.");
            } else {
                int codigoUsuario = main.control.verificarCrendecials(TextFieldUsuario.getText(), TextFieldContraseña.getText());
                if(codigoUsuario != -1) {
                    if(codigoUsuario == 1) {
                        limpiarCampos();
                        Inicio.VentanaInicioEstudiante(true);
                        Inicio.VentanaIniciarSesion(false);
                    } else if(codigoUsuario == 2) {
                        AsistenciaTutoria.prepararTutorias();
                        HabilitarTutoria.opcionesTutor.setText(main.control.getNombreTutorUsuario(TextFieldUsuario.getText()));
                        limpiarCampos();
                        Inicio.VentanaInicioTutor(true);
                        Inicio.VentanaIniciarSesion(false);
                    } else {
                        limpiarCampos();
                        Inicio.VentanaInicioAdmin(true);
                        Inicio.VentanaIniciarSesion(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta.");
                    Inicio.VentanaBienvenida(true);
                    Inicio.VentanaIniciarSesion(false);
                }
            }
        }
    }
}
