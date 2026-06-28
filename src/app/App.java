package app;

import logger.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String[] args) {
        Logger.agregarMensaje("-----Carga de batallones-----");

        Juego juego = new Juego();
        juego.cargarDatos();

        Logger.agregarMensaje("\n\n-----Iniciando la batalla-----");
        juego.jugar();

        Logger.agregarMensaje("-----Juego Terminado-----");

        Logger.mostrarMensajes();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm");
        String fechaActual = LocalDateTime.now().format(formatter);

        Logger.guardarEnArchivo("logBatalla_" + fechaActual + ".txt");
    }

}
