package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TableroControlador tableroControlador = new TableroControlador();
        Jugador jugador = new Jugador();
        Dado dado = new Dado();

        int option;

        do{
            System.out.println("======== MENU ========");
            System.out.println(" 1. Iniciar Juego");
            System.out.println(" 2. Retomar Juego");
            System.out.println(" 3. Generar Reportes");
            System.out.println(" 4. Salir");
            option = sc.nextInt();

            switch (option){
                case 1:
                    while (jugador.getPosicion()<64){
                        System.out.println("posición jugador: "+jugador.getPosicion());
                        dado.lanzarDado();
                        int avanzar = dado.getValor();
                        jugador.moverJugador(avanzar);
                        System.out.println("posición jugador: "+jugador.getPosicion());
                        tableroControlador.dibujar(jugador.getPosicion());
                    }
                    break;
                case 2:
                    break ;
                case 3:
                    break ;
                case 4:
                    break ;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }

        }while (option!=4);
        System.out.println("Se finaliza el juego.");
        sc.close();
    }
/*
    static void jugar(){
        Scanner sc = new Scanner(System.in);

        while (jugador.getPosicion()<64){
            tableroControlador.dibujar();
            System.out.println("\n \nPresione ENTER para lanzar el dado.");

            sc.nextLine();
            dado.lanzarDado();
            int movimiento = dado.getValor();
            jugador.moverJugador(movimiento);

        }
    }*/


}
