package persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPersona {
    private List<Persona> personas = new ArrayList<>();

    public void cargarPersona(Persona p) {
        personas.add(p);
    }

    public void imprimirPersonas() {
        for (Persona p : personas) {
            System.out.println(p.getInfo());
        }
    }


/*    public void modificarPersona(String nombre,String nuevoNombre, String nuevoApellido) {
        for (Persona p : personas) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                p.nombre = nuevoNombre;
                p.apellido = nuevoApellido;
                System.out.println("Nombre y Apellido modificado con éxito.");
                return;
            }
        }
        System.out.println("Persona no encontrada.");
    } */

    public void modificarPersonaDetalles(String nombre) {
    for (Persona p : personas) {
        if (p.nombre.equalsIgnoreCase(nombre)) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Persona encontrada: " + p.getInfo());

            System.out.println("¿Qué campo deseas modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            if (p instanceof Estudiante) {
                System.out.println("3. DNI");
            } else if (p instanceof Docente) {
                System.out.println("3. Título");
            }
            System.out.print("Ingrese la opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    p.nombre = nuevoNombre;
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    p.apellido = nuevoApellido;
                    break;
                case 3:
                    if (p instanceof Estudiante) {
                        System.out.print("Ingrese el nuevo DNI: ");
                        String nuevoDNI = scanner.nextLine();
                        ((Estudiante) p).setDni(nuevoDNI);
                    } else if (p instanceof Docente) {
                        System.out.print("Ingrese el nuevo título: ");
                        String nuevoTitulo = scanner.nextLine();
                        ((Docente) p).setTitulo(nuevoTitulo);
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
            System.out.println("Persona modificada con éxito.");
            return;
        }
    }
    System.out.println("Persona no encontrada.");
}

    
    
}
