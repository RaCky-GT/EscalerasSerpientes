package org.example;

import java.util.Random;

public class Penalizaciones {
    int [] dist_penalizaciones = new int[32];
    int min=0;
    int max=8;
    int cont=0;

    public void distribucinPenalizaciones(){
        Random  random = new Random();

        for(int i=0; i<=7;i++){
            int cantidadFila = random.nextInt(2,4);
            for(int j=0; j<=cantidadFila; j++){
                int casilla;


                while (true){
                    casilla = random.nextInt(min,max);
                    boolean repetido = false;

                    for (int k = 0; k < cont; k++) {
                        if (dist_penalizaciones[k] == casilla) {
                            repetido = true;
                            break;
                        }
                    }
                    if (!repetido) break;
                }
                dist_penalizaciones[cont] = casilla;
                cont++;
            }
            min += 8;
            max += 8;
        }
    }

    public int[] getPenalizaciones(){
        int[] resultado = new int[cont];
        for (int i = 0; i < cont; i++) {
            resultado[i] = dist_penalizaciones[i];
        }
        return resultado;
    }

}
