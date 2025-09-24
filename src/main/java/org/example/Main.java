package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("======== MENU ========");
            System.out.println(" 1. Iniciar Juego");
            System.out.println(" 2. Retomar Juego");
            System.out.println(" 3. Generar Reportes");
            System.out.println(" 4. Salir");
            option = sc.nextInt();

            switch (option){
                case 1:
                    tableroControlador.dibujar();
                    tableroControlador.lanzarDado();

                    break;

            }

        }while (option!=4);
        System.out.println("Se finaliza el juego.");
        sc.close();
    }


}
