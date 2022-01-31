package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EjecutaConsultas {

	private Conexion miConexion;
	private ResultSet miResultSet;
	private PreparedStatement consulta;
	private final String eleccionPrimerCombo = "SELECT * FROM film WHERE rental_duration=?";
	private final String eleccionSegundoCombo = "SELECT * FROM film WHERE rating=?";
	private final String eleccionTodo = "SELECT * FROM film WHERE rental_duration=? and rating=?";
	
	public EjecutaConsultas () {
		
		
		miConexion = new Conexion();
	}
	
	public ResultSet filtraBBDD (String primerCombo, String segundoCombo) {
		
		Connection conecta = miConexion.dameConexion();
		
		miResultSet = null;
		
		try {
		
			if(!primerCombo.equals("Todos") && segundoCombo.equals("Todos")) {
				
				consulta = conecta.prepareStatement(eleccionPrimerCombo);	
				consulta.setString(1, primerCombo);
				miResultSet = consulta.executeQuery();
				
			}else if(primerCombo.equals("Todos") && !segundoCombo.equals("Todos")) {
				
				consulta = conecta.prepareStatement(eleccionSegundoCombo);	
				consulta.setString(1, segundoCombo);
				miResultSet = consulta.executeQuery();
				
			}else {
				
				consulta = conecta.prepareStatement(eleccionTodo);	
				consulta.setString(1, primerCombo);
				consulta.setString(2, segundoCombo);
				miResultSet = consulta.executeQuery();
				
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			
		return miResultSet;
	}
}
