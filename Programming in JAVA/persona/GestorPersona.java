package persona;

import java.util.ArrayList;
import java.util.List;

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

    public void modificarPersona(String nombre, String nuevoApellido) {
        for (Persona p : personas) {
            if (p.nombre.equals(nombre)) {
                p.apellido = nuevoApellido;
                break;
            }
        }
    }
}
