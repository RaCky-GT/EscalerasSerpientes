package org.example;

import java.util.Random;

public class Dado {
    private Reportes reportes;
    private int valor;

    public Dado(Reportes reportes){
        this.reportes = reportes;
    }

    public void lanzarDado(){
        int min=2;
        int max=6;
        Random random = new Random();
        valor = random.nextInt(min,max);
        System.out.println("valor dado: "+valor);
        reportes.agregarP("Valor dado: "+valor);
    }

    public int getValor() {

        return valor;
    }

}
