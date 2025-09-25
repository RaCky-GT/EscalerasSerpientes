package org.example;

public class Jugador {
    private int posicion = 0;

    public int getPosicion(){
        return posicion;
    }
    public void moverJugador(int pasos){
        posicion += pasos;
        System.out.println("pisición en moover jugadior:"+posicion);
        if(posicion > 64){
            posicion = 64;
        }
    }

}
