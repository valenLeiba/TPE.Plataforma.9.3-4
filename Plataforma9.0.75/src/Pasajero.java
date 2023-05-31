abstract class Pasajero {
    private String apellido;
    private String nombre;
    private String dni;
    private TarjetaCredito tarjeta;

    // Constructor
    public Pasajero(String apellido, String nombre, String dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }

    // Métodos getters y setters
    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    // Método abstracto para comprar un pasaje
    public abstract void comprarPasaje();

    // Método para devolver un pasaje
    public void devolverPasaje(int horasAntesSalida) {
        // Lógica para devolver un pasaje
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }
}

