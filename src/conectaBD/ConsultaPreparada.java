package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaPreparada {

	public static void main(String[] args) {
		
		try {
			//CREAR CONEXI�N
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root","CDESWAq951320.");

			//CREAR OBJETO PREPARESTATEMENT
			PreparedStatement miPreparedStatement = miConexion.prepareStatement("SELECT * FROM address WHERE district =?");
			
			//ESTABLECER PAR�METROS DE CONSULTA
			miPreparedStatement.setString(1, "Yamaguchi");//EL VALOR 1 ES PORQUE SOLO TENEMOS UN ? EN LA CONSULTA, SI HUBIERA OTRO PAR�METRO SE HACE EN OTRA L�NEA
			
			//EJECUTAR SQL
			ResultSet miResultSet = miPreparedStatement.executeQuery();
			
			//LEER EL RESULTSET
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("address") + " " + miResultSet.getString("district"));
			}
			
			miResultSet.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	

}
