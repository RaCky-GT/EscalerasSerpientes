package org.example;

import java.util.Random;

public class PenalizacionControlador {
    private PenalizacionFacil penalizacionFacil;
    private PenalizacionIntermedio penalizacionIntermedio;
    private PenalizacionDificil penalizacionDificil;

    private Reportes reportes;

    int [] dist_penalizaciones = new int[32];
    int min=0;
    int max=8;
    int cont=0;

    public PenalizacionControlador(Reportes reportes){
        this.reportes = reportes;

        penalizacionFacil = new PenalizacionFacil(reportes);
        penalizacionIntermedio = new PenalizacionIntermedio(reportes);
        penalizacionDificil = new PenalizacionDificil(reportes);

    }

    public void distribucionPenalizaciones(){
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

    public void tipoPenalizacion(int fila){
        switch (fila){
            case 0,1:
                penalizacionFacil.imprimirPenalizacion();

                break;
            case 2,3,4:
                penalizacionIntermedio.imprimirPenalizacion();
                break;
            case 5,6,7:
                penalizacionDificil.imprimirPenalizacion();
                break;
        }

    }

}
