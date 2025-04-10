import prestable.*;
import persona.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        GestorPrestable gestorPrestable = new GestorPrestable();
        GestorPersona gestorPersona = new GestorPersona();

        int opcion;

        do {
            System.out.println("\n----- MENÚ -----");
            System.out.println("1. Agregar persona");
            System.out.println("2. Agregar prestable (libro o notebook)");
            System.out.println("3. Imprimir personas");
            System.out.println("4. Imprimir prestables");
            System.out.println("5. Modificar persona");
            System.out.println("6. Modificar prestable");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    Persona persona = Persona.cargarDesdeTeclado();
                    if (persona != null) {
                        gestorPersona.cargarPersona(persona);
                        System.out.println("Persona registrada.");
                    }
                    break;
                case 2:
                    Prestable prestable = Prestable.cargarDesdeTeclado();
                    if (prestable != null) {
                        gestorPrestable.cargarPrestable(prestable);
                        System.out.println("Prestable registrado.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Lista de Personas ---");
                    gestorPersona.imprimirPersonas();
                    break;
                case 4:
                    System.out.println("\n--- Lista de Prestables ---");
                    gestorPrestable.imprimirLista();
                    break;
                case 5:
                    System.out.print("Ingrese el nombre de la persona a modificar: ");
                    String nombrePersona = scanner.nextLine();
                    System.out.print("Ingrese el nuevo apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    gestorPersona.modificarPersona(nombrePersona, nuevoApellido);
                    break;
                case 6:
                    System.out.print("Ingrese nombre del libro o código del notebook a modificar: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("¿Está disponible? (true/false): ");
                    boolean nuevaDisponibilidad = scanner.nextBoolean();
                    gestorPrestable.modificarDisponibilidad(descripcion, nuevaDisponibilidad);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

 /*        // Crear libros y notebooks
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
    }*/
} 
