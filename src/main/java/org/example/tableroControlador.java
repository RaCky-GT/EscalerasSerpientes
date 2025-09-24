package org.example;

import java.util.Random;

public class tableroControlador {
    public static void dibujar() {
        System.out.println("----------------------------------------");
        for (int fila = 7; fila >= 0; fila--) {
            int inicioFila = fila * 8 + 1;
            for (int col = 0; col < 8; col++) {
                // numero = numero + 1;
                int numero = inicioFila + col;
                String celda = String.valueOf(numero);

                if (numero == 9 || numero == 25 || numero == 41 || numero == 57) {
                    int celdaX = numero + 7;
                    for (int i = 0; i < 8; i++) {
                        System.out.printf("|%-4s", celdaX - i);
                    }
                    continue;
                }
                if (numero == 8 || numero == 24 || numero == 40 || numero == 56) {
                    System.out.printf("|%-4s", celda);
                    break;
                }
                if ((numero >= 10 && numero <= 16) || (numero >= 26 && numero <= 32) ||
                        (numero >= 42 && numero <= 48) || (numero >= 58 && numero <= 64)) {
                    System.out.print("");
                } else {
                    System.out.printf("|%-4s", celda);
                }
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
