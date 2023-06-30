package Clases;
public abstract class Pasajero {
    private String apellido;
    private String nombre;
    private String dni;
    private int nroTarjeta;

	public Pasajero(String apellido, String nombre, String dni, int nroTarjeta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.nroTarjeta = nroTarjeta;
    }
    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void SetNombre(String Nombre) {
        nombre = Nombre;
    }
    public void SetApellido(String Apellido) {
        apellido = Apellido;
    }

    public String getDni() {
        return dni;
    }

    public abstract void comprarPasaje(Asiento asiento);

    
    public int getNroTarjeta() {
    	return nroTarjeta;
    }
    public void setNroTarjeta(int nroTarjeta) {
    	this.nroTarjeta = nroTarjeta;
    }
}

