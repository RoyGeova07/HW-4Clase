/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

import java.util.Date;

// esta clase twit  maneja el almacenamiento de los twits publicados por el usuario. 
// Cada twit almacena el nombre de usuario, la fecha de publicación y el contenido del twit

/**
 *
 * @author royum
 */
public class Twit {

    private String username;
    private Date Fechapublicacion;
    private String contenido;
    private boolean contenidovalido;

    // constrcutor del twitz x.
    public Twit(String username, String contenido) {

        this.username = username;
        this.Fechapublicacion = new Date();
        if (contenido.length() <= 140) {
            this.contenido = contenido;
            this.contenidovalido = true; // el contenido que se ingreso es valido
        } else {

            this.contenido = "Contenido invalido, excede los 140 caracteres.";
            this.contenidovalido = false; // contenido no validooo
        }

    }

    public String getUsername() {
        return username;
    }

    public Date getFechapublicacion() {
        return Fechapublicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public boolean isContenidovalido() {
        return contenidovalido;
    }

    @Override
    public String toString() {
        return "Twit publicado por @" + username + " en " + Fechapublicacion + ": " + contenido;
    }

}
