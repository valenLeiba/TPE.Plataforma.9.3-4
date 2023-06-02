abstract class Pasajero {
    private String apellido;
    private String nombre;
    private String dni;
    private TarjetaCredito tarjeta;

    public Pasajero(String apellido, String nombre, String dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }
    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }


    public abstract void comprarPasaje(Asiento asiento);

    public void devolverPasaje(Asiento asiento) {
        asiento.setOcupante(null);
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }
}

