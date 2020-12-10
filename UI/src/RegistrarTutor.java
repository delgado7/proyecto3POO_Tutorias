import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class RegistrarTutor extends JFrame implements ActionListener{
    Container container = getContentPane();
    JButton botonAtras = new JButton("Atrás");
    JButton botonRegistrarTutor = new JButton("Registrar Tutor");

    JLabel TextoRegistroTutor = new JLabel("Registro de tutor");
    JLabel TextoNombreEstudiante = new JLabel("Nombre");
    JLabel TextoCorreo = new JLabel("Correo");
    JLabel TextoContraseña = new JLabel("Contraseña");
    JLabel TextoModalidad = new JLabel("Modalidad");
    JLabel TextoTutoria = new JLabel("Tutoría");

    JTextField TextFieldNombre = new JTextField();
    JTextField TextFieldCorreo = new JTextField();
    JTextField TextFieldContraseña = new JTextField();

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
        botonAtras.addActionListener(this);
    }
    public void setLocationAndSize()
    {
        botonRegistrarTutor.setBounds(225, 300, 150, 30);
        botonAtras.setBounds(450,25, 100, 30 );
        TextoRegistroTutor.setBounds(50, 35, 150, 30);
        TextoNombreEstudiante.setBounds(100, 90, 150, 30);
        TextoCorreo.setBounds(100, 130, 150, 30);
        TextoContraseña.setBounds(100, 170, 150, 30);
        TextoModalidad.setBounds(100, 210, 150, 30);
        TextoTutoria.setBounds(100, 250, 150, 30);
        TextFieldNombre.setBounds(300, 90, 150, 30);
        TextFieldCorreo.setBounds(300, 130, 150, 30);
        TextFieldContraseña.setBounds(300, 170, 150, 30);
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
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == botonAtras) {
            TextFieldNombre.setText("");
            TextFieldContraseña.setText("");
            TextFieldContraseña.setText("");
            Inicio.VentanaRegistrarTutor(false);
            Inicio.VentanaInicioAdmin(true);
        }
        if(e.getSource() == botonRegistrarTutor)
        {

        }
    }
}
