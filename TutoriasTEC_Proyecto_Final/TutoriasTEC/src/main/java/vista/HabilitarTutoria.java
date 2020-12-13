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
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

/**
 *
 * @author mhidalgos0708
 */
public final class HabilitarTutoria extends JFrame implements ActionListener {
    
    Container container = getContentPane();
    
    ArrayList<String> correosTutores = main.control.getListaCorreosTutores();
    String idAula = "1";
    
    static String[] opcionesTutorLista = main.control.getListaNombresTutores().toArray(String[]::new);
    static String[] cantidadSesiones = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
    static String[] modalidadesLista = {"", "Virtual", "Presencial" };
    static String[] opcionesEscuelaLista = {"", "Matemática", "Computación" };
    static String[] opcionesAulaLista = main.control.getListaNombresAulas().toArray(String[]::new);
    static String[] mensajeError = {"un tutor.", "una modalidad.", "una escuela.",
                                    "un aula.", "una materia."};
    HashMap<String, String[]> listaMaterias = new HashMap<>();
    ArrayList<String> valorComponentes = new ArrayList<>();
    static String[] opcionesMatematicaLista = {"", "Discreta"};
    static String[] opcionesComputacionLista = {"", "Fundamentos"};
    
    JLabel mensajeTitulo = new JLabel("Habilitar tutoría");
    JButton botonAtras = new JButton("Atrás");
    JLabel tituloTutor = new JLabel("Tutor");
    JLabel tituloSesion = new JLabel("Sesiones");
    JLabel tituloCodigo = new JLabel("Código");
    JLabel tituloModalidad = new JLabel("Modalidad");
    JLabel tituloEscuela = new JLabel("Escuela");
    JLabel tituloAula = new JLabel("Aula");
    JLabel tituloMateria = new JLabel("Materia");
    JLabel tituloHorario = new JLabel("Horario");
    JComboBox<String> opcionesTutor = new JComboBox<>(opcionesTutorLista);
    SpinnerListModel opcionesCantidadSesion = new SpinnerListModel(cantidadSesiones);
    JSpinner opcionesSesion = new JSpinner(opcionesCantidadSesion);
    JTextField codigoTutoria = new JTextField();
    JComboBox<String> opcionesModalidad = new JComboBox<>(modalidadesLista);
    JComboBox<String> opcionesEscuela = new JComboBox<>(opcionesEscuelaLista);
    JComboBox<String> opcionesAula = new JComboBox<>(opcionesAulaLista);
    JComboBox<String> opcionesMateria = new JComboBox<>();
    JLabel opcionesHorario = new JLabel("");
    JButton botonConfirmar = new JButton("Confirmar");

    HabilitarTutoria() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addComponentsValues();
        addActionEvent();
    }
    
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        mensajeTitulo.setBounds(50, 25, 150, 30);
        botonAtras.setBounds(430, 25, 100, 30);
        tituloTutor.setBounds(50, 90, 100, 30);
        opcionesTutor.setBounds(115, 90, 150, 30);
        tituloSesion.setBounds(300, 90, 100, 30);
        opcionesSesion.setBounds(380, 90, 150, 30);
        tituloCodigo.setBounds(50, 130, 100, 30);
        codigoTutoria.setBounds(115, 130, 150, 30);
        tituloModalidad.setBounds(300, 130, 100, 30);
        opcionesModalidad.setBounds(380, 130, 150, 30);
        tituloEscuela.setBounds(50, 170, 100, 30);
        opcionesEscuela.setBounds(115, 170, 150, 30);
        tituloAula.setBounds(300, 170, 100, 30);
        opcionesAula.setBounds(380, 170, 150, 30);
        tituloMateria.setBounds(50, 210, 100, 30);
        opcionesMateria.setBounds(115, 210, 150, 30);
        tituloHorario.setBounds(300, 210, 100, 30);
        opcionesHorario.setBounds(380, 210, 150, 30);
        botonConfirmar.setBounds(225, 280, 150, 30);
    }

    public void addComponentsToContainer() {
        container.add(mensajeTitulo);
        container.add(botonAtras);
        container.add(tituloTutor);
        container.add(opcionesTutor);
        container.add(tituloSesion);
        container.add(opcionesSesion);
        container.add(tituloCodigo);
        container.add(codigoTutoria);
        container.add(tituloModalidad);
        container.add(opcionesModalidad);
        container.add(tituloEscuela);
        container.add(opcionesEscuela);
        container.add(tituloAula);
        container.add(opcionesAula);
        container.add(tituloMateria);
        container.add(opcionesMateria);
        container.add(tituloHorario);
        container.add(opcionesHorario);
        container.add(botonConfirmar);
        opcionesMateria.setEnabled(false);
    }
    
    public void addComponentsValues() {
        for(int i = 0; i < 6; i++) {
            valorComponentes.add("");
        }
        listaMaterias.put("Matemática", opcionesMatematicaLista);
        listaMaterias.put("Computación", opcionesComputacionLista);
    }

    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonConfirmar.addActionListener(this);
        opcionesTutor.addActionListener(this);
        opcionesModalidad.addActionListener(this);
        opcionesEscuela.addActionListener(this);
        opcionesAula.addActionListener(this);
        opcionesMateria.addActionListener(this);
    }
    
    public void limpiarCampos() {
        opcionesTutor.setSelectedIndex(0);
        opcionesSesion.setValue("1");
        codigoTutoria.setText("");
        opcionesModalidad.setSelectedIndex(0);
        opcionesEscuela.setSelectedIndex(0);
        opcionesAula.setSelectedIndex(0);
        opcionesHorario.setText("");
        if(opcionesMateria.isEnabled()) {
            opcionesMateria.setSelectedIndex(0);
        }
    }
    
    public boolean campoVacio(ActionEvent e) {
        for(int i = 0; i < 5; i++) {
            if(valorComponentes.get(i).equals("")) {
                String mensaje = "Debe ingresar " + mensajeError[i];
                JOptionPane.showMessageDialog(this, mensaje);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonAtras.equals(source)) {
            limpiarCampos();
            Inicio.VentanaInicioTutor(true);
            Inicio.VentanaHabilitarTutoria(false);
        } else if(opcionesTutor.equals(source)){
            JComboBox tutor = (JComboBox) e.getSource();
            valorComponentes.set(0, (String) tutor.getSelectedItem());
        } else if(opcionesModalidad.equals(source)){
            JComboBox modalidad = (JComboBox) e.getSource();
            valorComponentes.set(1, (String) modalidad.getSelectedItem());
        } else if(opcionesEscuela.equals(source)){
            JComboBox escuela = (JComboBox) e.getSource();
            String nombreEscuela = (String) escuela.getSelectedItem();
            valorComponentes.set(2, nombreEscuela);
            if(nombreEscuela.equals("")) {
                opcionesMateria.setEnabled(false);
            } else {
                opcionesMateria.setEnabled(true);
                opcionesMateria.removeAllItems();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel(listaMaterias.get(nombreEscuela));
                opcionesMateria.setModel(modelo);
            }
        } else if(opcionesAula.equals(source)){
            JComboBox aula = (JComboBox) e.getSource();
            valorComponentes.set(3, (String) aula.getSelectedItem());
            opcionesHorario.setText(main.control.getHorarioAula((String) aula.getSelectedItem()));
        } else if(opcionesMateria.equals(source)){
            JComboBox materia = (JComboBox) e.getSource();
            valorComponentes.set(4, (String) materia.getSelectedItem());
        } else if (botonConfirmar.equals(source)) {
            if(codigoTutoria.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código.");
            } else if(!campoVacio(e)) {
                JOptionPane.showMessageDialog(this, "Tutoría guardada.");
                limpiarCampos();
                Inicio.VentanaInicioTutor(true);
                Inicio.VentanaHabilitarTutoria(false);
            }
        }
    }
}
