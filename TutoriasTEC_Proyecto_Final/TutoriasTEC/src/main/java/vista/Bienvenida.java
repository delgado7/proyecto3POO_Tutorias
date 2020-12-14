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
/**
 *
 * @author mhidalgos0708
 */
public final class Bienvenida extends JFrame implements ActionListener {
    
    Container container = getContentPane();

    JLabel mensajeInicio = new JLabel("Bienvenidos a Tutorías TEC");
    JButton botonRegistrarse = new JButton("Registrarse");
    JButton botonIniciarSesion = new JButton("Iniciar sesión");

    Bienvenida() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        mensajeInicio.setBounds(50, 25, 150, 30);
        botonRegistrarse.setBounds(225, 125, 150, 30);
        botonIniciarSesion.setBounds(225, 175, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeInicio);
        container.add(botonRegistrarse);
        container.add(botonIniciarSesion);
    }

    public void addActionEvent() {
        botonRegistrarse.addActionListener(this);
        botonIniciarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonRegistrarse.equals(source)) {
            Inicio.VentanaRegistroEstudiante(true);
            Inicio.VentanaBienvenida(false);
        } else if (botonIniciarSesion.equals(source)) {
            Inicio.VentanaIniciarSesion(true);
            Inicio.VentanaBienvenida(false);
        }
    }
}
