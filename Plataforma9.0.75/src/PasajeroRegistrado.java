class PasajeroRegistrado extends Pasajero {
    private String claveAcceso;

    // Constructor
    public PasajeroRegistrado(String apellido, String nombre, String dni, String claveAcceso) {
        super(apellido, nombre, dni);
        this.claveAcceso = claveAcceso;
    }

    // Implementación del método comprarPasaje()
    @Override
    public void comprarPasaje() {
        // Lógica para comprar un pasaje para un pasajero registrado
    }

}
