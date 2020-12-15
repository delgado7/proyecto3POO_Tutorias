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
public final class InicioEstudiante extends JFrame implements ActionListener {
    
    Container container = getContentPane();

    JLabel mensajeInicio = new JLabel("Bienvenido estudiante ");
    JButton botonSalir = new JButton("Cerrar sesión");
    JButton botonConsulta = new JButton("Consultar tutorías");

    InicioEstudiante() {
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
        botonSalir.setBounds(430, 25, 100, 30);
        botonConsulta.setBounds(225, 125, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeInicio);
        container.add(botonSalir);
        container.add(botonConsulta);
    }

    public void addActionEvent() {
        botonSalir.addActionListener(this);
        botonConsulta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonSalir.equals(source)) {
            main.control.setUsuarioActivo(main.control.getUsuarioActivo(), false);
            Inicio.VentanaBienvenida(true);
            Inicio.VentanaInicioEstudiante(false);
        } else if (botonConsulta.equals(source)) {
            Inicio.VentanaConsultarTutorias(true);
            Inicio.VentanaInicioEstudiante(false);
        }
    }
}
