/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Silvia Rodriguez
 */
public final class InicioAdmin extends JFrame implements ActionListener{
    Container container = getContentPane();
    JButton botonRevisarEstadisticas = new JButton("Revisar estadísticas");
    JButton botonHabilitarAula = new JButton("Habilitar Aula");
    JButton botonRegistrarTutor = new JButton("Registrar Tutor");
    JButton botonCerrarSesion = new JButton("Cerrar sesión");

    InicioAdmin()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    public void addActionEvent()
    {
        botonRevisarEstadisticas.addActionListener(this);
        botonHabilitarAula.addActionListener(this);
        botonRegistrarTutor.addActionListener(this);
        botonCerrarSesion.addActionListener(this);
    }
    public void setLocationAndSize()
    {
        botonHabilitarAula.setBounds(225,100, 150, 30);
        botonRegistrarTutor.setBounds(225, 200, 150, 30);
        botonRevisarEstadisticas.setBounds(225,300, 150, 30);
        botonCerrarSesion.setBounds(400,25, 150, 30);
    }
    public void addComponentsToContainer()
    {
        container.add(botonHabilitarAula);
        container.add(botonRegistrarTutor);
        container.add(botonRevisarEstadisticas);
        container.add(botonCerrarSesion);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == botonCerrarSesion) {
            //Inicio.VentanaInicioAdmin(false);
        }
        if(e.getSource() == botonHabilitarAula)
        {
            Inicio.VentanaInicioAdmin(false);
            Inicio.VentanaHabilitarAula(true);
        }
        if(e.getSource() == botonRegistrarTutor)
        {
            Inicio.VentanaInicioAdmin(false);
            Inicio.VentanaRegistrarTutor(true);
        }
        if(e.getSource() == botonRevisarEstadisticas)
        {
            Inicio.VentanaInicioAdmin(false);
            Inicio.VentanaRevisarEstadisticas(true);
        }
    }    
}
