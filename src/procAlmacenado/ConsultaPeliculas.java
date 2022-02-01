package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaPeliculas {

	public static void main(String[] args) {
		
		 try {
			 
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root","CDESWAq951320.");
			
			CallableStatement miCallableStatement = miConexion.prepareCall("{call MUESTRA_PELICULAS}");
			
			ResultSet miResultSet  = miCallableStatement.executeQuery();
			
			while(miResultSet.next()) {
				
				System.out.println(miResultSet.getString(1) + "  " + miResultSet.getString(2));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
