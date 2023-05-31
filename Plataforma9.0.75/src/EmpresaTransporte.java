
import java.util.ArrayList;
import java.util.List;

class EmpresaTransporte {
    private String nombre;
    private List<Asiento> asientos;

    // Constructor
    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
        this.asientos = new ArrayList<>();
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    // Otros métodos relacionados con la empresa de transporte
}

