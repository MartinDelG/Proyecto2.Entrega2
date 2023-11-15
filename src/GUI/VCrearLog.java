package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.AdminGeneral;
import Logica.Aplicacion;

public class VCrearLog extends JFrame{

	private JButton generarLog;
	private JButton regresar;
	
	public VCrearLog(VAdminGeneral VadminGeneral, AdminGeneral admin, Aplicacion app) {
		setLayout(new BorderLayout());
		
		
		JPanel arriba = new JPanel();
        arriba.setBackground(new Color(65, 105, 225));
        JPanel abajo = new JPanel();
        abajo.setBackground(new Color(65, 105, 225));
        abajo.add(Box.createRigidArea(new Dimension(0,15)));
        
        JPanel izq = new JPanel();
        izq.add(Box.createRigidArea(new Dimension(25,0)));
        JPanel der = new JPanel();
        der.add(Box.createRigidArea(new Dimension(15,0)));
        
        this.add(arriba, BorderLayout.NORTH);
        this.add(abajo, BorderLayout.SOUTH);
        this.add(der, BorderLayout.EAST);
        this.add(izq, BorderLayout.WEST);
		
        JLabel label1 = new JLabel("Ingrese el vehículo al que le quiere generar el archivo");
        JComboBox<String> comboBox = new JComboBox<>(app.getInventario().keySet().toArray(new String[0]));
        JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2, 10, 10));
	    //panel.add(idEliminarCarro);
		generarLog = new JButton("Generar Log");
		generarLog.setBackground(new Color(65, 105, 225));
		generarLog.setForeground(Color.WHITE);
		generarLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			String id = (String)comboBox.getSelectedItem();
        			System.out.println(id);
        			admin.generarLog(id);
        			
        			JOptionPane.showMessageDialog(null, "SE CREO EL ARCHIVO PARA EL VEHÍCULO "+id, "CREADO",JOptionPane.INFORMATION_MESSAGE);
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR", "ERROR",JOptionPane.ERROR_MESSAGE);
        		}
            }

        });
	    regresar = new JButton("Regresar");
	    regresar.setBackground(new Color(65, 105, 225));
	    regresar.setForeground(Color.WHITE);
	    regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VadminGeneral.setVisible(true);
        		dispose();
        		
            }

        });
	    
	    panel.add(label1);
	    panel.add(comboBox);
	    panel.add(regresar);
	    panel.add(generarLog);
	    add(panel);
	    
       
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}

}
	
	

