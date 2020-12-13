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
public final class AsistenciaTutoria extends JFrame implements ActionListener {
    
    Container container = getContentPane();
    
    static String[] opcionesTutoriaLista = {"", "Cálculo" };
    static String[] opcionesSesionLista = {"", "Sesión 1", "Sesión 2", "Sesión 3", "Sesión 4" };
    HashMap<String, String[]> listaSesiones = new HashMap<>();
    
    JLabel mensajeTitulo = new JLabel("Asistencia ");
    JButton botonAtras = new JButton("Atrás");
    JLabel tituloTutoria = new JLabel("Tutoría");
    JLabel tituloSesion = new JLabel("Sesión");
    JComboBox<String> opcionesTutoria = new JComboBox<>(opcionesTutoriaLista);
    JComboBox<String> opcionesSesion = new JComboBox<>();
    JButton botonAsistencia = new JButton("Revisar asistencia");
    String nombreTutoria = "";
    String nombreSesion = "";

    AsistenciaTutoria() {
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
        botonAtras.setBounds(430, 25, 100, 30);
        tituloTutoria.setBounds(140, 125, 150, 30);
        tituloSesion.setBounds(140, 175, 150, 30);
        opcionesTutoria.setBounds(225, 125, 150, 30);
        opcionesSesion.setBounds(225, 175, 150, 30);
        botonAsistencia.setBounds(225, 225, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeTitulo);
        container.add(botonAtras);
        container.add(tituloTutoria);
        container.add(tituloSesion);
        container.add(opcionesTutoria);
        container.add(opcionesSesion);
        container.add(botonAsistencia);
        opcionesSesion.setEnabled(false);
        listaSesiones.put("Cálculo", opcionesSesionLista);
    }

    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonAsistencia.addActionListener(this);
        opcionesTutoria.addActionListener(this);
        opcionesSesion.addActionListener(this);
    }
    
    public void limpiarCampos() {
        opcionesTutoria.setSelectedIndex(0);
        if(opcionesSesion.isEnabled()) {
            opcionesSesion.setSelectedIndex(0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonAtras.equals(source)) {
            limpiarCampos();
            Inicio.VentanaInicioTutor(true);
            Inicio.VentanaAsistenciaTutoria(false);
        } else if(opcionesTutoria.equals(source)){
            JComboBox tutoria = (JComboBox) e.getSource();
            nombreTutoria = (String) tutoria.getSelectedItem();
            if(nombreTutoria.equals("")) {
                opcionesSesion.setEnabled(false);
            } else {
                opcionesSesion.setEnabled(true);
                opcionesSesion.removeAllItems();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel(listaSesiones.get(nombreTutoria));
                opcionesSesion.setModel(modelo);
            }
        } else if(opcionesSesion.equals(source)){
            JComboBox sesion = (JComboBox) e.getSource();
            nombreSesion = (String) sesion.getSelectedItem();
        } else if (botonAsistencia.equals(source)) {
            if(nombreTutoria.equals("") || nombreSesion == null || nombreSesion.equals("")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar una tutoría y una sesión.");
            } else {
                limpiarCampos();
                Inicio.VentanaAsistenciaLista(true);
                Inicio.VentanaAsistenciaTutoria(false);
            }
        }
    }
}
