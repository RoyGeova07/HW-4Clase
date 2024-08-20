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

    UsuarioManager usu;

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        new LogIn();
    }

    public LogIn() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Login");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        frame.add(mainPanel);

        // Cargar la imagen desde el paquete imagenes
        ImageIcon imagenFondo = new ImageIcon(LogIn.class.getResource("/imagenes/mini.png"));
        JLabel imageLabel = new JLabel(imagenFondo);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(imageLabel, BorderLayout.WEST);

        // Panel de campos y botones
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Mensaje de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido a tu red social favorita");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(30, 144, 255));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(welcomeLabel);
        inputPanel.add(Box.createVerticalStrut(15)); // Espacio vertical

        // Configuración de los campos de entrada
        inputPanel.add(crearCampo("Username:", usernameField = new JTextField()));
        inputPanel.add(crearCampo("Contraseña:", passwordField = new JPasswordField()));

        JLabel noAccountLabel = new JLabel("¿No tienes cuenta?");
        noAccountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        noAccountLabel.setForeground(Color.GRAY);
        noAccountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(Box.createVerticalStrut(10)); // Espacio vertical
        inputPanel.add(noAccountLabel);

        // Botón de "Crear cuenta"
        JButton CrearCuentaButton = new JButton("¡Click aqui, Crea tu cuenta!");
        CrearCuentaButton.setForeground(new Color(30, 144, 255));
        CrearCuentaButton.setBackground(Color.WHITE);
        CrearCuentaButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        CrearCuentaButton.setFont(new Font("Roboto", Font.BOLD, 14));
        CrearCuentaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(CrearCuentaButton);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.WHITE);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(30, 144, 255));
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espacio vertical
        buttonPanel.add(loginButton);

        inputPanel.add(Box.createVerticalStrut(20)); // Espacio vertical antes de los botones
        inputPanel.add(buttonPanel);

        // Acción del botón CrearCuenta
        CrearCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar el frame de Login
                new CrearCuenta(); // Volver a la pantalla inicial
            }
        });

        // Acción del botón Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Identificacion();
            }
        });

        frame.setVisible(true);
    }

    private JPanel crearCampo(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.BLACK);
        label.setPreferredSize(new Dimension(150, 30));
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label, BorderLayout.WEST);

        field.setPreferredSize(new Dimension(150, 30));
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(Color.BLACK);
        field.setBackground(Color.WHITE);
        field.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2)); // Bor de azul claro
        panel.add(field, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Espacio alrededor

        return panel;
    }

    private void Identificacion() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        // Verificación de las credenciales
        if (UsuarioManager.autenticar(username, password)) {
            JOptionPane.showMessageDialog(null, "Login exitoso. ¡Bienvenido!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose(); // Cerrar el frame de Login
            new MenuPrincipal(username);
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
