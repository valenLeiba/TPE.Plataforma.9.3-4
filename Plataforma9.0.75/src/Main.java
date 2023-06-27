import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Colectivo bus = new Colectivo();
        Asiento prueba = new Asiento(2);
        PasajeroRegistrado mauro = new PasajeroRegistrado("belmonte", "mauro", "12345", "1234");
        prueba.setOcupante(mauro);
        
        bus.addSeat(new Asiento(1));
        bus.addSeat(prueba);
        bus.addSeat(new Asiento(3));
        bus.addSeat(new Asiento(4));
        bus.addSeat(new Asiento(5));
       bus.addSeat(new Asiento(6));
       bus.addSeat(new Asiento(7));
        bus.addSeat(new Asiento(8));
        bus.setPatente("134abc");

        try {
        //  bus.saveToJson("bus.json");

        	EmpresaTransporte abc = new EmpresaTransporte();
        	
        	abc.AddColectivo(bus);
            Colectivo bus1 = new Colectivo();
        	bus1.setPatente("123");
        	abc.AddColectivo(bus1);
        	Colectivo bus2 = new Colectivo();
        	bus2.setPatente("1234566");
        	abc.AddColectivo(bus2);
        	
        	abc.SetColectivos("buses.json");
        	
        	
        	
        	EmpresaTransporte empresa = new EmpresaTransporte(); 
        	
        	empresa.GetColectivos("buses.json");
        	
        	/*
            Colectivo loadedBus = bus.loadFromJson("bus.json");

            System.out.println("Asientos cargados desde el archivo JSON:");
            System.out.println("los asientos disponibles son");
            for (Asiento seat : loadedBus.getSeats()) {
            	
            	 Pasajero aux = seat.getOcupante();
            	if(aux.getNombre() == ""){
            		System.out.println("Asiento " + seat.getNumero());
            	}
            }
            
            //el usuario ingresa el asiento que desea
           int asientonum = 4;
          
           for (Asiento seat : loadedBus.getSeats()) {
           	
          	if(seat.getNumero() == asientonum){  		 
          		if(seat.getOcupante().getNombre() == ""){
          			System.out.println("siiiiiiii "); 
                
          			seat.getOcupante().SetNombre("valentin");
          			seat.getOcupante().SetApellido("rubare");
                	loadedBus.saveToJson("bus.json");
                	break;
          		}else {
          			System.out.println("ese asiento no esta disponible :( ");
          		}
          	}
           }
         */ 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
