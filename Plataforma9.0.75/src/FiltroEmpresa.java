public class FiltroEmpresa {
    private String nombre;

    public FiltroEmpresa(String nombre){
        this.nombre=nombre;
    }

    @Override
    public boolean cumple(){
        return c.getEmpresa().equals(nombre); //agregar la variable empresa
    }
}
