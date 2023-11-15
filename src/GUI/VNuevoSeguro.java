package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.AdminGeneral;
import Logica.Aplicacion;

public class VNuevoSeguro extends JFrame {
	private JButton NuevoSeguro;
	private JButton regresar;
	private JTextField nombre;
	private JTextField costo;
	public VNuevoSeguro(VAdminGeneral VadminGeneral, AdminGeneral admin, Aplicacion app) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		JLabel IDLabel = new JLabel("Ingrese los datos del nuevo Seguro: ");
		JPanel arriba = new JPanel();
        arriba.setBackground(new Color(65, 105, 225));
        IDLabel.setForeground(Color.WHITE);
        arriba.add(IDLabel);
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
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 10, 10));
		nombre = new JTextField();
		costo = new JTextField();
	    //panel.add(idEliminarCarro);
		NuevoSeguro = new JButton("Crear Seguro");
		NuevoSeguro.setBackground(new Color(65, 105, 225));
		NuevoSeguro.setForeground(Color.WHITE);
		NuevoSeguro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			String nom = nombre.getText();
        			String costo = nombre.getText();
        			
        			admin.nuevoSeguro(app, nom, costo);
        			
        			JOptionPane.showMessageDialog(null, "SE HA CREADO EXITOSAMENTE UN NUEVO SEGURO", "CREADO",JOptionPane.INFORMATION_MESSAGE);
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR CREANDO EL SEGURO", "ERROR",JOptionPane.ERROR_MESSAGE);
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
	    JLabel Lnombre = new JLabel("Nombre ");
	    panel.add(Lnombre);
	    JLabel Lprecio = new JLabel("precio: ");
	    panel.add(Lprecio);
	    panel.add(nombre);
	    panel.add(costo);
	    panel.add(NuevoSeguro);
	    panel.add(regresar);
	    add(panel);
	    
       
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}	

}
