package javaapplication8;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Aitor, Naira y Ayoub
 * Esta clase implementa un simulador de resultados de partidos de fútbol entre equipos aleatorios.
 * @version 1.0
 * @since 2024-04-17
 */
public class Principal {

    /**
     * Constante que indica el mensaje para solicitar al usuario el número más
     * bajo de goles esperados en los partidos.
     */
    public static final String esNumGolBa = "Escribe el numero de goles mas bajo de los partidos";

    /**
     * Constante que indica el mensaje para solicitar al usuario el número más
     * alto de goles esperados en los partidos.
     */
    public static final String esNumGolAl = "Escribe el numero de goles mas alto de los partidos";

    private static int golesBajo;
    private static int golesAlto;

    /**
     * Método principal que inicia la ejecución del simulador de resultados de
     * partidos.
     * @since 2024-04-17
     * @param args Los argumentos de la línea de comandos .
     */
    public static void main(String[] args) {
        // Creamos el array de strings y usando el método lo llenamos con los equipos de manera aleatoria
        String[][] equipos = reQuiEqui();

        Scanner sc = new Scanner(System.in);

        System.out.println(esNumGolBa);
        golesBajo = sc.nextInt();

        System.out.println(esNumGolAl);
        golesAlto = sc.nextInt();

        // Creamos el array de enteros y usando el método
        int[][] resultados = darRes(golesBajo, golesAlto);

        // Llamamos al método visualizar
        vis(equipos, resultados);

        System.out.println("Esperamos que halla tenido suerte");
        System.out.println("Fin del Programa");

    }

    /**
     * Método para visualizar los resultados de los partidos entre los equipos.
     *
     * @param equi El array bidimensional de strings que contiene los nombres de
     * los equipos.
     * @param res El array bidimensional de enteros que contiene los resultados
     * de los partidos.
     * @since 2024-04-20
     */
    public static void vis(String[][] equi, int[][] res) {
        for (int i = 0; i < equi.length; i++) {
            for (int j = 0; j < equi[i].length; j = j + 2) {
                String resultado; // Creamos un string que es con el que mostraremos el empate o quién ha ganado
                if (res[i][j] > res[i][j + 1]) {
                    resultado = "1";
                } else if (res[i][j] < res[i][j + 1]) {
                    resultado = "2";
                } else {
                    resultado = "x";
                }
                String priEqui = "El primer equipo es: ";
                String segEqui = " El segundo equipo es: ";
                String resFin = " El resultado final: ";

                System.out.println(priEqui + equi[i][j] + segEqui + equi[i][j + 1] + resFin + resultado);

                
                System.out.println(priEqui + equi[i][j] + segEqui + equi[i][j + 1] + resFin + resultado);//mostramos todos los resultados
                

            }
        }

    }

    /**
     * Este sera un método para generar aleatoriamente los nombres de los equipos.
     *
     * @return Un array bidimensional de strings que contiene los nombres de los
     * equipos.
     * @since 2024-04-20
     */
    public static String[][] reQuiEqui() {
        ArrayList<String> lsEqu = new ArrayList<String>(); // El array list con todos los equipos
        lsEqu.add("Atletico de Madrid");
        lsEqu.add("Atletico de Bilbao");
        lsEqu.add("La Real Sociedad");
        lsEqu.add("Barcelona F.C.");
        lsEqu.add("Real Madrid");
        lsEqu.add("Real Betis");
        lsEqu.add("Girona");
        lsEqu.add("Getafe");
        lsEqu.add("Las Palmas");
        lsEqu.add("Valencia C.F.");
        lsEqu.add("Osasuna");
        lsEqu.add("Alaves");
        lsEqu.add("Villareal");
        lsEqu.add("Rayo Vallecano");
        lsEqu.add("Sevilla");
        lsEqu.add("Mallorca");
        lsEqu.add("Celta de Vigo");
        lsEqu.add("Cadiz");
        lsEqu.add("Granada C.F.");
        lsEqu.add("Almeria");
        lsEqu.add("Espanyol");
        lsEqu.add("Zaragoza");
        lsEqu.add("Albacete");
        lsEqu.add("Racing Santander");
        lsEqu.add("Cartagena");
        lsEqu.add("Burgos C.F");
        lsEqu.add("Amorabieta");
        lsEqu.add("Alcorcon");
        lsEqu.add("F.C Andorra");
        lsEqu.add("ELCHE");
        // Añade más nombres de equipos...

        String[][] equi = new String[15][2];

        int con = 0; // Nos servirá para que luego no salga el número random del alcance del array list
        for (int i = 0; i < equi.length; i++) {
            for (int j = 0; j < equi[0].length; j++) {
                Random r1 = new Random(); // Es una clase específica para generar números aleatorios
                int num = r1.nextInt(0, 30 - con); // Esto significa que va de 0 a 30 incluidos y que se le irá restando el contador
                equi[i][j] = lsEqu.get(num); // Se añade el equipo
                lsEqu.remove(num); // El mismo equipo se borra de la lista
                con++;
            }
        }

        return equi;
    }

    /**
     * Método para generar aleatoriamente los resultados de los partidos.
     *
     * @param golBa El número más bajo de goles esperados en los partidos.
     * @param golAl El número más alto de goles esperados en los partidos.
     * @return Un array bidimensional de enteros que contiene los resultados de
     * los partidos.
     * @since 2024-04-20
     */
    public static int[][] darRes(int golBa, int golAl) {
        int[][] res = new int[15][2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                Random r1 = new Random();
                int num = r1.nextInt(golBa, golAl); // Simplemente cojemos valores entre  0 y 10 de manera aleatoria
                res[i][j] = num;
            }
        }
        return res;
    }

}
