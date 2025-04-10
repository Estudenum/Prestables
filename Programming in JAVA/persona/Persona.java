package persona;

import java.util.Scanner;

public abstract class Persona {
    protected String nombre;
    protected String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public abstract String getInfo();

    // Método estático para crear una Persona desde teclado
    public static Persona cargarDesdeTeclado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese tipo de persona:");
        System.out.println("1. Estudiante");
        System.out.println("2. Docente");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        if (tipo == 1) {
            System.out.print("DNI: ");
            String dni = scanner.nextLine();
            return new Estudiante(nombre, apellido, dni);
        } else if (tipo == 2) {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            return new Docente(nombre, apellido, titulo);
        } else {
            System.out.println("Opción inválida.");
            return null;
        }
    }
    
}
