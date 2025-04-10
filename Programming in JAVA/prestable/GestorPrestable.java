package prestable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPrestable {
    private List<Prestable> items = new ArrayList<>();

    public void cargarPrestable(Prestable p) {
        items.add(p);
    }

    public void imprimirLista() {
        for (Prestable p : items) {
            System.out.println(p.getDescripcion() + " | Disponible: " + p.isDisponible());
        }
    }

/*     public void modificarDisponibilidad(String descripcion, boolean disponible) {
        for (Prestable p : items) {
            if (p.getDescripcion().contains(descripcion)) {
                p.setDisponible(disponible);
                break;
            }
        }
    }*/

    public void modificarDisponibilidad(String descripcion, boolean disponible) {
        for (Prestable p : items) {
            if (p.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                p.setDisponible(disponible);
                System.out.println("Disponibilidad modificada con éxito.");
                return;
            }
        }
        System.out.println("Elemento no encontrado.");
    }

    //modificar nombre del libro o codigo de notebook
    public void modificarNombreOCodigo(String descripcion, String nuevoValor) {
        for (Prestable p : items) {
            if (p instanceof Libro && p.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                Libro libro = (Libro) p;
                libro.nombre = nuevoValor;
                System.out.println("Nombre del libro modificado con éxito.");
                return;
            } else if (p instanceof Notebook && p.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                Notebook notebook = (Notebook) p;
                notebook.codigo = nuevoValor;
                System.out.println("Código del notebook modificado con éxito.");
                return;
            }
        }
        System.out.println("Elemento no encontrado.");
    }
    
    public void modificarPrestableDetalles(String descripcion) {
    for (Prestable p : items) {
        if (p.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Prestable encontrado: " + p.getDescripcion());

            System.out.println("¿Qué campo deseas modificar?");
            System.out.println("1. Nombre del libro (si es libro) o código (si es notebook)");
            System.out.println("2. Fecha de entrega");
            System.out.println("3. Fecha de retiro");
            System.out.println("4. Disponibilidad");
            System.out.print("Ingrese la opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre/código: ");
                    String nuevoValor = scanner.nextLine();
                    modificarNombreOCodigo(descripcion, nuevoValor);
                    break;
                case 2:
                    System.out.print("Ingrese la nueva fecha de entrega (AAAA-MM-DD): ");
                    String nuevaFechaEntrega = scanner.nextLine();
                    p.setFechas(LocalDate.parse(nuevaFechaEntrega), p.getFechaRetiro());
                    break;
                case 3:
                    System.out.print("Ingrese la nueva fecha de retiro (AAAA-MM-DD): ");
                    String nuevaFechaRetiro = scanner.nextLine();
                    p.setFechas(p.getFechaEntrega(), LocalDate.parse(nuevaFechaRetiro));
                    break;
                case 4:
                    System.out.print("¿Está disponible? (true/false): ");
                    boolean nuevaDisponibilidad = scanner.nextBoolean();
                    p.setDisponible(nuevaDisponibilidad);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
            System.out.println("Prestable modificado con éxito.");
            return;
        }
    }
    System.out.println("Prestable no encontrado.");
}


    public void verDisponibles() {
        for (Prestable p : items) {
            if (p.isDisponible()) {
                System.out.println(p.getDescripcion());
            }
        }
    }

    
}
