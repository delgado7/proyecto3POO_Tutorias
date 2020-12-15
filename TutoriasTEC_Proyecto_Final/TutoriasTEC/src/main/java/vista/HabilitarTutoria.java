/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.TModalidad;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import Controlador.Utilitaria;
import Modelo.Estudiante;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mhidalgos0708
 */
public final class HabilitarTutoria extends JFrame implements ActionListener {
    
    Container container = getContentPane();
    
    ArrayList<String> correosTutores = main.control.getListaCorreosTutores();
    
    static String[] opcionesTutorLista = main.control.getListaNombresTutores().toArray(String[]::new);
    static String[] cantidadSesiones = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
    static String[] modalidadesLista = {"", "Virtual", "Presencial" };
    static String[] opcionesEscuelaLista = main.control.escuelasDefault;
    static String[] opcionesAulaLista = main.control.getAulasDisponibles();
    static String[] mensajeError = {"una modalidad.", "una escuela.", "un aula.", "una materia."};
    HashMap<String, String[]> listaMaterias = new HashMap<>();
    ArrayList<String> valorComponentes = new ArrayList<>();
    HashMap<String, String[]> escuelaMaterias = main.control.escuelaMaterias;
    
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
    static JLabel opcionesTutor = new JLabel();
    SpinnerListModel opcionesCantidadSesion = new SpinnerListModel(cantidadSesiones);
    JSpinner opcionesSesion = new JSpinner(opcionesCantidadSesion);
    JTextField codigoTutoria = new JTextField();
    JComboBox<String> opcionesModalidad = new JComboBox<>(modalidadesLista);
    JComboBox<String> opcionesEscuela = new JComboBox<>(opcionesEscuelaLista);
    static JComboBox<String> opcionesAula = new JComboBox<>(opcionesAulaLista);
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
        tituloCodigo.setBounds(50, 90, 100, 30);
        codigoTutoria.setBounds(115, 90, 150, 30);
        tituloSesion.setBounds(300, 90, 100, 30);
        opcionesSesion.setBounds(380, 90, 150, 30);
        tituloEscuela.setBounds(50, 130, 100, 30);
        opcionesEscuela.setBounds(115, 130, 150, 30);
        tituloMateria.setBounds(50, 170, 100, 30);
        opcionesMateria.setBounds(115, 170, 150, 30);
        tituloTutor.setBounds(50, 210, 100, 30);
        opcionesTutor.setBounds(115, 210, 150, 30);
        tituloModalidad.setBounds(300, 130, 100, 30);
        opcionesModalidad.setBounds(380, 130, 150, 30);
        tituloAula.setBounds(300, 170, 100, 30);
        opcionesAula.setBounds(380, 170, 150, 30);
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
        opcionesTutor.setVisible(false);
        opcionesMateria.setEnabled(false);
        opcionesModalidad.setEnabled(false);
    }
    
    public void addComponentsValues() {
        for(int i = 0; i < 6; i++) {
            valorComponentes.add("");
        }
    }

    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonConfirmar.addActionListener(this);
        opcionesModalidad.addActionListener(this);
        opcionesEscuela.addActionListener(this);
        opcionesAula.addActionListener(this);
        opcionesMateria.addActionListener(this);
    }
    
    public void limpiarCampos() {
        opcionesSesion.setValue("1");
        codigoTutoria.setText("");
        opcionesModalidad.setEnabled(false);
        opcionesEscuela.setSelectedIndex(0);
        opcionesHorario.setText("");
        opcionesMateria.setEnabled(false);
    }
    
    public boolean campoVacio(ActionEvent e) {
        for(int i = 0; i < mensajeError.length; i++) {
            if(valorComponentes.get(i) == null || valorComponentes.get(i).equals("")) {
                String mensaje = "Debe ingresar " + mensajeError[i];
                JOptionPane.showMessageDialog(this, mensaje);
                return true;
            }
        }
        return false;
    }
    
    public static void prepararAulasDisponibles() {
        opcionesAula.removeAllItems();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(main.control.getAulasDisponibles());
        opcionesAula.setModel(modelo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (botonAtras.equals(source)) {
            limpiarCampos();
            Inicio.VentanaInicioTutor(true);
            Inicio.VentanaHabilitarTutoria(false);
        } else if(opcionesModalidad.equals(source)){
            JComboBox modalidad = (JComboBox) e.getSource();
            String nombreModalidad = (String) modalidad.getSelectedItem();
            valorComponentes.set(0, nombreModalidad);
            if(nombreModalidad == null || nombreModalidad.equals("")) {
                opcionesTutor.setVisible(false);
            } else {
                List<String> tutores = Arrays.asList(main.control.getTutoresPorMateriaModalidad(opcionesTutorLista, 
                                                        correosTutores, (String) opcionesMateria.getSelectedItem(), 
                                                        (String) opcionesModalidad.getSelectedItem()));
                if(tutores == null || !tutores.contains(opcionesTutor.getText())) {
                    opcionesTutor.setVisible(false);
                } else {
                    opcionesTutor.setVisible(true);
                }
            }
        } else if(opcionesEscuela.equals(source)){
            JComboBox escuela = (JComboBox) e.getSource();
            String nombreEscuela = (String) escuela.getSelectedItem();
            valorComponentes.set(1, nombreEscuela);
            if(nombreEscuela.equals("")) {
                opcionesMateria.setEnabled(false);
                opcionesModalidad.setEnabled(false);
            } else {
                opcionesMateria.setEnabled(true);
                opcionesMateria.removeAllItems();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel(escuelaMaterias.get(nombreEscuela));
                opcionesMateria.setModel(modelo);
            }
            opcionesTutor.setVisible(false);
        } else if(opcionesAula.equals(source)){
            JComboBox aula = (JComboBox) e.getSource();
            valorComponentes.set(2, (String) aula.getSelectedItem());
            opcionesHorario.setText(main.control.getHorarioAula((String) aula.getSelectedItem()));
        } else if(opcionesMateria.equals(source)){
            JComboBox materia = (JComboBox) e.getSource();
            String nombreMateria = (String) materia.getSelectedItem();
            valorComponentes.set(3, nombreMateria);
            if(nombreMateria == null || nombreMateria.equals("")) {
                opcionesModalidad.setEnabled(false);
            } else {
                opcionesModalidad.setEnabled(true);
            }
            opcionesTutor.setVisible(false);
        } else if (botonConfirmar.equals(source)) {
            if(codigoTutoria.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un código.");
            } else if(!campoVacio(e) && opcionesTutor.isVisible()) {
                ArrayList<Estudiante> estudiantes = new ArrayList<>();
                if(main.control.registrarTutoríaEnBase(main.control.getTutorCorreo(main.control.getUsuarioActivo()), codigoTutoria.getText(), (String) opcionesEscuela.getSelectedItem(),
                                           (String) opcionesMateria.getSelectedItem(), TModalidad.valueOf((String) opcionesModalidad.getSelectedItem()),
                                           (String) opcionesAula.getSelectedItem(), opcionesHorario.getText(), 25, Utilitaria.obtenerFechaCalendar(opcionesHorario.getText().split(" - ")[0]),
                                           Utilitaria.obtenerFechaCalendar(opcionesHorario.getText().split(" - ")[1]), Integer.parseInt((String) opcionesSesion.getValue()), 0, false, estudiantes, 0, false)) {
                    JOptionPane.showMessageDialog(this, "Tutoría guardada.");
                    main.control.prepararDiccionarios();
                    limpiarCampos();
                    Inicio.VentanaInicioTutor(true);
                    Inicio.VentanaHabilitarTutoria(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar tutoría");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar tutoría");
            }
        }
    }
}
