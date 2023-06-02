
import java.util.ArrayList;
import java.util.List;

class EmpresaTransporte {
    private String nombre;
    private List<Asiento> asientos;

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
        this.asientos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setAsientos(Asiento a){
        asientos.add(a);
    }
    public List<Asiento> getAsientos() {
        ArrayList<Asiento> Aux = new ArrayList<Asiento>(asientos);
        return Aux;
    }



    public int cantidadAsientosLibres(){
        int cantidad = 0;
        for (Asiento a : asientos) {
            if(a.getOcupante() == null){
                cantidad++;
            }
        }
        return cantidad;
    }
}

