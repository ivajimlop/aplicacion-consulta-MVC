package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_Pruebas {

	public static void main(String[] args) {

		try {
			//CREAR CONEXIÓN
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root","CDESWAq951320.");

			//CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();
			
			//EJECUTAR SQL
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM ACTOR");
			
			//LEER EL RESULTSET
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("first_name") + " " + miResultSet.getString("last_name"));
			}
			
			miResultSet.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
