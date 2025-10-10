package org.example;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PenalizacionFacil {
    int opcion= 1;

    public void imprimirPenalizacion(){
        System.out.println("NIVEL FACIL. Ley de cosenos.");
        switch (opcion){
            case 1:
                System.out.println("-------- OPCIÓN UNO --------\n");
                imprimirOpcionUno();
                opcion = 2;
                break;
            case 2:
                System.out.println("-------- OPCIÓN DOS --------\n");
                imprimirOpcionDos();
                opcion = 3;
                break;
            case 3:
                System.out.println("-------- OPCIÓN TRES --------\n");
                imprimirOpcionTres();
                opcion = 4;
                break;
            case 4:
                System.out.println("Se han completado las penalizaciones del nivel FACIL.\nReanudando juego...");
                break;
            default:System.out.println("Algo salio mal en la validacion de ejercicios nivel FACIL");

        }
    }

    public double obtenerLado(double lado_uno, double lado_dos, int angulo){
        double d=Math.toRadians(angulo);
        double lado_calculado = Math.sqrt(Math.pow(lado_uno, 2) + Math.pow(lado_dos, 2) - 2 * lado_uno * lado_dos * Math.cos(d));
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double resultado = Double.parseDouble(df.format(lado_calculado));
        return resultado;
    }

    public double obtenerAngulo(double lado_uno, double lado_dos, double lado_tres){
        double angulo = Math.acos((lado_uno*lado_uno + lado_dos*lado_dos - lado_tres*lado_tres) / (2*lado_uno*lado_dos));
        double angulo_grados = Math.toDegrees(angulo);
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double resultado = Double.parseDouble(df.format(angulo_grados));
        return resultado;
    }


    public void imprimirOpcionUno(){
        System.out.println("Valores dados:");
        System.out.println("Lado A: 15\nLado C: 20\nAngulo a: 25");
        System.out.println("Resolviendo operación...");
        double lado_B = obtenerLado(15,20,25);
        double angulo_b = obtenerAngulo(lado_B,20,15);
        double angulo_y= obtenerAngulo(15,lado_B,20);
        System.out.println(" El lado B es: "+lado_B+"\n El angulo B es: "+angulo_b+"\n El angulo y es: "+ angulo_y);
    }

    public void imprimirOpcionDos(){
        System.out.println("Valores dados:");
        System.out.println("Lado B: 10\nLado C: 25\nAngulo b: 30");
        System.out.println("Resolviendo operación...");
        double lado_A = obtenerLado(10,25,30);
        double angulo_y= obtenerAngulo(10,lado_A,25);
        double angulo_a= obtenerAngulo(lado_A,25,10);
        System.out.println(" El lado A es: "+lado_A+"\n El angulo a es: "+angulo_a+"\n El angulo y es: "+angulo_y);
    }

    public void imprimirOpcionTres(){
        System.out.println("Valores dados:");
        System.out.println("Lado A: 18\nLado B: 25\nAngulo Y: 30");
        System.out.println("Resolviendo operación...");
        double lado_C = obtenerLado(18,25,30);
        double angulo_a=obtenerAngulo(18,lado_C,25);
        double angulo_b=obtenerAngulo(lado_C,25,18);
        System.out.println(" El lado C es: "+lado_C+"\n El angulo a es: "+angulo_a+"\n El angulo b es: "+angulo_b);
    }

}
