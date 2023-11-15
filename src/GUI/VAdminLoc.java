package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.AdminLocal;
import Logica.Aplicacion;
import Logica.Empleado;

public class VAdminLoc extends JFrame {
	JButton nuevoCliente;
	VNuevoEmpleado vNuevoEmpleado;
	VNuevoCliente vNuevoCliente;
	JButton nuevoEmpleado;
	JButton Regresar;
	public VAdminLoc(VLogIn vlogin, AdminLocal aLoc, Aplicacion app ) {
		// TODO Auto-generated constructor stub
				setLayout(new BorderLayout());
				VAdminLoc this_temp = this;
		        JLabel usernameLabel = new JLabel("Elija una opcion: ");
		        
		        
		        JPanel arriba = new JPanel();
		        arriba.setBackground(new Color(65, 105, 225));
		        arriba.add(usernameLabel);
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
		        
		        usernameLabel.setForeground(Color.WHITE);
		        JPanel buttonPanel = new JPanel(new GridLayout(6,1 , 10, 10));
		        add(buttonPanel, BorderLayout.CENTER);

		        nuevoCliente = new JButton("Nuevo Cliente");
		        nuevoCliente.setBackground(new Color(65, 105, 225));
		        nuevoCliente.setForeground(Color.WHITE);
		        nuevoCliente.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	vNuevoCliente = new VNuevoCliente(this_temp, aLoc, app);
		                setVisible(false);
		                vNuevoCliente.setVisible(true);
		            }
		        });
		        
		        nuevoEmpleado = new JButton("Nuevo empleado");
		        nuevoEmpleado.setBackground(new Color(65, 105, 225));
		        nuevoEmpleado.setForeground(Color.WHITE);
		        nuevoEmpleado.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	vNuevoEmpleado = new VNuevoEmpleado(this_temp, aLoc, app);
		                setVisible(false);
		                vNuevoEmpleado.setVisible(true);
		            }
		        });
		        
		        
		        
		        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
		        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
		        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
		        
		        buttonPanel.add(nuevoCliente);
		        buttonPanel.add(nuevoEmpleado);
		        
		        Regresar = new JButton("Regresar");
		        buttonPanel.add(Regresar);
		        Regresar.setBackground(new Color(65, 105, 225));
		        Regresar.setForeground(Color.WHITE);
		        Regresar.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                //VEliminarVehiculo vEliminarVehiculo = new VEliminarVehiculo();
		                setVisible(false);
		                vlogin.setVisible(true);
		            }
		        });
		        
		        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
		        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
		        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
		        setSize(400, 350);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setLocationRelativeTo(null);
		        setVisible(false);
		    }
		}
