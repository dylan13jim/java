package view;

import java.util.Scanner;

public class vBiblioteca {
    private Scanner scanner;

    public vBiblioteca() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerEntrada(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextInt();
    }
}