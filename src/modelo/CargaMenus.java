package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class CargaMenus {
	
	public Conexion miConexion;
	public ResultSet miResultSet;
	public ResultSet miResultSet2;
	
	public CargaMenus() {
		
		miConexion = new Conexion();
	}

	public String ejecutaConsultas() {
		
		Productos miProducto = null;
		
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
		
			Statement miStatement = accesoBBDD.createStatement();
			Statement miStatement2 = accesoBBDD.createStatement();
			
			miResultSet = miStatement.executeQuery("SELECT DISTINCTROW rental_duration FROM film ORDER BY rental_duration ASC");
			miResultSet2 = miStatement2.executeQuery("SELECT DISTINCTROW rating FROM film");
				
			miProducto = new Productos();
				
			miProducto.setRental_duration(miResultSet.getString(1));
			miProducto.setRating(miResultSet2.getString(1));
				
			miResultSet.close();
			miResultSet2.close();
			
			accesoBBDD.close();			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return miProducto.getRental_duration();
	}
	
	
}
