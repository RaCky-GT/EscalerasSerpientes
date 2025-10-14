package org.example;

public class PenalizacionDificil {

    private Reportes reportes;
    private String nivel_penalizacion = "NIVEL DIFICIL. Division de matrices";
    private String opcion_penalizacion;
    private String penalizacion_texto;
    int opcion= 1;

    public PenalizacionDificil(Reportes reportes){
        this.reportes = reportes;
    }

    public void imprimirPenalizacion(){
        System.out.println("\n ¡Has caído en una penalización!\n NIVEL DIFICIL. Division de matrices");
        reportes.agregarP("<br>¡Has caído en una penalización!<br>NIVEL DIFICIL. Division de matrices.");
        switch (opcion){
            case 1:
                System.out.println("---------- OPCIÓN UNO -------------\n");
                reportes.agregarP("---------- OPCIÓN UNO -------------");
                opcion_penalizacion="---------- OPCIÓN UNO -------------";
                imprimirOpcionUno();
                reportes.penalizacionReporte(nivel_penalizacion,opcion_penalizacion,penalizacion_texto);
                break;
            case 2:
                System.out.println("---------- OPCIÓN DOS -------------\n");
                reportes.agregarP("---------- OPCIÓN DOS -------------");
                opcion_penalizacion="---------- OPCIÓN DOS -------------";
                imprimirOpcionDos();
                reportes.penalizacionReporte(nivel_penalizacion,opcion_penalizacion,penalizacion_texto);
                break;
            case 3:
                System.out.println("---------- OPCIÓN TRES ------------\n");
                reportes.agregarP("---------- OPCIÓN TRES ------------");
                opcion_penalizacion="---------- OPCIÓN TRES ------------";
                imprimirOpcionTres();
                reportes.penalizacionReporte(nivel_penalizacion,opcion_penalizacion,penalizacion_texto);
                break;
            case 4:
                System.out.println("Se han completado las penalizaciones del nivel DIFICIL.\nReanudando juego...");
                reportes.agregarP("Se han completado las penalizaciones del nivel DIFICIL.<br>Reanudando juego...");
                break;
            default:
                System.out.println("Algo salio mal en la validacion de ejercicios nivel DIFICIL");
                reportes.agregarP("Algo salio mal en la validacion de ejercicios nivel DIFICIL");
                penalizacion_texto+="Algo salio mal en la validacion de ejercicios nivel DIFICIL";

        }
    }

    public void imprimirOpcionUno(){
        penalizacion_texto="";
        double[][] A = {
                {5, 10, 1, 3},
                {9, 14, 2, 6},
                {7, 8, 15, 3},
                {6, 8, 9, 2}
        };

        double[][] B = {
                {5, 13, 9, 4},
                {1, 9, 6, 3},
                {8, 11, 69, 33},
                {25, 6, 7, 4}
        };

        System.out.println("    Matriz A");
        reportes.agregarP("    Matriz A");
        penalizacion_texto+="<h4>    Matriz A</h4>";
        imprimirMatriz(A);
        System.out.println("    Matriz B");
        reportes.agregarP("    Matriz B");
        penalizacion_texto+="<h4>    Matriz B</h4>";
        imprimirMatriz(B);
        System.out.println("  Matriz A / B");
        reportes.agregarP("  Matriz A / B");
        penalizacion_texto+="<h4>  Matriz A / B</h4>";
        dividirMatriz(A,B);

        opcion = 2;
    }

    public void imprimirOpcionDos(){
        penalizacion_texto="";
        double[][] A = {
                {1, 12, 9, 8},
                {7, 6, 3, 2},
                {0, 5, 6, 14},
                {6, 9, 6, 10}
        };

        double[][] B = {
                {8, 19, 20, 4},
                {12, 33, 6, 8},
                {4, 5, 9, 7},
                {8, 22, 14, 6}
        };

        System.out.println("    Matriz A");
        reportes.agregarP("    Matriz A");
        penalizacion_texto+="<h4>    Matriz A</h4>";
        imprimirMatriz(A);
        System.out.println("    Matriz B");
        reportes.agregarP("    Matriz B");
        penalizacion_texto+="<h4>    Matriz B</h4>";
        imprimirMatriz(B);
        System.out.println("  Matriz A / B");
        reportes.agregarP("  Matriz A / B");
        penalizacion_texto+="<h4>  Matriz A / B</h4>";
        dividirMatriz(A,B);

        opcion = 3;
    }

    public void imprimirOpcionTres(){
        penalizacion_texto="";
        double[][] A = {
                {5, 9, 14, 5},
                {6, 0, 5, 3},
                {1, 14, 68, 8},
                {7, 5, 3, 9}
        };

        double[][] B = {
                {0, 9, 7, 19},
                {2, 30, 5, 48},
                {1, 31, 2, 5},
                {15, 8, 4, 3}
        };

        System.out.println("    Matriz A");
        reportes.agregarP("    Matriz A");
        penalizacion_texto+="<h4>    Matriz A</h4>";
        imprimirMatriz(A);
        System.out.println("    Matriz B");
        reportes.agregarP("    Matriz B");
        penalizacion_texto+="<h4>    Matriz B</h4>";
        imprimirMatriz(B);
        System.out.println("  Matriz A / B");
        reportes.agregarP("  Matriz A / B");
        penalizacion_texto+="<h4>  Matriz A / B</h4>";
        dividirMatriz(A,B);

        opcion = 4;
    }

    public void dividirMatriz(double [][]A, double [][] B){
        boolean validador = validarMatriz(A,B);

        if (validador==true){
            double determinante = calcularDeterminante(B);
           // System.out.println("Determinante de la matriz: "+determinante);
            if(determinante!=0){
                //System.out.println("Se puede dividir");
                double [][] inversaB =inversaMatriz(B);
                double [][] A_inversaB= multiplicarMatrices(A, inversaB);
                imprimirMatriz(A_inversaB);
            }else {
                System.out.println("La determinante de la matriz B es 0, no se puede realizar operación, regresando al juego... "+determinante);
                reportes.agregarP("La determinante de la matriz B es 0, no se puede realizar operación, regresando al juego... "+String.valueOf(determinante));
                penalizacion_texto+="<p>La determinante de la matriz B es 0, no se puede realizar operación, regresando al juego... </p>";
            }
        } else {
            System.out.println("No se puede ejecutar la operación, regresando al juego...");
            reportes.agregarP("No se puede ejecutar la operación, regresando al juego...");
            penalizacion_texto+="<p>No se puede ejecutar la operación, regresando al juego...</P>";
        }



    }

    public boolean validarMatriz(double[][] A, double [][] B) {
        int filas_A = A.length;
        int columnas_A = A[0].length;
        int filas_B = B.length;
        int columnas_B = B[0].length;

        if (filas_A != filas_B || columnas_A != columnas_B) {
            System.out.println("Las matrices no cuentan con la misma longitud.");
            reportes.agregarP("Las matrices no cuentan con la misma longitud.");
            penalizacion_texto+="<p>Las matrices no cuentan con la misma longitud.</p>";
            return false;
        }


        if (filas_A != columnas_A) {
            System.out.println("La matriz A no es cuadrada.");
            reportes.agregarP("La matriz A no es cuadrada.");
            penalizacion_texto+="<p>La matriz A no es cuadrada.</p>";
            return false;
        }

        for (int i = 0; i < filas_A; i++) {
            for (int j = 0; j < columnas_A; j++) {
                if (A[i][j] == 0) {
                    System.out.println("La matriz A cuenta con un valor 0.");
                    reportes.agregarP("La matriz A cuenta con un valor 0.");
                    penalizacion_texto+="<p>La matriz A cuenta con un valor 0.</p>";
                    return false;
                }
            }
        }

        if (filas_B != columnas_B) {
            System.out.println("La matriz B no es cuadrada.");
            reportes.agregarP("La matriz B no es cuadrada.");
            penalizacion_texto+="La matriz B no es cuadrada.";
            return false;
        }

        for (int i = 0; i < filas_B; i++) {
            for (int j = 0; j < columnas_B; j++) {
                if (B[i][j] == 0) {
                    System.out.println("La matriz B cuenta con un valor 0.");
                    reportes.agregarP("La matriz B cuenta con un valor 0.");
                    penalizacion_texto+="La matriz B cuenta con un valor 0.";
                    return false;
                }
            }
        }

        return true;
    }


    public static double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;

        // Caso base: matriz 1x1
        if (n == 1) {
            return matriz[0][0];
        }

        // Caso base: matriz 2x2
        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        double det = 0;
        for (int j = 0; j < n; j++) {
            det += Math.pow(-1, j) * matriz[0][j] * calcularDeterminante(obtenerSubmatriz(matriz, 0, j));
        }
        return det;
    }

    public static double[][] obtenerSubmatriz(double[][] matriz, int filaEliminar, int columnaEliminar) {
        int n = matriz.length;
        double[][] submatriz = new double[n - 1][n - 1];
        int filaDestino = 0;

        for (int i = 0; i < n; i++) {
            if (i == filaEliminar) continue;
            int columnaDestino = 0;
            for (int j = 0; j < n; j++) {
                if (j == columnaEliminar) continue;
                submatriz[filaDestino][columnaDestino] = matriz[i][j];
                columnaDestino++;
            }
            filaDestino++;
        }
        return submatriz;
    }

    public double[][] inversaMatriz(double[][] matriz) {
        int n = matriz.length;
        double[][] a = new double[n][n];
        double[][] inversa = new double[n][n];

        // Copiar matriz original a 'a' y crear identidad en 'inversa'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = matriz[i][j];
                inversa[i][j] = (i == j) ? 1 : 0;
            }
        }

        // Aplicar Gauss-Jordan
        for (int i = 0; i < n; i++) {
            // Verificar pivote distinto de 0
            double pivote = a[i][i];
            if (pivote == 0) {
                reportes.agregarP("La matriz no es invertible (pivote 0 encontrado).");
                penalizacion_texto+="<p>La matriz no es invertible (pivote 0 encontrado).</p>";
                throw new IllegalArgumentException("La matriz no es invertible (pivote 0 encontrado).");
            }

            // Normalizar la fila del pivote
            for (int j = 0; j < n; j++) {
                a[i][j] /= pivote;
                inversa[i][j] /= pivote;
            }

            // Hacer ceros en las demás filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = a[k][i];
                    for (int j = 0; j < n; j++) {
                        a[k][j] -= factor * a[i][j];
                        inversa[k][j] -= factor * inversa[i][j];
                    }
                }
            }
        }

        return inversa;
    }

    public double[][] multiplicarMatrices(double[][] A, double[][] B_inversa) {
        int n = A.length;
        double[][] resultado = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += A[i][k] * B_inversa[k][j];
                }
            }
        }

        return resultado;
    }



    public void imprimirMatriz(double [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%-10.3f",matriz[i][j]);
                reportes.agregarA(String.valueOf(matriz[i][j])+"  |  ");
                penalizacion_texto+="<a>"+matriz[i][j]+"  |  "+"</a>";
            }
            System.out.println();
            reportes.agregarP("");
            penalizacion_texto+="<br>";
        }
        System.out.println();
        reportes.agregarP("");
        penalizacion_texto+="<br>";
    }


}
