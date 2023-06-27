import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.util.List;

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
        	
        	//abc.AddColectivo(bus);
            //Colectivo bus1 = new Colectivo();
        	//bus1.setPatente("123");
        	//abc.AddColectivo(bus1);
        	//Colectivo bus2 = new Colectivo();
        	//bus2.setPatente("1234566");
        	//abc.AddColectivo(bus2);
        	
        	//abc.SetColectivos("buses.json");
        	
        	
        	
        	
        	
        	List<Colectivo> colectivos; 
        	EmpresaTransporte e = new EmpresaTransporte();
        	colectivos= e.GetColectivos("buses.json");
        	
        	
        	for(Colectivo c: colectivos) {
            	
        		for (Asiento seat : c.getSeats()) {
        			
        			Pasajero aux = seat.getOcupante();
        			if(aux != null) {
        				if(aux.getNombre() == ""){
        					System.out.println("Asiento " + seat.getNumero());
        				}
        			}
        		}
        	}
        	       	
        	for(Colectivo c: colectivos) {
        	
        		
        		
        		//el usuario ingresa el asiento que desea
        		int asientonum = 6;
          
        		for (Asiento seat : c.getSeats()) {
           	
        			if(seat.getNumero() == asientonum){  
        				if(seat.getOcupante()!= null) {
        					if(seat.getOcupante().getNombre() == ""){
        						System.out.println("siiiiiiii "); 
                
        						seat.getOcupante().SetNombre("valentin");
        						seat.getOcupante().SetApellido("leiba");
        	
        						e.SetColectivos("buses.json");
        				
        					}else {
        						System.out.println("ese asiento no esta disponible :( ");
        					}
        				}else {
        					System.out.println("no quedan mas asientos disponibles ");
        				}
        			}		
           }
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
