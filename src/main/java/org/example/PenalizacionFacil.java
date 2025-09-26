package org.example;

public class PenalizacionFacil {
    int opcion= 1;

    public void imprimirPenalizacion(){
        switch (opcion){
            case 1:
                    imprimirOpcionUno();
                break;
            case 2:
                    imprimirOpcionDos();
                break;
            case 3:
                imprimirOpcionTres();
                break;
            case 4:
                System.out.println("Se han completado las penalizaciones del nivel FACIL.\nReanudando juego...");
                break;
            default:System.out.println("Algo salio mal en la validacion de ejercicios nivel FACIL");

        }
    }

    public void imprimirOpcionUno(){
        System.out.println("Se imprime ejercicio UNO nivel FACIL");
        opcion = 2;
    }

    public void imprimirOpcionDos(){
        System.out.println("Se imprime ejercicio DOS nivel FACIL");
        opcion = 3;
    }

    public void imprimirOpcionTres(){
        System.out.println("Se imprime ejercicio TRES nivel FACIL");
        opcion = 4;
    }

}
