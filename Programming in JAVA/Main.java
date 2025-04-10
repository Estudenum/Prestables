import prestable.*;
import persona.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GestorPersona gestorPersona = new GestorPersona();
        GestorPrestable gestorPrestable = new GestorPrestable();

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
                    gestorPersona.modificarPersonaDetalles(nombrePersona);
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del libro o código del notebook a modificar: ");
                    String descripcion = scanner.nextLine();
                    gestorPrestable.modificarPrestableDetalles(descripcion);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
} 
