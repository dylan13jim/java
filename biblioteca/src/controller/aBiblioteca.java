package controller;

import model.biblioteca;
import view.vBiblioteca;

public class aBiblioteca {
    public static void main(String[] args) {
        biblioteca biblioteca = new biblioteca();
        vBiblioteca vista = new vBiblioteca();
        cBiblioteca controlador = new cBiblioteca(biblioteca, vista);
        
        String tituloLibro = vista.leerEntrada("Ingrese el título del libro: ");
        String autorLibro = vista.leerEntrada("Ingrese el autor del libro: ");
        String isbnLibro = vista.leerEntrada("Ingrese el ISBN del libro: ");
        controlador.agregarLibro(tituloLibro, autorLibro, isbnLibro);

        String nombreUsuario = vista.leerEntrada("Ingrese el nombre del usuario: ");
        int idUsuario = vista.leerEntero("Ingrese el ID del usuario: ");
        controlador.agregarUsuario(nombreUsuario, idUsuario);
        
        controlador.mostrarLibrosDisponibles();        
        controlador.prestarLibro(idUsuario, isbnLibro);        
        controlador.mostrarLibrosPrestados(idUsuario);
        
        vista.mostrarMensaje("Bienvenido a la biblioteca.");
    }
}