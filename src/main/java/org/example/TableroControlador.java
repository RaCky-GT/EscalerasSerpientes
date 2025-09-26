package org.example;

public class TableroControlador {
    private int[] penalizaciones;
    boolean jugadorPenalizacion = false;
    int filaPenalizacion =0;

    public void setPenalizaciones(int[] penalizaciones) {
        this.penalizaciones = penalizaciones;
    }

    public void dibujar(int jugador) {
        int numero;
        jugadorPenalizacion = false;

        System.out.println("---------------------------------------------------------");
        for (int fila = 7; fila >= 0; fila--) {
            int inicioFila = fila * 8 + 1;

            for (int col = 0; col < 8; col++) {

                if (fila % 2 == 0) {
                    // Fila par izquierda a derecha
                    numero = inicioFila + col;
                } else {
                    // Fila impar derecha a izquierda
                    numero = inicioFila + (7 - col);
                }
                imprimirCasilla(numero, jugador, fila);
            }

            System.out.println("|");
            System.out.println("---------------------------------------------------------");
        }
    }


    public void imprimirCasilla(int posicion, int jugador, int fila){
        String casilla = String.valueOf(posicion);
        boolean casillaPenalizacion = false;

        for (int i = 0; i < penalizaciones.length; i++) {
            if (penalizaciones[i] == posicion) {
                casillaPenalizacion = true;
                break;
            }
        }

        if (casillaPenalizacion) {
            casilla += " #";
            if (posicion == jugador) {
                casilla += " @";
                filaPenalizacion=fila;
                jugadorPenalizacion = true;
            }
        } else if (posicion == jugador) {
            casilla += " @";
        }

        System.out.printf("|%-6s", casilla);

    }

    public boolean getJugadorPenalizacion(){
        return jugadorPenalizacion;
    }

    public int getFilaPenalizacion(){
        return filaPenalizacion;
    }





}
