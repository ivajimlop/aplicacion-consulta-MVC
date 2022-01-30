package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.CargaPrimerCombo;
import vista.Marco_Aplicacion2;

public class ControladorCargaPrimerCombo extends WindowAdapter {
	
	CargaPrimerCombo obj = new CargaPrimerCombo();
	private Marco_Aplicacion2 elmarco;
	
	public ControladorCargaPrimerCombo(Marco_Aplicacion2 elmarco) {
		
		this.elmarco=elmarco;
	}
	
	public void windowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();
		
		try {
			
			while(obj.miResultSet.next()) {
				
				elmarco.primerComboBox.addItem(obj.miResultSet.getString(1));
			}
			
		}catch(Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	}

}
