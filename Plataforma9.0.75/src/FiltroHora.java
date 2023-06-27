public class FiltroHora {
    private double horario;

    public FiltroHora(Double horario){
        this.horario=horario;
    }

    public boolean cumple(Colectivo c){
        return c.getHorario() == horario; //agregar la variable horario
    }
}
