import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
  
        try {
        	
        	List<Colectivo> colectivos; 
        	EmpresaTransporte e = new EmpresaTransporte();
        	Filtro f = new FiltroCosto(210.0); // esto deberia hacerse en base a los requerimientos del usuario y el filtro q desee usar
        	
        	
        	e.listarCompatibles(f);
        	e.ComprarPasaje(f,3);
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
