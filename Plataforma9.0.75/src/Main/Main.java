package Main;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Clases.Pasajero;
import Clases.PasajeroRegistrado;
import Clases.Colectivo;
import Clases.EmpresaTransporte;
import Clases.Asiento;
import Filtros.Filtro;
import Filtros.FiltroCosto;

public class Main {
    public static void main(String[] args) {
  
        try {
        	Scanner s = new Scanner(System.in);
        	System.out.println("Ingrese su nombre, apellido, dni y clave de acceso:");
        	String nombre = s.nextLine();

        	
        	String apellido = s.nextLine();
        	
        	String dni = s.nextLine();
        	
        	String claveAcceso = s.nextLine();
        	
        	int nroT = s.nextInt();
        	
        	Pasajero p1 = new PasajeroRegistrado(nombre, apellido, dni, claveAcceso, nroT);
        	
        	
        	EmpresaTransporte e = new EmpresaTransporte();
        	Filtro f = new FiltroCosto(210.0); // esto deberia hacerse en base a los requerimientos del usuario y el filtro q desee usar
        	
        	
        	List<Colectivo> colectivos = e.GetColectivos("buses.json");
        	
        	boolean compra = false;
        	
        	while(compra == false) {
        		e.listarCompatibles(f, colectivos);
        		compra = e.ComprarPasaje(f,p1);
        	}
        	
        	
        	
        	e.SetColectivos("buses.json");
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}