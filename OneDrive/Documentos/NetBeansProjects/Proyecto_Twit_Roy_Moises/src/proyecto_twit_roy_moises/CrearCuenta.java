/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

import javax.swing.*; // libreria de swing
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author royum
 */
public class CrearCuenta {


    User usuario;

    private JFrame frame;
    private JTextField nombreField;
    private JComboBox generoComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField edadField;

    private String[] usernames;

    public CrearCuenta() {
        usernames = new String[1000]; 
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Crea tu cuenta");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel para contener los campos de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white); 
        frame.add(panel);

        // Configuracion de las etiquetas y campos de entrada
        panel.add(crearCampo("Nombre:", nombreField = new JTextField()));
        panel.add(crearCampo("Género:", generoComboBox = new JComboBox(new String[]{"Masculino", "Femenino"})));
        panel.add(crearCampo("Username:", usernameField = new JTextField()));
        panel.add(crearCampo("Contraseña (5 caracteres):", passwordField = new JPasswordField()));
        panel.add(crearCampo("Edad:", edadField = new JTextField()));

        JButton registerButton = new JButton("Crear Cuenta");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10)); // Espacio vertical
        panel.add(registerButton);
        
        JButton RegresarInicio = new JButton("Regresar Inicio");
        RegresarInicio.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(RegresarInicio);
        
        panel.add(Box.createVerticalStrut(0));
        panel.add(RegresarInicio);

        // Accion del boton Registrar
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed();
            }
        });
        
         // Accion del boton Regresar Inicio
        RegresarInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                frame.dispose(); // Cerrar el frame de Login
                new PantallaInicial(null); // Volver a la pantalla inicial
                
            }
        });

        frame.setVisible(true);
    }

    private JPanel crearCampo(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(Color.white);
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.black);
        label.setPreferredSize(new Dimension(150, 30));
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label, BorderLayout.WEST);

        field.setPreferredSize(new Dimension(150, 30));
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(Color.black);
        field.setBackground(Color.white);
        field.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2)); // Borde azul claro
        panel.add(field, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Espacio alrededor

        return panel;
    }

    private void jButton1ActionPerformed() {
        String nombre = nombreField.getText().trim();
        String genero = (String) generoComboBox.getSelectedItem();
        String nombreUsuario = usernameField.getText().trim();
        String contrasena = new String(passwordField.getPassword()).trim();
        String edadText = edadField.getText().trim();

        // Validacion de campos vacios
        if (nombre.isEmpty() || genero == null || nombreUsuario.isEmpty() || contrasena.isEmpty() || edadText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validacion de la contraseña
        if (contrasena.length() != 5) {
            JOptionPane.showMessageDialog(null, "La contraseña tiene que tener exactamente 5 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validacion de la edad
        int edad;
        try {
            edad = Integer.parseInt(edadText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(edad < 1 || edad>  90){
            
            JOptionPane.showMessageDialog(null, "La edad tiene que ser acorde limite de 90.", "Error",JOptionPane.ERROR_MESSAGE);
            return; // este return hace que no se registre con exito si se excede numero
            
        }

        // Verificacion del nombre de usuario
        if (!UsuarioManager.usuarioExiste(nombreUsuario)) {
            // Agregar nuevo usuario
            if (UsuarioManager.agregarUsuario(nombreUsuario,contrasena)) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con exito.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose(); // Cerrar el frame de CrearCuenta
                new PantallaInicial(nombreUsuario); // Reabrir el menu inicial con el username registrado
            } else {
                JOptionPane.showMessageDialog(null, "El usuario no pudo ser registrado. Intentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
