package modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class CargaPrimerCombo {
	
	Conexion miConexion;
	public ResultSet miResultSet;
	
	public CargaPrimerCombo() {
		
		miConexion = new Conexion();
	}

	public String ejecutaConsultas() {
		
		Productos miProducto = null;
		
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
		
			Statement miStatement = accesoBBDD.createStatement();
			
			miResultSet = miStatement.executeQuery("SELECT DISTINCTROW rental_duration FROM film ORDER BY rental_duration ASC");
				
			miProducto = new Productos();
				
			miProducto.setRental_duration(miResultSet.getString(1));
				
			miResultSet.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return miProducto.getRental_duration();
	}
	
	
}
