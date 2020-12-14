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

public final class RegistroEstudiante extends JFrame implements ActionListener{
    
    Container container = getContentPane();
    
    JButton botonRegistrar = new JButton("Registrarse");

    JLabel TextoRegistro = new JLabel("Registrarse");
    JLabel TextoNombre = new JLabel("Nombre");
    JLabel TextoCorreo = new JLabel("Correo");
    JLabel TextoCarne = new JLabel("Carné");
    JLabel TextoContraseña = new JLabel("Contraseña");

    JTextField TextFieldNombre = new JTextField();
    JTextField TextFieldCorreo = new JTextField();
    JTextField TextFieldCarne = new JTextField();
    JPasswordField PasswordFieldContraseña = new JPasswordField();

    RegistroEstudiante()
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
        botonRegistrar.addActionListener(this);
    }
    public void setLocationAndSize()
    {
        botonRegistrar.setBounds(225, 280, 150, 30);
        TextoRegistro.setBounds(50, 25, 150, 30);
        TextoNombre.setBounds(150, 90, 150, 30);
        TextoCorreo.setBounds(150, 130, 150, 30);
        TextoCarne.setBounds(150, 170, 150, 30);
        TextoContraseña.setBounds(150, 210, 150, 30);
        TextFieldNombre.setBounds(300, 90, 150, 30);
        TextFieldCorreo.setBounds(300, 130, 150, 30);
        TextFieldCarne.setBounds(300, 170, 150, 30);
        PasswordFieldContraseña.setBounds(300, 210, 150, 30);
    }
    public void addComponentsToContainer()
    {
        container.add(botonRegistrar);
        container.add(TextoRegistro);
        container.add(TextoNombre);
        container.add(TextoCorreo);
        container.add(TextoCarne);
        container.add(TextoContraseña);
        container.add(TextFieldNombre);
        container.add(TextFieldCorreo);
        container.add(TextFieldCarne);
        container.add(PasswordFieldContraseña);
    }
    public void limpiarCampos() {
        TextFieldNombre.setText("");
        TextFieldCorreo.setText("");
        TextFieldCarne.setText("");
        PasswordFieldContraseña.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(botonRegistrar)) {
            if(TextFieldNombre.getText().equals("") || TextFieldCorreo.getText().equals("") || 
               TextFieldCarne.getText().equals("") || PasswordFieldContraseña.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "No se aceptan espacios vacíos.");
            }
            else {
                if(main.control.registrarEstudianteEnBase(TextFieldCarne.getText(), TextFieldCorreo.getText(), PasswordFieldContraseña.getText(), "", TextFieldNombre.getText(), false)) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(this, "El estudiante se ha registrado con éxito.");
                    Inicio.VentanaBienvenida(true);
                    Inicio.VentanaRegistroEstudiante(false); 
                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar un estudiante.");
                }
            }
        }
    }    
}
