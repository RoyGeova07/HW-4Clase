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
import java.util.Calendar;
import java.awt.event.ComponentEvent; // se utiliza para notificar cambios en la posición, tamaño o visibilidad de un componente en una interfaz gráfica de usuari

/**
 *
 * @author royum
 */
public class PantallaInicial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // titulo del frame
        JFrame frame = new JFrame("Pantalla Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(426, 256);
        frame.setLocationRelativeTo(null); // Centrar el frame en pantalla

        // Cargar la imagen desde el paquete 'imagenes'
        ImageIcon imagenFondo = new ImageIcon(PantallaInicial.class.getResource("/imagenes/Menu Inicio.png"));

        // Crear el JLabel con la imagen como fondo
        JLabel labelFondo = new JLabel(imagenFondo);
        labelFondo.setLayout(new BorderLayout()); // aqui se establece layout para añadir paneles sobre la imagen

        frame.setContentPane(labelFondo); // aqui se establece el label con la imagen como contenido principal del frame

        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false); // Hacer el panel transparente para ver la imagen de fondo
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Usar BoxLayout para organizar los botones en columna

        // Crear y configurar los botones
        JButton botonLogIn = new JButton("LOG IN");
        JButton botonCrearCuenta = new JButton("CREAR CUENTA");
        JButton botonSalir = new JButton("SALIR DEL SISTEMA");

        // Agregar acciones a los botones
        botonLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            // agregar funcion del boton
                
            }
        });

        botonCrearCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // agregar funcion del boton
                
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

        // Se Añadw el panel de botones al fondo
        labelFondo.add(panelBotones, BorderLayout.CENTER); // Colocar el panel de botones en el centro

        // este ayuda a hacer visible el frame
        frame.setVisible(true);
    }
}
