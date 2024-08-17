/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

/**
 *
 * @author royum
 */
public class Followers {

    private String[] seguidores; // arreglo para guardar los nombres de los usuario seguidores
    private int numeroSeguidores; //  este sirve para añadir un nuevo seguidor

    // constructor 
    public Followers() {

        this.seguidores = new String[1000];
        this.numeroSeguidores = 0;

    }

    // metodo que me servira para agregar nuevos seguidores
    public void agregarSeguidor(String nuevoSeguidor) {

        if (!existeSeguidor(nuevoSeguidor)) { // este verifica si el usuario ya esta en la lista de seguidores.
            if (numeroSeguidores < 1000) {
                seguidores[numeroSeguidores] = nuevoSeguidor;
                numeroSeguidores++;
                System.out.println(nuevoSeguidor + " ahora sigue al usuario");
            } else {
                System.out.println("Este usuario ya ha alcanzado el limite de seguidores");
            }
        } else {
            System.out.println("El usuario " + nuevoSeguidor + " ya es un seguidor");
        }

    }

    private boolean existeSeguidor(String Seguidor) {
        for (int ite = 0; ite < numeroSeguidores; ite++) {
            if (seguidores[ite].equals(Seguidor)) {
                return true;
            }
        }
        return false;
    }

    public int getNumeroSeguidores() {
        return numeroSeguidores;
    }

    public String[] getSeguidores() {

        return seguidores;
    }

}
