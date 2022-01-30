package aplicacionConsulta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		
		JFrame mimarco = new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);		

	}

}

class Marco_Aplicacion extends JFrame{
	
	private JComboBox primerComboBox, segundoComboBox;
	private JTextArea resultado;
	private PreparedStatement miPreparedStatement;
	private Statement miStatement;
	private final String consultaSeleccionPrimerCombo = "SELECT * FROM film WHERE rental_duration=?";
	private final String consultaSeleccionSegundoCombo = "SELECT * FROM film WHERE rating=?";
	private final String consultaSeleccionTodo = "SELECT * FROM film WHERE rental_duration=? and rating=?";
	private final String consultaSinSeleccion = "SELECT * FROM film";
	private Connection miConexion;
	
	
	public Marco_Aplicacion() {
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus = new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		primerComboBox = new JComboBox();
		
		primerComboBox.setEditable(false);
		
		primerComboBox.addItem("Todos");
		
		segundoComboBox = new JComboBox();
		
		segundoComboBox.setEditable(false);
		
		segundoComboBox.addItem("Todos");
		
		resultado = new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		//add(resultado); ESTO CREO Q ES REDUNDANTE
		
		menus.add(primerComboBox);// TENGO QUE PONER MI COLUMNA PARA BUSCAR
		
		menus.add(segundoComboBox);// TENGO QUE PONER MI COLUMNA PARA BUSCAR
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta = new JButton("Consulta");
		
		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ejecutaConsulta();
				
			}
			
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		//---------------------------- CONEXIÓN CON BBDD ----------------------------------//
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root","CDESWAq951320.");

			Statement miStatement = miConexion.createStatement();
			
			//---- CARGA DEL PRIMER COMBOBOX -------//
			
			String query = "SELECT DISTINCTROW rental_duration FROM film ORDER BY rental_duration ASC";
			
			ResultSet miResultSet = miStatement.executeQuery(query);
			
			while(miResultSet.next()) {
				
				primerComboBox.addItem(miResultSet.getString(1));
				
			}
			
			miResultSet.close();
			
			//---- CARGA DEL SEGUNDO COMBOBOX -------//
			
			query = "SELECT DISTINCTROW rating FROM film";
			
			miResultSet = miStatement.executeQuery(query);
			
			while(miResultSet.next()) {
				
				segundoComboBox.addItem(miResultSet.getString(1));
				
			}
			
			miResultSet.close();
			
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	//------------------ CREAR MÉTODO PARA INTERACTUAR CON EL BOTÓN Y LA BASE DE DATOS -----------------------------//
	
		private void ejecutaConsulta() {
			
			ResultSet rs = null;
			
			try {
				
				resultado.setText("");
				
				String eleccionPrimerCombo=(String)primerComboBox.getSelectedItem();
				String eleccionSegundoCombo=(String)segundoComboBox.getSelectedItem();
				
				if(!eleccionPrimerCombo.equals("Todos") && eleccionSegundoCombo.equals("Todos")) {
					
					miPreparedStatement = miConexion.prepareStatement(consultaSeleccionPrimerCombo);
				
					miPreparedStatement.setString(1,eleccionPrimerCombo);
				
					rs = miPreparedStatement.executeQuery();
					
				}else if(eleccionPrimerCombo.equals("Todos") && !eleccionSegundoCombo.equals("Todos")) {
					
					miPreparedStatement = miConexion.prepareStatement(consultaSeleccionSegundoCombo);
					
					miPreparedStatement.setString(1,eleccionSegundoCombo);
				
					rs = miPreparedStatement.executeQuery();
					
				}else if(eleccionPrimerCombo.equals("Todos") && eleccionSegundoCombo.equals("Todos")) {
					
					miStatement = miConexion.createStatement();
				
					rs = miStatement.executeQuery(consultaSinSeleccion);
				}				
				
				else {
					
					miPreparedStatement = miConexion.prepareStatement(consultaSeleccionTodo);
					
					miPreparedStatement.setString(1,eleccionPrimerCombo);
					miPreparedStatement.setString(2,eleccionSegundoCombo);
				
					rs = miPreparedStatement.executeQuery();
					
				}
				
				while(rs.next()) {
					
					resultado.append(rs.getString(2));
						
					resultado.append(",   ");
						
					resultado.append(rs.getString(4));
						
					resultado.append(",   ");
						
					resultado.append(rs.getString(7));
						
					resultado.append(",   ");
						
					resultado.append(rs.getString(11));
						
					resultado.append("\n");
				}
				
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
		
	
}
