package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String[] args) {
		
		try {
			//CREAR CONEXIÓN
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root","CDESWAq951320.");

			//CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();
			
			//String instruccionSql = "INSERT INTO actor (first_name,last_name) VALUES ('IVÁN','JIMÉNEZ LÓPEZ')"; PARA INSERTAR UN NUEVO REGISTRO
			//String instruccionSql = "UPDATE actor SET first_name = 'IVANCITO' WHERE actor_id = 201"; PARA MODIFICAR EL VALOR DE UN REGISTRO
			String instruccionSql = "DELETE FROM actor WHERE actor_id = 201";//PARA BORRAR UN REGISTRO
			
			miStatement.executeUpdate(instruccionSql);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	

}
