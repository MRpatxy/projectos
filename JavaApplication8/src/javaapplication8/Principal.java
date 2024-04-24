/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication8;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Aitor
 */

public class Principal {

    public static final String esNumGolBa = "Escribe el numero de goles mas bajo de los partidos";
    public static final String esNumGolAl = "Escribe el numero de goles mas alto de los partidos";
    
    private static int golesBajo;
    private static int golesAlto;

    public static void main(String[] args) {
        //creamos el array de strings y usando el metodo lo llenamos con los equipos de manera aleatoria
        String[][] equipos = reQuiEqui();

        Scanner sc = new Scanner(System.in);

        System.out.println(esNumGolBa);
        golesBajo = sc.nextInt();

        System.out.println(esNumGolAl);
        golesAlto = sc.nextInt();
        
        //creamos el array de enteros y usando el metodo
        int[][] resultados = darRes(golesBajo, golesAlto);
        
        //llamamos al metodo visualizar
        vis(equipos, resultados);

        System.out.println("Esperamos que halla tenido suerte");
        System.out.println("Fin del Programa");

    }

    public static void vis(String[][] equi, int[][] res) {
        for (int i = 0; i < equi.length; i++) {
            for (int j = 0; j < equi[i].length; j = j + 2) {
                String resultado;//creanis un string que es con el que mostraremos el empate o que a ganado el de la derecha o el de la izquierda
                if (res[i][j] > res[i][j + 1]) {//si el primer equpo tiene mayor numero de goles muestra el 1
                    resultado = "1";
                } else if (res[i][j] < res[i][j + 1]) {//si el primer equpo tiene mayor numero de goles muestra el 2
                    resultado = "2";
                } else {//si los dos son iguales muestra una x
                    resultado = "x";
                }
                String priEqui = "El primer equipo es: ";
                String segEqui = " El segundo equipo es: ";
                String resFin = " El resultado final: ";
                
                System.out.println(priEqui + equi[i][j] + segEqui + equi[i][j + 1] + resFin + resultado);//mostramos todos los resultados
                
            }
        }

    }

    public static String[][] reQuiEqui() {
        ArrayList<String> lsEqu = new ArrayList<String>();//el array list con todos los equipos
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

        String[][] equi = new String[15][2];

        int con = 0;//nos servira para que luego no salga el numero random del alcance del array list
        for (int i = 0; i < equi.length; i++) {
            for (int j = 0; j < equi[0].length; j++) {
                Random r1 = new Random(); //es una clase especifica para generar numeros aleatorios
                int num = r1.nextInt(0, 30 - con);//esto significa que va de 0 a 30 incluidos y que se le ira resntando el contador
                equi[i][j] = lsEqu.get(num);//se añade el equipo
                lsEqu.remove(num);//el mismo equipo se borra de la lista
                con++;
            }
        }

        return equi;

    }

    public static int[][] darRes(int golBa, int golAl) {//este es mucho mas sencillo
        int[][] res = new int[15][2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                Random r1 = new Random();
                int num = r1.nextInt(golBa, golAl);// simplemente cojemos valores entre  0 y 10 de manera aleatoria
                res[i][j] = num;
            }
        }
        return res;
    }

}

    

