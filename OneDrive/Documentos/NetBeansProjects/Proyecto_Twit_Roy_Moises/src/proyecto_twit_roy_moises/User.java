/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

import java.util.Date;

/**
 *
 * @author royum
 */
public class User {

    private String nombre;
    private char genero;
    private String nombreUsuario;
    private String contrasena;
    private Date fechaEntrada;
    private int edad;
    private boolean estadoActivo;

    // Constructor
    public User(String nombre, char genero, String nombreUsuario, String contrasena, int edad) {
        this.nombre = nombre;
        this.genero = genero;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaEntrada = new Date(); // Se toma la fecha actual
        this.edad = edad;
        this.estadoActivo = true; // Por defecto, la cuenta está activa
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    // para desactivar la cuenta
    public void desactivarCuenta() {
        this.estadoActivo = false;
    }
}
