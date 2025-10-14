package org.example;

public class PenalizacionIntermedio {
    private Reportes reportes;
    private String nivel_penalizacion = "NIVEL INTERMEDIO. Suma de matrices.";
    private String opcion_penalizacion;
    private String penalizacion_texto;
    int opcion= 1;

    public PenalizacionIntermedio(Reportes reportes){
        this.reportes = reportes;
    }

    public void imprimirPenalizacion(){
        System.out.println("\n ¡Has caído en una penalización!\n NIVEL INTERMEDIO. Suma de matrices.");
        reportes.agregarP("<br>¡Has caído en una penalización!<br>NIVEL INTERMEDIO. Suma de matrices.");
        switch (opcion){
            case 1:
                System.out.println("---------- OPCIÓN UNO -------------\n");
                reportes.agregarP("---------- OPCIÓN UNO -------------");
                opcion_penalizacion = "-------- OPCIÓN UNO --------";
                imprimirOpcionUno();
                reportes.penalizacionReporte(nivel_penalizacion,opcion_penalizacion,penalizacion_texto);
                break;
            case 2:
                System.out.println("---------- OPCIÓN DOS -------------\n");
                reportes.agregarP("---------- OPCIÓN DOS -------------");
                opcion_penalizacion = "---------- OPCIÓN DOS -------------";
                imprimirOpcionDos();
                reportes.penalizacionReporte(nivel_penalizacion,opcion_penalizacion,penalizacion_texto);
                break;
            case 3:
                System.out.println("---------- OPCIÓN TRES ------------\n");
                reportes.agregarP("---------- OPCIÓN TRES -------------");
                opcion_penalizacion = "---------- OPCIÓN TRES -------------";
                imprimirOpcionTres();
                reportes.penalizacionReporte(nivel_penalizacion,opcion_penalizacion,penalizacion_texto);
                break;
            case 4:
                System.out.println("Se han completado las penalizaciones del nivel INTERMEDIO.\nReanudando juego...");
                reportes.agregarP("Se han completado las penalizaciones del nivel INTERMEDIO.<br>Reanudando juego...");
                break;
            default:
                System.out.println("Algo salio mal en la validacion de ejercicios nivel INTERMEDIO");
                reportes.agregarP("Algo salio mal en la validacion de ejercicios nivel INTERMEDIO");
                penalizacion_texto+="Algo salio mal en la validacion de ejercicios nivel INTERMEDIO";

        }
    }

    public void imprimirMatriz(int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%-5s",matriz[i][j]);
                reportes.agregarA(matriz[i][j]+"  |  ");
                penalizacion_texto+="<a>"+matriz[i][j]+"  |  "+"</a>";
            }
            System.out.println();
            reportes.agregarA("<br>");
            penalizacion_texto+="<br>";
        }
        System.out.println();
        reportes.agregarA("<br>");
        penalizacion_texto+="<br>";
    }

    public void sumaMatrices(int [][] A, int [][]  B){
        int [][] suma = new int[5][5];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                suma[i][j] = A[i][j] + B[i][j];
            }
        }
        imprimirMatriz(suma);
    }

    public void imprimirOpcionUno(){
        penalizacion_texto="";
        int[][] A = {
                {7, 48, 5, 0, 1},
                {57, 8, 4, 6, 14},
                {0, 1, 78, 15, 3},
                {14, 6, 19, 54, 0},
                {32, 20, 26, 47, 12}
        };

        int[][] B = {
                {9, 5, 2, 1, 8},
                {4, 2, 3, 47, 8},
                {48, 55, 32, 19, 6},
                {7, 56, 32, 14, 6},
                {32, 87, 0, 1, 7}
        };

        System.out.println("    Matriz A");
        reportes.agregarP("    Matriz A");
        penalizacion_texto+="<h4>    Matriz A</h4>";
        imprimirMatriz(A);
        System.out.println("    Matriz B");
        reportes.agregarP("    Matriz B");
        penalizacion_texto+="<h4>    Matriz B</h4>";
        imprimirMatriz(B);
        System.out.println("  Matriz A + B");
        reportes.agregarP("  Matriz A + B");
        penalizacion_texto+="<h4>  Matriz A + B</h4>";
        sumaMatrices(A,B);

        opcion = 2;
    }

    public void imprimirOpcionDos(){
        penalizacion_texto="";
        int[][] A = {
                {4, 9, 7, 45, 18},
                {7, 51, 26, 8, 38},
                {48, 26, 37, 21, 19},
                {1, 0, 6, 8, 1},
                {2, 19, 55, 25, 15}
        };

        int[][] B = {
                {0, 2, 15, 1, 66},
                {21, 48, 62, 7, 33},
                {4, 88, 0, 68, 4},
                {25, 18, 24, 7, 55},
                {24, 15, 36, 5, 98}
        };

        System.out.println("    Matriz A");
        reportes.agregarP("    Matriz A");
        penalizacion_texto+="<h4>    Matriz A</h4>";
        imprimirMatriz(A);
        System.out.println("    Matriz B");
        reportes.agregarP("    Matriz B");
        penalizacion_texto+="<h4>    Matriz B</h4>";
        imprimirMatriz(B);
        System.out.println("  Matriz A + B");
        reportes.agregarP("  Matriz A + B");
        penalizacion_texto+="<h4>  Matriz A + B</h4>";
        sumaMatrices(A,B);

        opcion = 3;
    }

    public void imprimirOpcionTres(){
        penalizacion_texto="";
        int[][] A = {
                {0, 1, 15, 5, 36},
                {1, 78, 65, 32, 4},
                {48, 66, 39, 0, 55},
                {14, 98, 63, 20, 15},
                {11, 39, 84, 7, 1}
        };

        int[][] B = {
                {78, 25, 66, 48, 98},
                {0, 45, 2, 3, 1},
                {2, 9, 14, 10, 20},
                {35, 87, 65, 2, 32},
                {25, 8, 4, 9, 39}
        };

        System.out.println("    Matriz A");
        reportes.agregarP("    Matriz A");
        penalizacion_texto+="<h4>    Matriz A</h4>";
        imprimirMatriz(A);
        System.out.println("    Matriz B");
        reportes.agregarP("    Matriz B");
        penalizacion_texto+="<h4>    Matriz B</h4>";
        imprimirMatriz(B);
        System.out.println("  Matriz A + B");
        reportes.agregarP("  Matriz A + B");
        penalizacion_texto+="<h4>  Matriz A + B</h4>";
        sumaMatrices(A,B);

        opcion = 4;
    }

}
