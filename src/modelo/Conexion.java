package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	Connection miConexion = null;


	public Conexion() {
		
	}
	
	public Connection dameConexion() {
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root","CDESWAq951320.");

		
	
	}catch(Exception e) {
		
		e.printStackTrace();
	}
		return miConexion;
	}
}
