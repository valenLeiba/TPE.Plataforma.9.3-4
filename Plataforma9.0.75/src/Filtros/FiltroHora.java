package Filtros;
import Clases.Colectivo;

public class FiltroHora implements Filtro{
    private double horarioinicio;
    private double horariofin;

    public FiltroHora(Double horarioinicio, Double horariofin){
        this.horarioinicio=horarioinicio;
        this.horariofin = horariofin;
    }
    @Override
    public boolean cumple(Colectivo c){
        return c.getHorarioinicio() >= horarioinicio && c.getHorariollegada() <= horariofin; //agregar la variable horario
    }
}
