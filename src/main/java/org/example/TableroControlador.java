package org.example;

public class TableroControlador {

    public void dibujar(int jugador) {
        int numero;

        System.out.println("----------------------------------------");
        for (int fila = 7; fila >= 0; fila--) {
            int inicioFila = fila * 8 + 1;

            for (int col = 0; col < 8; col++) {

                if (fila % 2 == 0) {
                    // Fila par izquierda a derecha
                    numero = inicioFila + col;
                    imprimirCasilla(numero, jugador);
                } else {
                    // Fila impar derecha a izquierda
                    numero = inicioFila + (7 - col);
                    imprimirCasilla(numero, jugador);
                }


            }

            System.out.println("|");
            System.out.println("----------------------------------------");
        }
    }




    public void imprimirCasilla(int posicion, int jugador){
        String casilla = String.valueOf(posicion);
        if(posicion == jugador){
            casilla +=" @";
        }
        System.out.printf("|%-4s", casilla);
    }



}
