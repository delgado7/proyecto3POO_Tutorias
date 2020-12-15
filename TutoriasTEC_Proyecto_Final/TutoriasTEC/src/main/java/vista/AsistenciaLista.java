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
import java.util.HashMap;
/**
 *
 * @author mhidalgos0708
 */
public final class AsistenciaLista extends JFrame implements ActionListener {
    
    Container container = getContentPane();
   
    JLabel mensajeTituloParte1 = new JLabel("Asistencia");
    JLabel mensajeTituloParte2 = new JLabel("tutoría");
    static JLabel sesion = new JLabel();
    static JLabel tutoria = new JLabel();
    JButton botonAtras = new JButton("Atrás");
    static JPanel lista = new JPanel();
    JScrollPane listaEstudiantes = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JButton botonConfirmar = new JButton("Confirmar");
    static ArrayList<JCheckBox> checkBoxList = new ArrayList<>();

    AsistenciaLista() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    
    public void setLayoutManager() {
        container.setLayout(null);
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
    }
        
    public void setLocationAndSize() {
        mensajeTituloParte1.setBounds(50, 25, 100, 30);
        sesion.setBounds(110, 25, 100, 30);
        mensajeTituloParte2.setBounds(170, 25, 100, 30);
        tutoria.setBounds(230, 25, 100, 30);
        botonAtras.setBounds(390, 25, 100, 30);
        listaEstudiantes.setBounds(150, 100, 300, 100);
        botonConfirmar.setBounds(225, 250, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeTituloParte1);
        container.add(sesion);
        container.add(mensajeTituloParte2);
        container.add(tutoria);
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
    
    public void limpiarCampos() {
        for(int i = 0; i < checkBoxList.size(); i++) {
            JCheckBox estudiante = checkBoxList.get(i);
            estudiante.setSelected(false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonAtras.equals(source)) {
            limpiarCampos();
            Inicio.VentanaAsistenciaTutoria(true);
            Inicio.VentanaAsistenciaLista(false);
        }else if (botonConfirmar.equals(source)) {
            String carne;
            if(checkBoxList.size() > 0) {
                int cantidadPresentes = 0;
                HashMap<String, String> estadisticas = new HashMap<>();
                for(int i = 0; i < checkBoxList.size(); i++) {
                    JCheckBox estudiante = checkBoxList.get(i);
                    carne = estudiante.getText().split("-")[0];
                    if(estudiante.isSelected()) {
                        main.control.PasarLista(tutoria.getText(), carne, true);
                        cantidadPresentes++;
                    } else if(estudiante.equals(source) && !estudiante.isSelected()) {
                        main.control.PasarLista(tutoria.getText(), carne, false);
                    }
                }
                estadisticas.put("Asistencia Total", String.valueOf(cantidadPresentes));
                estadisticas.put("Sesiones", sesion.getText().split(" ")[1]);
                main.control.confirmarAsistenciaTutoría(tutoria.getText(), estadisticas);
                JOptionPane.showMessageDialog(this, "Lista de asistencia guardada.");
                main.control.getTutoriaPorCodigo(tutoria.getText()).setEnCursoActualmente(true);
                limpiarCampos();
                Inicio.VentanaInicioTutor(true);
                Inicio.VentanaAsistenciaLista(false);
            } else {
                JOptionPane.showMessageDialog(this, "Lista de asistencia vacía.");
                limpiarCampos();
                Inicio.VentanaInicioTutor(true);
                Inicio.VentanaAsistenciaLista(false);
            }
        }
    }
}
