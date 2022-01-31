package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.CargaMenus;
import vista.Marco_Aplicacion2;

public class ControladorCargaMenus extends WindowAdapter {
	
	CargaMenus obj = new CargaMenus();
	private Marco_Aplicacion2 elmarco;
	
	public ControladorCargaMenus(Marco_Aplicacion2 elmarco) {
		
		this.elmarco=elmarco;
	}
	
	public void windowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();
		
		try {
			
			while(obj.miResultSet.next()) {
				
				elmarco.primerComboBox.addItem(obj.miResultSet.getString(1));
			}
			
			while(obj.miResultSet2.next()) {
				
				elmarco.segundoComboBox.addItem(obj.miResultSet2.getString(1));
			}
		}catch(Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	}

}
