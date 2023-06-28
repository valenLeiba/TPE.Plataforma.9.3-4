public class FiltroEmpresa implements Filtro {
    private String nombre;

    public FiltroEmpresa(String nombre){
        this.nombre=nombre;
    }
    
    @Override
    public boolean cumple(Colectivo c){
        return c.getEmpresa() == nombre; //agregar la variable empresa
    }
}
