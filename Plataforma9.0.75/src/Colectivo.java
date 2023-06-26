
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
            jsonObject.put("isOccupied", seat.getOcupante());
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

            // Verificar si la clave "isOccupied" existe en el objeto
            boolean isOccupied = jsonObject.has("isOccupied") ? jsonObject.getBoolean("isOccupied") : false;

            // Obtén más atributos si es necesario
            Asiento seat = new Asiento(seatNumber);
            bus.addSeat(seat);
        }

        return bus;
    }
    public List<Asiento> getSeats() {
        return seats;
    }
}