package prestable;

import java.time.LocalDate;

public class Libro extends Prestable {
    private String nombre;

    public Libro(String nombre, LocalDate entrega, LocalDate retiro, boolean disponible) {
        super(entrega, retiro, disponible);
        this.nombre = nombre;
    }

    @Override
    public String getDescripcion() {
        return "Libro: " + nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
