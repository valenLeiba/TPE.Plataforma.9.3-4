
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

class EmpresaTransporte {
    private String nombre;
    private List<Colectivo> colectivos;



   public EmpresaTransporte() {
	   
	   colectivos = new ArrayList<>();
   }
		   
    public static List<Colectivo> getColectivos(String fileName) throws IOException {
    	        List<Colectivo> buses = new ArrayList<>();
    	        	
    	        String jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
    	        JSONArray jsonArray = new JSONArray(jsonString);

    	        for (int i = 0; i < jsonArray.length(); i++) {
    	            JSONObject jsonObject = jsonArray.getJSONObject(i);
    	            int seatNumber = jsonObject.getInt("seatNumber");

    	          
    	            // Obtén más atributos si es necesario
    	            Asiento seat = new Asiento(seatNumber);
    	            PasajeroRegistrado pasajero = new PasajeroRegistrado(jsonObject.getString("apellido"), jsonObject.getString("nombre"),"" ,"" );
    	            seat.setOcupante(pasajero);
    	            bus.addSeat(seat);
    	        }

    	        return bus;
    	    }
     }    
    

    public void SetColectivos(String fileName) throws IOException {
    	
    	//JSONObject colectivo = new JSONObject();
    	JSONArray jsonArray = new JSONArray();
    	//JSONArray  = new JSONArray();
    	for(Colectivo b: colectivos) {
    		JSONObject colectivo = new JSONObject();
    		colectivo.put("patente", b.getPatente());
    		colectivo.put("asientos", b.abc123("bus.json"));

    		jsonArray.put(colectivo);
    	}
    	
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonArray.toString(4));
        }
    }


    
    public void AddColectivo(Colectivo a) {
    	
    	colectivos.add(a);
    	
    
    }
}
 

   
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
