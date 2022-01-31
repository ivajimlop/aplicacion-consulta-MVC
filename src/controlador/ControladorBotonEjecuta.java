package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.EjecutaConsultas;
import vista.Marco_Aplicacion2;

public class ControladorBotonEjecuta implements ActionListener{

	private Marco_Aplicacion2 elmarco;
	private ResultSet miResultSet;
	EjecutaConsultas obj= new EjecutaConsultas();
	
	public ControladorBotonEjecuta(Marco_Aplicacion2 elmarco) {
		
		this.elmarco=elmarco;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String seleccionPrimerCombo = (String)elmarco.primerComboBox.getSelectedItem();
		String seleccionSegundoCombo = (String)elmarco.segundoComboBox.getSelectedItem();
		
		miResultSet = obj.filtraBBDD(seleccionPrimerCombo, seleccionSegundoCombo);
	
		try {
			
			elmarco.resultado.setText("");
			
			while(miResultSet.next()) {
				
				elmarco.resultado.append(miResultSet.getString(2));
				elmarco.resultado.append(",     ");
				
				elmarco.resultado.append(miResultSet.getString(4));
				elmarco.resultado.append(",     ");
				
				elmarco.resultado.append(miResultSet.getString(7));
				elmarco.resultado.append(",     ");
				
				elmarco.resultado.append(miResultSet.getString(11));
				elmarco.resultado.append("\n");
			}
		} catch (SQLException e1) {
			//
			e1.printStackTrace();
		}
	}

}
