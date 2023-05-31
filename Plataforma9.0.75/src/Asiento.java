public class Asiento {

        private int numero;
        private Pasajero ocupante;

        // Constructor
        public Asiento(int numero) {
            this.numero = numero;
        }

        // Métodos getters y setters
        public int getNumero() {
            return numero;
        }

        public Pasajero getOcupante() {
            return ocupante;
        }

        public void setOcupante(Pasajero ocupante) {
            this.ocupante = ocupante;
        }
}
