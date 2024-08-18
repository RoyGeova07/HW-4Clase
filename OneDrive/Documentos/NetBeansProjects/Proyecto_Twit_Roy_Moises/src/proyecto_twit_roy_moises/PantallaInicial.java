/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_twit_roy_moises;

import java.util.Scanner;

import javax.swing.*; // libreria de swing
import java.awt.*; // este proporciona las herramientas necesarias para crear interfaces graficas, dibujar graficos y manejar eventos en aplicaciones java
import java.awt.event.ActionEvent; // este se utliza para notificar cuando ocurre una accion signficativa, en un componente, como boton presionado o elemento de menu seleccionado 
import java.awt.event.ActionListener; // esta libreria permite recibir eventos de accion, este invoca cuando cuando ocurre una accion

/**
 *
 * @author royum
 */
public class PantallaInicial {

    private String username;

    public PantallaInicial(String username) {
        this.username = username;
        initUI();
    }

    public static void main(String[] args) {
        new PantallaInicial(null);
    }

    private void initUI() {
        JFrame frame = new JFrame("Pantalla Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); // Centrar el frame en pantalla

        // Cargar la imagen desde el paquete 'imagenes'
        ImageIcon imagenFondo = new ImageIcon(PantallaInicial.class.getResource("/imagenes/Menu Inicio.jpg"));

        // Crear el JLabel con la imagen como fondo
        JLabel labelFondo = new JLabel(imagenFondo);
        labelFondo.setLayout(new BorderLayout()); // aquí se establece layout para añadir paneles sobre la imagen

        frame.setContentPane(labelFondo); // aquí se establece el label con la imagen como contenido principal del frame

        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false); // Hacer el panel transparente para ver la imagen de fondo
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Usar BoxLayout para organizar los botones en columna

        // Crear y configurar los botones
        JButton botonLogIn = new JButton("LOG IN");
        JButton botonCrearCuenta = new JButton("CREAR CUENTA");
        JButton botonSalir = new JButton("SALIR DEL SISTEMA");

        botonLogIn.setBackground(new Color(0, 48, 143));
        botonLogIn.setForeground(Color.white);
        botonCrearCuenta.setBackground(new Color(85, 153, 0));
        botonCrearCuenta.setForeground(Color.white);
        botonSalir.setBackground(Color.red);
        botonSalir.setForeground(Color.white);

        // Agregar acciones a los botones
        botonLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LogIn();

            }
        });

        botonCrearCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra el frame de pantalla inicial.
                new CrearCuenta(); // Abre la ventana para crear una cuenta.
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir del programa
            }
        });

        // Añadir espacio entre los botones y centrarlos
        botonLogIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCrearCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir los botones al panel con espacio
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20))); // Añadir espacio antes del primer boton
        panelBotones.add(botonLogIn);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        panelBotones.add(botonCrearCuenta);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        panelBotones.add(botonSalir);

        // Añadir el panel de botones al fondo
        labelFondo.add(panelBotones, BorderLayout.CENTER); // Colocar el panel de botones en el centro

        // Mostrar el frame
        frame.setVisible(true);

    }
}
