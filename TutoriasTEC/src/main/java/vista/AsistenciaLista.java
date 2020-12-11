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
import java.util.ArrayList;
import javax.swing.JScrollPane;
/**
 *
 * @author mhidalgos0708
 */
public final class AsistenciaLista extends JFrame implements ActionListener {
    
    Container container = getContentPane();
    
    int cantidadEstudiantes = 5;
    static String[] nombres = {" 2020250801 - Johan Calvo Vargas", " 2020070801 - Fabricio Delgado Morales",
                               " 2020221165 - Mariana Hidalgo Sandoval", " 2020141261 - Silvia Melissa Rodríguez Fernández",
                               " 2020131086 - Jose Pablo Rojas Núñez"};
    JLabel mensajeTitulo = new JLabel("Asistencia sesión X tutoría XXXXX ");
    JButton botonAtras = new JButton("Atrás");
    JPanel lista = new JPanel();
    JScrollPane listaEstudiantes = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JButton botonConfirmar = new JButton("Confirmar");
    ArrayList<JCheckBox> checkBoxList = new ArrayList<>();
    ArrayList<String> checkBoxSelected = new ArrayList<>();

    AsistenciaLista() {
        setLayoutManager();
        createCheckBoxes();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    
    public void setLayoutManager() {
        container.setLayout(null);
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
    }
    
    public void createCheckBoxes() {
        for(int i = 0; i < cantidadEstudiantes; i++) {
            JCheckBox estudiante = new JCheckBox(nombres[i]);
            checkBoxList.add(estudiante);
            lista.add(estudiante);
        }
    }

    public void setLocationAndSize() {
        mensajeTitulo.setBounds(50, 25, 300, 30);
        botonAtras.setBounds(430, 25, 100, 30);
        listaEstudiantes.setBounds(150, 100, 300, 100);
        botonConfirmar.setBounds(225, 250, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeTitulo);
        container.add(botonAtras);
        container.add(listaEstudiantes);
        container.add(botonConfirmar);
    }

    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonConfirmar.addActionListener(this);
        for(int i = 0; i < checkBoxList.size(); i++) {
            JCheckBox estudiante = checkBoxList.get(i);
            estudiante.addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonAtras.equals(source)) {
            Inicio.VentanaAsistenciaTutoria(true);
            Inicio.VentanaAsistenciaLista(false);
        }else if (botonConfirmar.equals(source)) {
            JOptionPane.showMessageDialog(this, "Lista de asistencia guardada.");
            Inicio.VentanaInicioTutor(true);
            Inicio.VentanaAsistenciaLista(false);
        } else {
            for(int i = 0; i < checkBoxList.size(); i++) {
                JCheckBox estudiante = checkBoxList.get(i);
                if(estudiante.equals(source) && estudiante.isSelected()) {
                    checkBoxSelected.add(estudiante.getText());
                }
            }
        }
    }
}
