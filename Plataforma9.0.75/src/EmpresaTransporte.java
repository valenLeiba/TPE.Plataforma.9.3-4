
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

class EmpresaTransporte {
    private String nombre;
    private List<Colectivo> colectivos;



   public EmpresaTransporte() {
	   
	   colectivos = new ArrayList<>();
   }
		   
    public List<Colectivo> GetColectivos(String fileName) throws IOException {
    	String jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
    	  JSONArray jsonArray = new JSONArray(jsonString);
    	  
          for (int i = 0; i < jsonArray.length(); i++) {
              JSONObject jsonObject = jsonArray.getJSONObject(i);
              Colectivo c = new Colectivo();

              String patente = jsonObject.getString("patente");
              
              c.setPatente(patente);
             // System.out.println("Patente: " + patente);

              JSONArray asientosArray = jsonObject.getJSONArray("asientos");
            //  System.out.println("Asientos:");
              for (int j = 0; j < asientosArray.length(); j++) {
                  JSONObject asientoObject = asientosArray.getJSONObject(j);
                  

                  String apellido = asientoObject.getString("apellido");
                  String nombre = asientoObject.getString("nombre");
                  int seatNumber = asientoObject.getInt("seatNumber");

                  Asiento A = new Asiento(seatNumber);
                  PasajeroRegistrado P = new PasajeroRegistrado(apellido, nombre, "","");
                  
                  A.setOcupante(P);
                  c.addSeat(A);
                //  System.out.println("  Apellido: " + apellido);
                 // System.out.println("  Nombre: " + nombre);
                 // System.out.println("  Número de asiento: " + seatNumber);
                 // System.out.println();
              }
              colectivos.add(c);
          }
          
          return colectivos;
      }
  
    	

    private String readFileAsString(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        
        return content.toString();
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
 

   
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
