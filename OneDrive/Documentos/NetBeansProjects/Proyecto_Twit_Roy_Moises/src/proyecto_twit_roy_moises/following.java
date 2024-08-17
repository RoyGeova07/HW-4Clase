/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_twit_roy_moises;

/**
 *
 * @author royum
 */
public class following {

    private String[] seguidos;
    private int numeroSeguidos;

    public following() {
        this.seguidos = new String[1000];
        this.numeroSeguidos = 0;

    }

    public void seguirUsuario(String Nuevoseguido) {
        if (!existeSeguido(Nuevoseguido)) {
            if (numeroSeguidos < 1000) {
                seguidos[numeroSeguidos] = Nuevoseguido;
                numeroSeguidos++;
                System.out.println("Ahora sigues a " + Nuevoseguido + ".");
            } else {
                System.out.println("Ya has alcanzado el numero limite de usuarios seguidos que peudes seguir.");
            }
        } else {
            System.out.println("ya sigues a " + Nuevoseguido + ".");
        }

    }

    private boolean existeSeguido(String seguido) {
        for (int xd = 0; xd < numeroSeguidos; xd++) {
            if (seguidos[xd].equals(seguido)) {
                return true;

            }
        }
        return false;
    }

    public int getNumeroSeguidos() {
        return numeroSeguidos;
    }

    public String[] getSeguidos() {
        return seguidos;
    }

}
