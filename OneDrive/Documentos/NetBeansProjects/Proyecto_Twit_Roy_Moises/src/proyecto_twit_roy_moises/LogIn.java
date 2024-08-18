/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author royum
 */
public class LogIn {

    PantallaInicial ptan;

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LogIn() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Login");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel para contener los campos de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white);
        frame.add(panel);

        // Configuracion de las etiquetas y campos de entrada
        panel.add(crearCampo("Username:", usernameField = new JTextField()));
        panel.add(crearCampo("Contraseña:", passwordField = new JPasswordField()));

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.white);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espacio vertical
        buttonPanel.add(loginButton);

        JButton regresarButton = new JButton("Regresar Inicio");
        regresarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espacio vertical
        buttonPanel.add(regresarButton);

        panel.add(Box.createVerticalStrut(20)); // Espacio vertical antes de los botones
        panel.add(buttonPanel);

        // Acción del botón Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Identificacion();
            }
        });

        // Acción del botón Regresar
        regresarButton.addActionListener(new ActionListener() {
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

    // este metodo sirve para identificar si el username y la contrasena estan correctas
    private void Identificacion() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        // Verificación de las credenciales
        if (UsuarioManager.autenticar(username, password)) {
            JOptionPane.showMessageDialog(null, "Login exitoso. Bienvenido!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose(); // Cerrar el frame de Login
            new MenuPrincipal();
        } else {
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "Usuario o contraseña incorrectos. ¿Desea intentar nuevamente o crear una cuenta?",
                    "Error de Login",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );

            if (respuesta == JOptionPane.NO_OPTION) {
                new CrearCuenta(); // Abrir pantalla de crear cuenta
                frame.dispose(); // Cerrar el frame de Login
            }
        }
    }
}
