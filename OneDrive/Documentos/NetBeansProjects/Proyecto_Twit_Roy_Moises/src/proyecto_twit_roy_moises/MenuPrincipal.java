/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

/**
 *
 * @author royum
 */
public class MenuPrincipal {

    private JFrame frame;
    private JTextArea tweetArea;
    private JLabel letrasContadasLabel;
    private JPanel espacioPanel;
    private Twits twits;
    private String UsuarioActual;

    public MenuPrincipal(String UsuarioActual) {
        this.UsuarioActual = UsuarioActual;
        twits = new Twits(); // Inicializamos la clase Twits
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Menu Principal");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Panel de botones de navegación
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(1, 6, 10, 10)); // Seis botones en una fila
        navPanel.setBackground(Color.lightGray);

        JButton timelineButton = new JButton("Timeline");
        JButton tweetButton = new JButton("Mandar Tweet");
        JButton interactionsButton = new JButton("Interacciones");
        JButton editProfileButton = new JButton("Editar Perfil");
        JButton searchButton = new JButton("Buscar Hashtags");
        JButton logoutButton = new JButton("Cerrar Sesion");

        // Añadir botones al panel de navegación
        navPanel.add(timelineButton);
        navPanel.add(tweetButton);
        navPanel.add(interactionsButton);
        navPanel.add(editProfileButton);
        navPanel.add(searchButton);
        navPanel.add(logoutButton);

        // Panel de contenido
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.white);

        // Panel para escribir tweets
        JPanel tweetPanel = new JPanel(new BorderLayout());
        tweetPanel.setBorder(BorderFactory.createTitledBorder("¿En que estas pensando?"));
        tweetArea = new JTextArea(3, 25); // Ajusta el tamaño del área de texto
        tweetArea.setLineWrap(true);
        tweetArea.setWrapStyleWord(true);
        tweetPanel.add(new JScrollPane(tweetArea), BorderLayout.CENTER);

        // Contador de caracteres
        JPanel bottomPanel = new JPanel(new BorderLayout());
        letrasContadasLabel = new JLabel("0/140 caracteres");
        tweetPanel.add(letrasContadasLabel, BorderLayout.SOUTH);
        bottomPanel.add(letrasContadasLabel, BorderLayout.WEST);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton publishButton = new JButton("Publicar");
        buttonPanel.add(publishButton);

        bottomPanel.add(publishButton, BorderLayout.EAST);

        tweetPanel.add(bottomPanel, BorderLayout.SOUTH);

        contentPanel.add(tweetPanel, BorderLayout.NORTH);

        contentPanel.add(tweetPanel, BorderLayout.NORTH);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Panel para mostrar los tweets
        espacioPanel = new JPanel();
        espacioPanel.setLayout(new BoxLayout(espacioPanel, BoxLayout.Y_AXIS));
        espacioPanel.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2));  // borde azulito
        JScrollPane timelineScrollPane = new JScrollPane(espacioPanel);
        contentPanel.add(timelineScrollPane, BorderLayout.CENTER);

        // Añadir paneles al panel principal
        mainPanel.add(navPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Configuracion de los botones de navegacion
        timelineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTimeline();
            }
        });

        tweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mandarTweet();
            }
        });

        publishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido = tweetArea.getText().trim();
                if (!contenido.isEmpty() && contenido.length() <= 140) {
                    twits.Publicartwit(UsuarioActual, contenido); // Se usa el nombre del usuario actual
                    JOptionPane.showMessageDialog(frame, "Tweet publicado exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    actualizarTimeline();
                    tweetArea.setText("");
                    letrasContadasLabel.setText("0/140 caracteres");
                } else if (contenido.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "El tweet no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "El tweet excede los 140 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tweetArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int contadorLetras = tweetArea.getText().length();
                letrasContadasLabel.setText(contadorLetras + "/140 caracteres");
                if (contadorLetras > 140) {
                    letrasContadasLabel.setForeground(Color.RED);
                } else {
                    letrasContadasLabel.setForeground(Color.BLACK);
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });

        frame.setVisible(true);
    }

    private void mostrarTimeline() {
        actualizarTimeline();
    }

    private void mandarTweet() {
        tweetArea.requestFocus();
    }

    private void actualizarTimeline() {
        espacioPanel.removeAll();
        for (int twi = 0; twi < twits.getNumeroTwits(); twi++) {
            Twit twit = twits.getTwits()[twi];
            JLabel tweetLabel = new JLabel(twit.getUsername() + " escribio: \n“"
                    + twit.getContenido() + "”\n el " + twit.getFechapublicacion());
            tweetLabel.setForeground(Color.black); // color azulito letras
            tweetLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            espacioPanel.add(tweetLabel);
        }
        espacioPanel.revalidate();
        espacioPanel.repaint();
    }

    private void cerrarSesion() {
        frame.dispose(); // Cerrar el frame de menu principal
        new LogIn(); // Volver a mostrar el login
    }

}
