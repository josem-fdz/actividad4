package mx.tecmilenio.computacion.java.actividad4;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    private static AddressBook addressBook = new AddressBook();

    private static void menu () {
        out.println("\n");
        out.println("*".repeat(60));
        out.println("| MENU PRINCIPAL");
        out.println("*".repeat(60));
        out.println("| 1. Lista los contactos");
        out.println("| 2. Crear Contacto");
        out.println("| 3. Borrar Contacto");
        out.println("| 4. Salir");
        out.println("*".repeat(60));
    }

    public static void main(String[] args) {
        menu();

        int seleccion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            seleccion = scan.nextInt();
            switch (seleccion) {
                case 1:
                    addressBook.list();
                    menu();
                    break;
                case  2:
                    addressBook.create();
                    menu();
                    break;
                case 3:
                    addressBook.delete();
                    menu();
                    break;
            }
        } while (seleccion != 4); // quitting the program
    }
}


