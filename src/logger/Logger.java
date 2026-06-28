package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Logger {

    private static ArrayList<String> mensajes = new ArrayList<>();
    private static final String CARPETA_LOG = "src/logBatallas";

    public static void agregarMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    public static void mostrarMensajes() {
        for (String mensaje : mensajes) {
            System.out.println(mensaje);
        }
    }

    public static void guardarEnArchivo(String nombreArchivo) {
        File carpeta = new File(CARPETA_LOG);
        if (!carpeta.exists()) {
            carpeta.mkdirs(); 
        }
        
        File archivo = new File(carpeta, nombreArchivo);
        
        try (FileWriter writer = new FileWriter(archivo)) {
            for (String mensaje : mensajes) {
                writer.write(mensaje + System.lineSeparator()); 
            }
            System.out.println("Log guardado en " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
