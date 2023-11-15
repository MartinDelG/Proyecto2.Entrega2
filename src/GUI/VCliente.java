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

import Logica.AdminGeneral;
import Logica.Aplicacion;
import Logica.Cliente;

public class VCliente extends JFrame {
	JButton crearReserva;
    VCrearReserva vCrearReserva;
    JButton consultarDispo;
    VconsultarDispo vconsultarDispo;
    JButton Regresar;
    
    public VCliente(VLogIn vlogin, Cliente cliente, Aplicacion app ) {
        setLayout(new BorderLayout());
        VCliente this_temp = this;
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
        JPanel buttonPanel = new JPanel(new GridLayout(5,1 , 10, 10));
        add(buttonPanel, BorderLayout.CENTER);
        
        
        
       
        crearReserva = new JButton("CrearReserva");
        crearReserva.setBackground(new Color(65, 105, 225));
        crearReserva.setForeground(Color.WHITE);
        crearReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vCrearReserva = new VCrearReserva(this_temp, cliente, app);
                setVisible(false);
                vCrearReserva.setVisible(true);
            }
        });
        
        consultarDispo = new JButton("mostrar Disponibilidad sede");
        consultarDispo.setBackground(new Color(65, 105, 225));
        consultarDispo.setForeground(Color.WHITE);
        consultarDispo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vconsultarDispo = new VconsultarDispo(this_temp, cliente, app);
                setVisible(false);
                vconsultarDispo.setVisible(true);
            }
        });
        
        
        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(consultarDispo);
        buttonPanel.add(crearReserva);
    
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
        
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        //buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
