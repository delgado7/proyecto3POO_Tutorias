/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Silvia Rodriguez
 */
import Modelo.TModalidad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class RegistrarTutor extends JFrame implements ActionListener{
    Container container = getContentPane();
    JButton botonAtras = new JButton("Atrás");
    JButton botonRegistrarTutor = new JButton("Registrar Tutor");
    
    String[] modalidades = {null, "Virtual", "Presencial"};
    String[] tutorias = main.control.materiasDefault;
    JComboBox<String> ComboBoxModalidades = new JComboBox<>(modalidades);
    JComboBox<String> ComboBoxTutorias = new JComboBox<>(tutorias);

    JLabel TextoRegistroTutor = new JLabel("Registro de tutor");
    JLabel TextoNombreEstudiante = new JLabel("Nombre");
    JLabel TextoCorreo = new JLabel("Correo");
    JLabel TextoContraseña = new JLabel("Contraseña");
    JLabel TextoModalidad = new JLabel("Modalidad");
    JLabel TextoTutoria = new JLabel("Tutoría");

    JTextField TextFieldNombre = new JTextField();
    JTextField TextFieldCorreo = new JTextField();
    JTextField TextFieldContraseña = new JTextField();
    String modalidadSeleccionada = "";
    String materiaSeleccionada = "";

    RegistrarTutor()
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
        botonRegistrarTutor.addActionListener(this);
        ComboBoxModalidades.addActionListener(this);
        ComboBoxTutorias.addActionListener(this);
        botonAtras.addActionListener(this);
    }
    public void setLocationAndSize()
    {
        botonRegistrarTutor.setBounds(225, 300, 150, 30);
        botonAtras.setBounds(430, 25, 100, 30);
        TextoRegistroTutor.setBounds(50, 25, 150, 30);
        TextoNombreEstudiante.setBounds(100, 90, 150, 30);
        TextoCorreo.setBounds(100, 130, 150, 30);
        TextoContraseña.setBounds(100, 170, 150, 30);
        TextoModalidad.setBounds(100, 210, 150, 30);
        TextoTutoria.setBounds(100, 250, 150, 30);
        TextFieldNombre.setBounds(300, 90, 200, 30);
        TextFieldCorreo.setBounds(300, 130, 200, 30);
        TextFieldContraseña.setBounds(300, 170, 200, 30);
        ComboBoxModalidades.setBounds(300, 210, 200, 30);
        ComboBoxTutorias.setBounds(300, 250, 200, 30);
    }
    public void addComponentsToContainer()
    {
        container.add(botonRegistrarTutor);
        container.add(botonAtras);
        container.add(TextoContraseña);
        container.add(TextoCorreo);
        container.add(TextoModalidad);
        container.add(TextoNombreEstudiante);
        container.add(TextoTutoria);
        container.add(TextoRegistroTutor);
        container.add(TextFieldContraseña);
        container.add(TextFieldCorreo);
        container.add(TextFieldNombre);
        container.add(ComboBoxModalidades);
        container.add(ComboBoxTutorias);
    }
    public void limpiarCampos() {
        TextFieldNombre.setText("");
        TextFieldCorreo.setText("");
        TextFieldContraseña.setText("");
        ComboBoxModalidades.setSelectedIndex(0);
        ComboBoxTutorias.setSelectedIndex(0);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource().equals(botonAtras)) {
            limpiarCampos();
            Inicio.VentanaRegistrarTutor(false);
            Inicio.VentanaInicioAdmin(true);
        } else if(e.getSource().equals(ComboBoxTutorias)) {
            JComboBox materiaTutoria = (JComboBox) e.getSource();
            materiaSeleccionada = (String) materiaTutoria.getSelectedItem();
        } else if(e.getSource().equals(ComboBoxModalidades)) {
            JComboBox modalidad = (JComboBox) e.getSource();
            modalidadSeleccionada = (String) modalidad.getSelectedItem();
        } else if(e.getSource().equals(botonRegistrarTutor)) {
            if(ComboBoxModalidades.getSelectedItem() == null || ComboBoxTutorias.getSelectedItem() == null 
               || TextFieldNombre.getText().equals("") || TextFieldCorreo.getText().equals("") || 
               TextFieldContraseña.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "No se aceptan espacios vacíos.");
            }
            else {
                if(main.control.registrarTutorEnBase(TModalidad.valueOf(modalidadSeleccionada), materiaSeleccionada,
                                TextFieldCorreo.getText(), TextFieldContraseña.getText(), TextFieldNombre.getText(), false)) {
                    ComboBoxModalidades.setSelectedIndex(0);
                    ComboBoxTutorias.setSelectedIndex(0);
                    limpiarCampos();
                    JOptionPane.showMessageDialog(this, "El tutor se ha agregado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar un tutor.");
                }
            }
        }
    }    
}
