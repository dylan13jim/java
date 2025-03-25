package model;

import java.util.HashMap;
import java.util.Map;

public class biblioteca {
    private Map<String, libro> libros;
    private Map<Integer, usuario> usuarios;

    public biblioteca() {
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void agregarLibro(libro libro) {
        this.libros.put(libro.getIsbn(), libro);
    }

    public void agregarUsuario(usuario usuario) {
        this.usuarios.put(usuario.getId(), usuario);
    }

    public libro buscarLibro(String isbn) {
        return this.libros.get(isbn);
    }

    public usuario buscarUsuario(int id) {
        return this.usuarios.get(id);
    }
    public Map<String, libro> getLibros(){
        return this.libros;
    }
}