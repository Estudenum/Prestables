package persona;

public class Docente extends Persona {
    private String titulo;

    public Docente(String nombre, String apellido, String titulo) {
        super(nombre, apellido);
        this.titulo = titulo;
    }

    @Override
    public String getInfo() {
        return "Docente: " + nombre + " " + apellido + " | Título: " + titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
