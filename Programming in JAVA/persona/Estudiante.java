package persona;

public class Estudiante extends Persona {
    private String dni;

    public Estudiante(String nombre, String apellido, String dni) {
        super(nombre, apellido);
        this.dni = dni;
    }

    @Override
    public String getInfo() {
        return "Estudiante: " + nombre + " " + apellido + " | DNI: " + dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
