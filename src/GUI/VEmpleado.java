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

import Logica.Aplicacion;
import Logica.Cliente;
import Logica.Empleado;

public class VEmpleado extends JFrame {
	JButton entregarCarro;
	VEntregarCarro vEntregarCarro;
	VCambiarDisponibilidad vCambiarDisponibilidad;
	JButton devolverCarro;
	JButton CambiarDisponibilidad;
	VDevolverCarro vDevolverCarro;
    JButton Regresar;
	public VEmpleado(VLogIn vlogin, Empleado emp, Aplicacion app ) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		VEmpleado this_temp = this;
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

        entregarCarro = new JButton("entregar Carro");
        entregarCarro.setBackground(new Color(65, 105, 225));
        entregarCarro.setForeground(Color.WHITE);
        entregarCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vEntregarCarro = new VEntregarCarro(this_temp, emp, app);
                setVisible(false);
                vEntregarCarro.setVisible(true);
            }
        });
        
        devolverCarro = new JButton("devolver Carro");
        devolverCarro.setBackground(new Color(65, 105, 225));
        devolverCarro.setForeground(Color.WHITE);
        devolverCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vDevolverCarro = new VDevolverCarro(this_temp, emp, app);
                setVisible(false);
                vDevolverCarro.setVisible(true);
            }
        });
        
        CambiarDisponibilidad = new JButton("Cambiar Disponibilidad");
        CambiarDisponibilidad.setBackground(new Color(65, 105, 225));
        CambiarDisponibilidad.setForeground(Color.WHITE);
        CambiarDisponibilidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vCambiarDisponibilidad = new VCambiarDisponibilidad(this_temp, emp, app);
                setVisible(false);
                vCambiarDisponibilidad.setVisible(true);
            }
        });
        
        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        
        buttonPanel.add(entregarCarro);
        buttonPanel.add(devolverCarro);
        buttonPanel.add(CambiarDisponibilidad);
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
