package prestable;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Prestable {
    protected LocalDate fechaEntrega;
    protected LocalDate fechaRetiro;
    protected boolean disponible;

    public Prestable(LocalDate entrega, LocalDate retiro, boolean disponible) {
        this.fechaEntrega = entrega;
        this.fechaRetiro = retiro;
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract String getDescripcion();

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechas(LocalDate entrega, LocalDate retiro) {
        this.fechaEntrega = entrega;
        this.fechaRetiro = retiro;
    }

    // Método estático para cargar por teclado
    public static Prestable cargarDesdeTeclado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué desea ingresar?");
        System.out.println("1. Libro");
        System.out.println("2. Notebook");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Fecha de entrega (AAAA-MM-DD): ");
        String fechaEntregaStr = scanner.nextLine();
        System.out.print("Fecha de retiro (AAAA-MM-DD): ");
        String fechaRetiroStr = scanner.nextLine();

        LocalDate fechaEntrega = LocalDate.parse(fechaEntregaStr);
        LocalDate fechaRetiro = LocalDate.parse(fechaRetiroStr);

        boolean disponible = true; // Por defecto disponible

        if (opcion == 1) {
            System.out.print("Nombre del libro: ");
            String nombre = scanner.nextLine();
            return new Libro(nombre, fechaEntrega, fechaRetiro, disponible);
        } else if (opcion == 2) {
            System.out.print("Código del notebook: ");
            String codigo = scanner.nextLine();
            return new Notebook(codigo, fechaEntrega, fechaRetiro, disponible);
        } else {
            System.out.println("Opción no válida.");
            return null;
        }
    }

}
