public class Asiento {

        private int numero;
        private Pasajero ocupante;

        public Asiento(int numero) {
            this.numero = numero;
        }

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

