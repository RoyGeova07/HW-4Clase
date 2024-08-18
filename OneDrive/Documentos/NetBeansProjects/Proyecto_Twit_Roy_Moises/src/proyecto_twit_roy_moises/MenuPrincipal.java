/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author royum
 */
public class MenuPrincipal {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public MenuPrincipal() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Menú Principal");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Panel de botones de navegacion
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(1, 6, 10, 10)); // Seis botones en una fila
        navPanel.setBackground(Color.lightGray);

        JButton timelineButton = new JButton("Timeline");
        JButton tweetButton = new JButton("Mandar Tweet");
        JButton interactionsButton = new JButton("Interacciones");
        JButton editProfileButton = new JButton("Editar Perfil");
        JButton searchButton = new JButton("Buscar Hashtags");
        JButton logoutButton = new JButton("Cerrar Sesión");

        // Añadir botones al panel de navegacion
        navPanel.add(timelineButton);
        navPanel.add(tweetButton);
        navPanel.add(interactionsButton);
        navPanel.add(editProfileButton);
        navPanel.add(searchButton);
        navPanel.add(logoutButton);

        // Panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.white);

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

        interactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInteracciones();
            }
        });

        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarPerfil();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarHashtags();
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
        // aqui ira funcionalidad para mostrar 
       
    }

    private void mandarTweet() {
        // aqui ira funcionalidad para mandar un tweet
      
    }

    private void mostrarInteracciones() {
        // aqui ira  funcionalidad para mostrar interacciones
     
    }

    private void editarPerfil() {
        // aqui ira funcionalidad para editar el perfil
        
    }

    private void buscarHashtags() {
        // aqui ira funcionalidad para buscar hashtags
        
    }

    private void cerrarSesion() {
        
        frame.dispose(); // Cerrar el frame de menu principal
        new LogIn(); // Volver a mostrar el login
    }

}
