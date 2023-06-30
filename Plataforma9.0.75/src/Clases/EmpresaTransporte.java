package Clases;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;
import Filtros.Filtro;

public class EmpresaTransporte {
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
              
              Colectivo c = new Colectivo(jsonObject.getDouble("precio"),jsonObject.getDouble("horarioInicio"),jsonObject.getDouble("horariollegada"),jsonObject.getString("empresa"));
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
                  PasajeroRegistrado P = new PasajeroRegistrado(apellido, nombre, "","", 0);
                  
                  A.setOcupante(P);
                  c.addSeat(A);
                //  System.out.println("  Apellido: " + apellido);
                 // System.out.println("  Nombre: " + nombre);
                 // System.out.println("  N�mero de asiento: " + seatNumber);
                 // System.out.println();
              }
              colectivos.add(c);
          }
          
          return colectivos;
      }


    public void SetColectivos(String fileName) throws IOException {
    	
    	//JSONObject colectivo = new JSONObject();
    	JSONArray jsonArray = new JSONArray();
    	//JSONArray  = new JSONArray();
    	for(Colectivo b: colectivos) {
    		JSONObject colectivo = new JSONObject();
    		colectivo.put("patente", b.getPatente());
    		colectivo.put("asientos", b.saveToJsonSinIO("buses.json"));
    		colectivo.put("horarioInicio", b.getHorarioinicio());
    		colectivo.put("horariollegada", b.getHorariollegada());
        	colectivo.put("precio", b.getPrecio());
        	colectivo.put("empresa", b.getEmpresa());

    		jsonArray.put(colectivo);
    	}
    	
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonArray.toString(4));
        }
    }


    
    public void AddColectivo(Colectivo a) {
    	
    	colectivos.add(a);	
    }
    
    public void listarCompatibles(Filtro f, List<Colectivo> colectivos) throws IOException {
    	

    
    	for(Colectivo c: colectivos) {
        	if(f.cumple(c)) {
        		System.out.println("Empresa '" + c.getEmpresa() + "' [salida: " + c.getHorarioinicio() + ", llegada: " + c.getHorariollegada() + "]");
        		for (Asiento seat : c.getSeats()) {
    			
    				Pasajero aux = seat.getOcupante();
    				if(aux != null) {
    					if(aux.getNombre() == ""){
    						System.out.println("\tAsiento " + seat.getNumero());
    					}
    				}
    			}
        	}
    	}
    }
    
    public boolean ComprarPasaje(Filtro f, Pasajero p1) throws IOException {
    		
    		for(Colectivo c: colectivos) {
    		
	    		if(f.cumple(c)) {
	    			//el usuario ingresa el asiento que desea
	    			Scanner n = new Scanner(System.in);
	    			System.out.println("Ingrese el asiento que desea...");
	    			int asiento = n.nextInt();
	  
	    			for (Asiento seat : c.getSeats()) { // CAMBIAR POR UN WHILE (COMPRA == FALSE) 
	    												// CUANDO SE REALIZA LA COMPRA -> COMPRA = TRUE Y SALE DEL WHILE
	   	
	    				if(seat.getNumero() == asiento){
	    					if(seat.getOcupante()!= null) {
	    						if(seat.getOcupante().getNombre() == ""){
	//								if(validarCompra(p1))-------------------------------
	    								seat.getOcupante().SetNombre(p1.getNombre());
	    								seat.getOcupante().SetApellido(p1.getApellido());
	    								n.close();
	    								return true;
	   							
	    						}else {
	    							System.out.println("ese asiento no esta disponible :( ");
	    						}
	    					}else {
	    						System.out.println("no quedan mas asientos disponibles ");
	    					}
	    				}
	    			}
	    			
	    		}
    	}
    	return false;
   }
    
    public boolean validarCompra(PasajeroRegistrado p1) {
    		return true;	// Aca iria la funcionalidad que se vincula con el sistema externo de validacion de tarjetas.
    }
    
    // ---------------------- GETTERS AND SETTERS -------------------------------
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public List<Colectivo> getColectivos() {
    	return colectivos;
    }
    
    public void setColectivos(List<Colectivo> colectivos) {
    	this.colectivos = colectivos;
    }
}