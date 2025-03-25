package controller;

import model.biblioteca;
import model.libro;
import model.usuario;
import view.vBiblioteca;

public class cBiblioteca {
    private biblioteca biblioteca;
    private vBiblioteca vista;

    public cBiblioteca(biblioteca biblioteca, vBiblioteca vista) {
        this.biblioteca = biblioteca;
        this.vista = vista;
    }

    public void agregarLibro(String titulo, String autor, String isbn) {
        libro libro = new libro(titulo, autor, isbn);
        biblioteca.agregarLibro(libro);
        vista.mostrarMensaje("Libro agregado exitosamente.");
    }

    public void agregarUsuario(String nombre, int id) {
        usuario usuario = new usuario(nombre, id);
        biblioteca.agregarUsuario(usuario);
        vista.mostrarMensaje("Usuario agregado exitosamente.");
    }

    public void prestarLibro(int usuarioId, String isbn) {
        usuario usuario = biblioteca.buscarUsuario(usuarioId);
        libro libro = biblioteca.buscarLibro(isbn);

        if (usuario == null) {
            vista.mostrarMensaje("Usuario no encontrado.");
            return;
        }

        if (libro == null) {
            vista.mostrarMensaje("Libro no encontrado.");
            return;
        }

        if (!libro.isDisponible()) {
            vista.mostrarMensaje("El libro no está disponible.");
            return;
        }

        libro.setDisponible(false);
        usuario.prestarLibro(libro);
        vista.mostrarMensaje("Libro prestado exitosamente.");
    }

    public void devolverLibro(int usuarioId, String isbn) {
        usuario usuario = biblioteca.buscarUsuario(usuarioId);
        libro libro = biblioteca.buscarLibro(isbn);

        if (usuario == null) {
            vista.mostrarMensaje("Usuario no encontrado.");
            return;
        }

        if (libro == null) {
            vista.mostrarMensaje("Libro no encontrado.");
            return;
        }

        if (libro.isDisponible()) {
            vista.mostrarMensaje("El libro ya está disponible.");
            return;
        }

        libro.setDisponible(true);
        usuario.devolverLibro(libro);
        vista.mostrarMensaje("Libro devuelto exitosamente.");
    }

    public void mostrarLibrosDisponibles(){
        vista.mostrarMensaje("Lista de libros disponibles: ");
        for (libro libro: biblioteca.getLibros().values()){
            if (libro.isDisponible()){
                vista.mostrarMensaje(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getIsbn());
            }
        }
    }
    public void mostrarLibrosPrestados(int idUsuario){
        usuario usuario = biblioteca.buscarUsuario(idUsuario);
        if (usuario == null){
            vista.mostrarMensaje("Usuario no encontrado");
        }
        else {
            vista.mostrarMensaje("Lista de libros prestados por " + usuario.getNombre() + ":");
            for (libro libro: usuario.getLibrosPrestados()){
                vista.mostrarMensaje(libro.getTitulo() + " - " + libro.getIsbn());
            }
        }
    }
}