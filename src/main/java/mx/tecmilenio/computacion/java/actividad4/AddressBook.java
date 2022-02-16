package mx.tecmilenio.computacion.java.actividad4;

import org.apache.commons.csv.CSVFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class AddressBook {
    private Map<String, String> contactos;

    public AddressBook() {
        load();
    }

    private void load() {
        try {
            InputStream is = getClass().getResourceAsStream("/db/db.csv");
            Reader reader = new InputStreamReader(is);

            contactos = CSVFormat.DEFAULT.builder()
                    .build()
                    .parse(reader)
                    .stream()
                    .collect(Collectors.toMap(
                            e -> e.get(0), e -> e.get(1)
                    ));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void list() {
        out.println("-".repeat(60));
        contactos.keySet().forEach(it ->
                out.printf("%s:%s%n", it, contactos.get(it)));
        out.println("-".repeat(60));
    }

    public void create() {
        out.println("-".repeat(60));
        Scanner scan = new Scanner(System.in);
        out.print("Telefono: ");
        String telefono = scan.next();
        out.print("Nombre: ");
        String nombre = scan.next();

        contactos.put(telefono, nombre);
        out.println("-".repeat(60));
        save();
    }

    private void save() {
    }

    public void delete() {
        out.println("-".repeat(60));
        Scanner scan = new Scanner(System.in);
        out.print("Telefono: ");
        String telefono = scan.next();

        contactos.remove(telefono);
        out.println("-".repeat(60));
        save();
    }


}
