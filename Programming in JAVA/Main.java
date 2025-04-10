import prestable.*;
import persona.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GestorPrestable gestorPrestable = new GestorPrestable();
        GestorPersona gestorPersona = new GestorPersona();

        // Crear libros y notebooks
        Libro libro1 = new Libro("Java Básico", LocalDate.now(), LocalDate.now().plusDays(7), true);
        Notebook notebook1 = new Notebook("NB001", LocalDate.now(), LocalDate.now().plusDays(5), true);

        gestorPrestable.cargarPrestable(libro1);
        gestorPrestable.cargarPrestable(notebook1);

        Prestable nuevoItem = Prestable.cargarDesdeTeclado();

        if (nuevoItem != null) {
            gestorPrestable.cargarPrestable(nuevoItem);
            System.out.println("\nItem registrado:");
            System.out.println(nuevoItem.getDescripcion() + " | Disponible: " + nuevoItem.isDisponible());
        }


        // Crear personas
        Estudiante estudiante1 = new Estudiante("Ana", "Gómez", "12345678");
        Docente docente1 = new Docente("Carlos", "Pérez", "Magíster en Educación");

        gestorPersona.cargarPersona(estudiante1);
        gestorPersona.cargarPersona(docente1);

        Persona nuevaPersona = Persona.cargarDesdeTeclado();

        if (nuevaPersona != null) {
            gestorPersona.cargarPersona(nuevaPersona);
            System.out.println("\nPersona registrada:");
            System.out.println(nuevaPersona.getInfo());
        }


        // Mostrar información
        System.out.println("\n--- Personas Registradas ---");
        gestorPersona.imprimirPersonas();

        System.out.println("\n--- Lista de Prestables ---");
        gestorPrestable.imprimirLista();

        System.out.println("\n--- Prestables Disponibles ---");
        gestorPrestable.verDisponibles();

        // Modificar disponibilidad de un libro
        gestorPrestable.modificarDisponibilidad("Java Básico", false);

        System.out.println("\n--- Disponibilidad Actualizada ---");
        gestorPrestable.imprimirLista();
    }
}
