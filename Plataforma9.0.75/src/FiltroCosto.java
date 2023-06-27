public class FiltroCosto {
    private double precio;

    public FiltroCosto(double precio) {
        this.precio = precio;
    }

    public boolean cumple(Colectivo c){
        return c.getCosto() < precio; // agregar la variable costo
    }
}
