package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Reportes reportes = new Reportes();
        TableroControlador tableroControlador = new TableroControlador(reportes);
        PenalizacionControlador penalizacionControlador = new PenalizacionControlador(reportes);
        Dado dado = new Dado(reportes);
        Jugador jugador = new Jugador();
        penalizacionControlador.distribucionPenalizaciones();

        Scanner sc = new Scanner(System.in);
        int [] listaPenalizaciones = penalizacionControlador.getPenalizaciones();

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
            reportes.menuPrincipal(String.valueOf(option));

            switch (option){
                case 1:
                    if (juego_iniciado==true){

                        do {
                            System.out.println("\n\n============= ¡A JUGAR! =============");
                            System.out.println(" 1. Sí, lanzar dado.");
                            System.out.println(" 2. No, regresar a menu principal.\n");
                            continuar = sc.nextInt();
                            reportes.subMenu(String.valueOf(continuar));

                            switch (continuar){
                                case 1:

                                    System.out.println("posición jugador: "+jugador.getPosicion());
                                    reportes.agregarP("Posición jugador: "+String.valueOf(jugador.getPosicion()));
                                    dado.lanzarDado();
                                    int avanzar = dado.getValor();
                                    jugador.moverJugador(avanzar);

                                    tableroControlador.setPenalizaciones(listaPenalizaciones);
                                    tableroControlador.dibujar(jugador.getPosicion());
                                    if(jugador.getPosicion()>=64){
                                        System.out.println("\n¡Felicidades Ganaste! El juego ha finalizado.\nSaliendo del juego...");
                                        reportes.agregarP("¡Felicidades Ganaste! El juego ha finalizado.<br>Saliendo del juego...");
                                        System.exit(0);

                                    }

                                    boolean validarPenalizacion = tableroControlador.getJugadorPenalizacion();
                                    if (validarPenalizacion==true){
                                        penalizacionControlador.tipoPenalizacion(tableroControlador.getFilaPenalizacion());
                                    }
                                    break;
                                case 2:
                                    System.out.println("Regresando al menu principal...\n");
                                    reportes.agregarP("Regresando al menu principal...");
                                    break;
                            }


                        }while (continuar!=2);
                        juego_iniciado = false;
                    }else {
                        System.out.println("Se cuenta con un juego iniciado.\nRegresando al menu principal...");
                        reportes.agregarP("Se cuenta con un juego iniciado.<br>Regresando al menu principal...");
                    }

                    break;
                case 2:

                    if (juego_iniciado==false){

                        do {
                            System.out.println("\n\n============= ¡A JUGAR! =============");
                            System.out.println(" 1. Sí, lanzar dado.");
                            System.out.println(" 2. No, regresar a menu principal.\n");
                            continuar = sc.nextInt();
                            reportes.subMenu(String.valueOf(continuar));
                            switch (continuar){
                                case 1:
                                    dado.lanzarDado();
                                    int avanzar = dado.getValor();
                                    jugador.moverJugador(avanzar);

                                    tableroControlador.setPenalizaciones(listaPenalizaciones);
                                    tableroControlador.dibujar(jugador.getPosicion());
                                    if(jugador.getPosicion()>=64){
                                        System.out.println("\n¡Felicidades Ganaste! El juego ha finalizado.\nSaliendo del juego...");
                                        reportes.agregarP("¡Felicidades Ganaste! El juego ha finalizado.<br>Saliendo del juego...");
                                        reportes.generarArchivos();
                                        System.exit(0);

                                    }

                                    boolean validarPenalizacion = tableroControlador.getJugadorPenalizacion();
                                    if (validarPenalizacion==true){
                                        System.out.println("\n !Has caído en una penalización!");
                                        reportes.agregarP("!Has caído en una penalización!");
                                        penalizacionControlador.tipoPenalizacion(tableroControlador.getFilaPenalizacion());
                                    }
                                    break;
                                case 2:
                                    System.out.println("Regresando al menu principal...\n");
                                    reportes.agregarP("Regresando al menu principal...");
                                    break;
                            }


                        }while (continuar!=2);
                    }else {
                        System.out.println("No se cuenta con un juego iniciado.\nRegresando al menu principal...");
                        reportes.agregarP("No se cuenta con un juego iniciado.<br>Regresando al menu principal...");
                    }

                    break ;
                case 3:
                    System.out.println("Generando reportes...");
                    reportes.generarArchivos();
                    System.out.println("Repoertes generados.");
                    break ;
                case 4:
                    System.out.println("¡QUE TE HAYAS DIVERTIDO!");
                    break ;
                default:
                    throw new IllegalStateException("Valor ingresado no definido entre las opciones: " + option);
            }

        }while (option!=4);
        System.out.println("Saliendo del juego...");
        sc.close();




    }





}
