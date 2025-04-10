package prestable;

import java.util.ArrayList;
import java.util.List;

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

    public void modificarDisponibilidad(String descripcion, boolean disponible) {
        for (Prestable p : items) {
            if (p.getDescripcion().contains(descripcion)) {
                p.setDisponible(disponible);
                break;
            }
        }
    }

    public void verDisponibles() {
        for (Prestable p : items) {
            if (p.isDisponible()) {
                System.out.println(p.getDescripcion());
            }
        }
    }
}
