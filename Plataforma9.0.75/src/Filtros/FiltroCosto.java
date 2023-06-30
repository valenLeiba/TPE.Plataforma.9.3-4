package Filtros;
import Clases.Colectivo;

public class FiltroCosto implements Filtro{
    private double precio;

    public FiltroCosto(double precio) {
        this.precio = precio;
    }
    @Override
    public boolean cumple(Colectivo c){
        return c.getPrecio() <= precio; // agregar la variable costo
    }
}
