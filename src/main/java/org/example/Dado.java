package org.example;

import java.util.Random;

public class Dado {
    private int valor;

    public void lanzarDado(){
        int min=2;
        int max=6;
        Random random = new Random();
        valor = random.nextInt(min,max);
        System.out.println("valor dado: "+valor);
    }

    public int getValor() {

        return valor;
    }

}
