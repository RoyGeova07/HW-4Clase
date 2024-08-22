/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw_.pkg4_clase;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author royum
 */
public class Umana_Roy_BiArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);
        Random rand = new Random();

        int dimensiones = 0;
        int sumaDiagonalPrincipal = 0;
        int sumaDigonalSecundaria = 0;
        String resultadoPrimario = "";
        String resultadosecundario = "";

        System.out.println("Ingrese la cantida de dimensiones NxN: ");
        dimensiones = lea.nextInt();

        int matriz[][] = new int[dimensiones][dimensiones];

        for (int filas = 0; filas < dimensiones; filas++) {
            for (int columnas = 0; columnas < dimensiones; columnas++) {
                matriz[filas][columnas] = rand.nextInt(90) + 10;
            }
        }

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println("");
        }

        for (int DiagonalPrincipal = 0; DiagonalPrincipal < dimensiones; DiagonalPrincipal++) {
            sumaDiagonalPrincipal += matriz[DiagonalPrincipal][DiagonalPrincipal];
            resultadoPrimario += matriz[DiagonalPrincipal][DiagonalPrincipal] + " ";
        }

        for (int DiagonalSecundario = 0; DiagonalSecundario < dimensiones; DiagonalSecundario++) {
            sumaDigonalSecundaria += matriz[DiagonalSecundario][dimensiones - DiagonalSecundario - 1];
            resultadosecundario += matriz[DiagonalSecundario][dimensiones - DiagonalSecundario - 1] + " ";
        }

        System.out.println("****Resultado****");
        System.out.println("Suma Principal: " + sumaDiagonalPrincipal);
        System.out.println("Suma secundaria: " + sumaDigonalSecundaria);
        System.out.println(resultadoPrimario + " = " + sumaDiagonalPrincipal);
        System.out.println(resultadosecundario + " = " + sumaDigonalSecundaria);

    }

}
