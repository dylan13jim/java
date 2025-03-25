package model;

import java.util.ArrayList;
import java.util.List;

public class usuario {
    private String nombre;
    private int id;
    private List<libro> librosPrestados;

    public usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public List<libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void prestarLibro(libro libro) {
        this.librosPrestados.add(libro);
    }

    public void devolverLibro(libro libro) {
        this.librosPrestados.remove(libro);
    }
}