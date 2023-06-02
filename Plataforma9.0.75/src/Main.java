import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Crea asientos
        Asiento a1 = new Asiento(1);
        Asiento a2 = new Asiento(2);
        Asiento a3 = new Asiento(3);
        Asiento a4 = new Asiento(4);

        //crea empresa transporte
        EmpresaTransporte viaTac = new EmpresaTransporte("viaTac");
        viaTac.setAsientos(a1);
        viaTac.setAsientos(a2);
        viaTac.setAsientos(a3);
        viaTac.setAsientos(a4);

        //crea pasajero registrado
        PasajeroRegistrado p1 = new PasajeroRegistrado("Gonzalez", "juan", "123", "4330");

        p1.comprarPasaje(a1);
        p1.devolverPasaje(a1);
        System.out.println(viaTac.cantidadAsientosLibres());

    }
}