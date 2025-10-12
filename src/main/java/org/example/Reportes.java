package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Reportes {
    private String reporteOperaciones;
    private String bitacora;

    public Reportes() {

        reporteOperaciones = """
        <html>
        <head><title>Reporte de Operaciones</title></head>
        <body>
        <h1>REPORTE DE OPERACIONES REALIZADAS</h1>
        <table border='1'>
        <tr><th>Operación</th><th>Descripción</th><th>Resultado</th></tr>
        """;

        bitacora = """
        <html>
        <head><title>Bitacora</title></head>
        <body>
        <h2>BITACORA JUEGO ESCALERAS Y SERPIENTES</h2>
        """;
    }

    public void menuPrincipal(String texto){
        bitacora += """
                <div>
                    <p>======== MENU ========</p>
                    <ol>
                        <li>Iniciar Juego</li>
                        <li>Retomar Juego</li>
                        <li>Generar Reportes</li>
                        <li>Salir</li>
                    </ol>
                """+"<p>Opcion seleccionada por el usuario: "+texto+ """
                <p>
                <div>
                """;
    }

    public void subMenu(String texto){
        bitacora += """
                <div>
                    <p>============= ¡A JUGAR! =============</p>
                    <ol>
                        <li>Sí, lanzar dado.</li>
                        <li>No, regresar a menu principal.</li>
                    </ol>
                """+"<p>Opcion seleccionada por el usuario: "+texto+ """
                <p>
                <div>
                """;
    }


    public void agregarP(String texto){
        bitacora +="<p>" + texto + "<p>";
    }

    public void agregarA(String texto){
        bitacora +="<a>" + texto + "<a>";
    }


    public void generarArchivos() {

        reporteOperaciones += """
        </table>
        </body>
        </html>
        """;

        bitacora += """
        </body>
        </html>
        """;

        guardarArchivo("reporte_operaciones.html", reporteOperaciones);
        guardarArchivo("bitacora.html", bitacora);
    }

    private void guardarArchivo(String nombre, String contenido) {
        try (FileWriter writer = new FileWriter(nombre)) {
            writer.write(contenido);
            System.out.println("Archivo generado: " + nombre);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
