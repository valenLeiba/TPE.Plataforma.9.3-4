package Clases;
public class PasajeroRegistrado extends Pasajero {
    private String claveAcceso;


    
    public String getClaveAcceso() {
        return claveAcceso;
    }
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }


    public PasajeroRegistrado(String apellido, String nombre, String dni, String claveAcceso, int nroTarjeta) {
        super(apellido, nombre, dni, nroTarjeta);
        this.claveAcceso = claveAcceso;
    }


    @Override
    public void comprarPasaje(Asiento asiento) {
        asiento.setOcupante(this);
    }

}
