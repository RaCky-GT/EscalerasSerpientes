package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TableroControlador tableroControlador = new TableroControlador();
        Jugador jugador = new Jugador();
        Dado dado = new Dado();
        PenalizacionControlador penalizaciones = new PenalizacionControlador();
        penalizaciones.distribucinPenalizaciones();
        int [] listaPenalizaciones = penalizaciones.getPenalizaciones();

        int option;
        int continuar;
        boolean juego_iniciado= true;



        do{
            System.out.println("======== MENU ========");
            System.out.println(" 1. Iniciar Juego");
            System.out.println(" 2. Retomar Juego");
            System.out.println(" 3. Generar Reportes");
            System.out.println(" 4. Salir");
            option = sc.nextInt();


            switch (option){
                case 1:
                    if (juego_iniciado==true){

                        do {
                            System.out.println("\n\n============= ¡A JUGAR! =============");
                            System.out.println(" 1. Sí, lanzar dado.");
                            System.out.println(" 2. No, regresar a menu principal.\n");
                            continuar = sc.nextInt();
                            switch (continuar){
                                case 1:
                                    System.out.println("posición jugador: "+jugador.getPosicion());
                                    dado.lanzarDado();
                                    int avanzar = dado.getValor();
                                    jugador.moverJugador(avanzar);
                                    System.out.println("posición jugador: "+jugador.getPosicion());
                                    tableroControlador.setPenalizaciones(listaPenalizaciones);
                                    tableroControlador.dibujar(jugador.getPosicion());
                                    break;
                                case 2:
                                    System.out.println("Regresando al mfdsenu principal...\n");
                                    break;
                            }


                        }while (continuar!=2);
                        juego_iniciado = false;
                    }else {
                        System.out.println("Se cuenta con un juego iniciado.\nRegresando al menu principal...");
                    }



                    break;
                case 2:

                    if (juego_iniciado==false){

                        do {
                            System.out.println("\n\n============= ¡A JUGAR! =============");
                            System.out.println(" 1. Sí, lanzar dado.");
                            System.out.println(" 2. No, regresar a menu principal.\n");
                            continuar = sc.nextInt();
                            switch (continuar){
                                case 1:
                                    System.out.println("posición jugador: "+jugador.getPosicion());
                                    dado.lanzarDado();
                                    int avanzar = dado.getValor();
                                    jugador.moverJugador(avanzar);
                                    System.out.println("posición jugador: "+jugador.getPosicion());
                                    tableroControlador.setPenalizaciones(listaPenalizaciones);
                                    tableroControlador.dibujar(jugador.getPosicion());
                                    break;
                                case 2:
                                    System.out.println("Regresando al mfdsenu principal...\n");
                                    break;
                            }


                        }while (continuar!=2);
                    }else {
                        System.out.println("No se cuenta con un juego iniciado.\nRegresando al menu principal...");
                    }

                    break ;
                case 3:
                    break ;
                case 4:
                    System.out.println("¡QUE TE HAYAS DIVERTIDO!");
                    break ;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }

        }while (option!=4);
        System.out.println("Saliendo del juego...");
        sc.close();




    }





}
