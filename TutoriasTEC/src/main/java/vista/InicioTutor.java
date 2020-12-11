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
public final class InicioTutor extends JFrame implements ActionListener {
    
    Container container = getContentPane();

    JLabel mensajeInicio = new JLabel("Bienvenido tutor ");
    JButton botonSalir = new JButton("Salir");
    JButton botonAsistencia = new JButton("Revisar asistencia");
    JButton botonTutoria = new JButton("Registrar tutoría");

    InicioTutor() {
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
        botonAsistencia.setBounds(225, 125, 150, 30);
        botonTutoria.setBounds(225, 175, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeInicio);
        container.add(botonSalir);
        container.add(botonAsistencia);
        container.add(botonTutoria);
    }

    public void addActionEvent() {
        botonSalir.addActionListener(this);
        botonAsistencia.addActionListener(this);
        botonTutoria.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonSalir.equals(source)) {
            Inicio.VentanaInicioTutor(true);
            Inicio.VentanaInicioTutor(false);
        } else if (botonAsistencia.equals(source)) {
            Inicio.VentanaAsistenciaTutoria(true);
            Inicio.VentanaInicioTutor(false);
        } else if (botonTutoria.equals(source)) {
            System.out.println("Tercer case");
            Inicio.VentanaInicioTutor(false);
        }
    }
}
