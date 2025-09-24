package org.example;

import java.util.Random;

public class tableroControlador {
    public static void dibujar() {
        System.out.println("----------------------------------------");

        for (int fila = 7; fila >= 0; fila--) {
            int inicioFila = fila * 8 + 1;

            for (int col = 0; col < 8; col++) {
                int numero = 0;

                if (fila % 2 == 0) {
                    // Fila par izquierda a derecha
                    numero = inicioFila + col;
                } else {
                    // Fila impar derecha a izquierda
                    numero = inicioFila + (7 - col);
                }

                System.out.printf("|%-4s", numero);
            }

            System.out.println("|");
            System.out.println("----------------------------------------");
        }
    }

    public static void lanzarDado(){
        int min=2;
        int max=6;
        Random random = new Random();
        int valor = random.nextInt(max - min + 1) + min;
        System.out.println("valor dado: "+valor);
    }

}
