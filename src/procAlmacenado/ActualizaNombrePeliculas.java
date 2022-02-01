package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ActualizaNombrePeliculas {

	public static void main(String[] args) {
		
		String nombrePelicula = JOptionPane.showInputDialog("nombre nuevo de pelicula");
		int identificadorPelicula = Integer.parseInt(JOptionPane.showInputDialog("identificador de película"));
		
		try {
			 
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root","CDESWAq951320.");
			
			CallableStatement miCallableStatement = miConexion.prepareCall("{call ACTUALIZA_NOMBRE_PELICULA(?,?)}");
			
			miCallableStatement.setString(1, nombrePelicula);
			miCallableStatement.setInt(2, identificadorPelicula);
			
			miCallableStatement.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
