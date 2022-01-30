package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.ControladorCargaPrimerCombo;

public class Marco_Aplicacion2 extends JFrame {
	
	public JComboBox primerComboBox, segundoComboBox;
	private JTextArea resultado;

	public Marco_Aplicacion2() {
			
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
			
			menus.add(primerComboBox);// TENGO QUE PONER MI COLUMNA PARA BUSCAR
			
			menus.add(segundoComboBox);// TENGO QUE PONER MI COLUMNA PARA BUSCAR
			
			add(menus, BorderLayout.NORTH);
			
			add(resultado, BorderLayout.CENTER);
			
			JButton botonConsulta = new JButton("Consulta");
			
			add(botonConsulta, BorderLayout.SOUTH);
			
			addWindowListener(new ControladorCargaPrimerCombo(this));
	}

}
