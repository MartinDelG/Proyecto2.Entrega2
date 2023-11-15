package GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Logica.Aplicacion;
import Logica.Cliente;

public class VconsultarDispo extends JFrame {
	private JPanel PArriba;
	private JPanel PDer;
	private PIqDisp pIqDisp;
	private JButton mostrar;
	private JComboBox<String> comboBox;
	private JButton regresar;
	private int[][] matrizDispo;
	public VconsultarDispo(VCliente Vcliente, Cliente cliente, Aplicacion app) {
		// TODO Auto-generated constructor stub
		//generar panel de la derecha 
		setLayout(new BorderLayout());
		PDer = new JPanel(new GridLayout(6, 1, 5, 5));
		PArriba = new JPanel(new FlowLayout());
		JLabel lab1 = new JLabel("AZUL OSCURO: DIA NO DISPONIBLE.");
		JLabel lab2 = new JLabel("AZUL CLARO: ALGUN CARRO EN USO, PERO NO LLENO  "); 
		JLabel lab4 = new JLabel("cada liena 30 dias desde 2023-10-16"); 
		//JLabel lab3 = new JLabel("1  2  3  4  5  6  7  8  9  10   11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30");
		//lab3.setHorizontalAlignment(SwingConstants.LEFT);
		//PArriba.add(lab3);
		PArriba.add(Box.createRigidArea(new Dimension(700,0)));
		add(PArriba,BorderLayout.NORTH );
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		
		mostrar = new JButton("MOSTRAR DISPO");
		mostrar.setBackground(new Color(65, 105, 225));
		mostrar.setForeground(Color.WHITE);
		comboBox = new JComboBox<>(app.getSedes().keySet().toArray(new String[0]));
		String sedeMostrar = (String)comboBox.getSelectedItem();
		int [][] matrizDispo = cliente.matrizDispo(app, sedeMostrar);
		
		pIqDisp = new PIqDisp(matrizDispo);
		
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		PDer.add(comboBox);
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		PDer.add(mostrar);
		//PDer.add(Box.createRigidArea(new Dimension(0,10)));
		
		mostrar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {	
	        		try {
	        			String sedeMostrar = (String)comboBox.getSelectedItem();
	        			System.out.println(sedeMostrar);
	        			int [][] matrizDispo = cliente.matrizDispo(app, sedeMostrar);
	        			//metodo para graficar
	        			pIqDisp.camSede(matrizDispo);
	        			pIqDisp.re();
	        			//JOptionPane.showMessageDialog(null, "EL VEHICULO CON ID "+idELim+" HA SIDO ELIMINADO", "ELIMINADO",JOptionPane.INFORMATION_MESSAGE);
	        			//comboBox.removeItem(idELim);
	        		} catch (Exception a) {
	        			 a.printStackTrace();
	        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR, REVISE EL ID", "ERROR",JOptionPane.ERROR_MESSAGE);
	        		}
	            }

	        });
		
	 	regresar = new JButton("Regresar");
	    regresar.setBackground(new Color(65, 105, 225));
	    regresar.setForeground(Color.WHITE);
	    regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Vcliente.setVisible(true);
        		dispose();
        		
            }

        });
	   //PDer.add(Box.createRigidArea(new Dimension(0,10)));
	   PDer.add(regresar);
	   //PDer.add(Box.createRigidArea(new Dimension(0,10)));
  
	   //PDer.add(Box.createRigidArea(new Dimension(0,10)));
	   PDer.add(lab1);
	   //PDer.add(Box.createRigidArea(new Dimension(0,10)));
	   
	   //PDer.add(Box.createRigidArea(new Dimension(0,10)));
	   PDer.add(lab2);
	   PDer.add(lab4);
	   //PDer.add(Box.createRigidArea(new Dimension(0,10)));
	    add(PDer, BorderLayout.EAST);
	    add(pIqDisp, BorderLayout.CENTER);
	    
	    setSize(1200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}
	 
}
