
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Colectivo {
    private List<Asiento> seats;
    private String patente;
    
    
    private double precio;
    private String empresa;
    private double horarioinicio;
    private double horariollegada;

    public Colectivo() {
        seats = new ArrayList<>();
    }

    public void addSeat(Asiento seat) {
        seats.add(seat);
    }

    // Métodos para gestionar los asientos (ocupar, desocupar, etc.)

    public void saveToJson(String fileName) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Asiento seat : seats) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("seatNumber", seat.getNumero());
            if(seat.getOcupante() != null) {
            	Pasajero pasajero = seat.getOcupante();
            
            	jsonObject.put("nombre", pasajero.getNombre());
            	jsonObject.put("apellido", pasajero.getApellido());
            	
            }else {
            	
            	jsonObject.put("nombre", "");
            	jsonObject.put("apellido", "");
            }
            // Agrega más atributos si es necesario
            jsonArray.put(jsonObject);
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonArray.toString(4));
        }
    }

    public static Colectivo loadFromJson(String fileName) throws IOException {
        Colectivo bus = new Colectivo();

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
    
    
   
    
    
    public JSONArray abc123(String fileName) {
        JSONArray jsonArray = new JSONArray();
        for (Asiento seat : seats) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("seatNumber", seat.getNumero());
            if(seat.getOcupante() != null) {
            	Pasajero pasajero = seat.getOcupante();
            
            	jsonObject.put("nombre", pasajero.getNombre());
            	jsonObject.put("apellido", pasajero.getApellido());
            	
            }else {
            	
            	jsonObject.put("nombre", "");
            	jsonObject.put("apellido", "");
            }
            // Agrega más atributos si es necesario
            jsonArray.put(jsonObject);
        }
        
        return jsonArray;
    }
    
    
    
    
    
    public List<Asiento> getSeats() {
        return seats;
    }
    
    public void RemoveSeats(int pos) {
        seats.remove(pos);
    }

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public double getHorariollegada() {
		return horariollegada;
	}

	public void setHorariollegada(double horariollegada) {
		this.horariollegada = horariollegada;
	}

	public double getHorarioinicio() {
		return horarioinicio;
	}

	public void setHorarioinicio(double horarioinicio) {
		this.horarioinicio = horarioinicio;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}