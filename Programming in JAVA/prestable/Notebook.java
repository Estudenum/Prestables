package prestable;

import java.time.LocalDate;

public class Notebook extends Prestable {
    private String codigo;

    public Notebook(String codigo, LocalDate entrega, LocalDate retiro, boolean disponible) {
        super(entrega, retiro, disponible);
        this.codigo = codigo;
    }

    @Override
    public String getDescripcion() {
        return "Notebook Código: " + codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
