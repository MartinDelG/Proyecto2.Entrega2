package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
import Logica.Cliente;

public class VCrearReserva extends JFrame {
	
	private JButton crearReserva;
	private JButton regresar;
	private JTextField categoria;
	private JTextField sedeRec;
	private JTextField sedeRet;
	private JTextField fechaRec;
	private JTextField fechaRet;
	private JTextField horaRet;
	private JTextField seguro;
	private JTextField conducAdicionales;
	
	public VCrearReserva(VCliente Vcliente, Cliente cliente, Aplicacion app) {
		setLayout(new BorderLayout());
		
		JPanel arriba = new JPanel();
        arriba.setBackground(new Color(65, 105, 225));
        //arriba.add(IDLabel);
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
        
        
        
    	
    	
        JLabel label1 = new JLabel("Ingrese la categoria que desea reservar: ");
        categoria = new JTextField();
		JLabel label2 = new JLabel("Ingrese la sede donde va a reclamar el vehiculo: ");
        sedeRec = new JTextField();
        JLabel label3 = new JLabel ("Ingrese la sede donde va a regresar el vehiculo: ");
        sedeRet = new JTextField();
        JLabel label4 = new JLabel ("Ingrese la fecha en la que desea reclamar el vehiculo (en formato yyyy-MM-dd: ");
        fechaRec = new JTextField();
        JLabel label5 = new JLabel ("Ingrese la fecha en la que desea retornar el vehiculo (en formato yyyy-MM-dd: ");
        fechaRet = new JTextField();
        JLabel label6 = new JLabel ("Ingrese la hora en la que desea retornar su vehiculo(en formato hh:mm:ss: ");
        horaRet = new JTextField();
        JLabel label7 = new JLabel ("Ingrese el nombre de los seguros que desea tener \n separados por una coma(no ingrese nada si no quiere seguros): ");
        seguro = new JTextField();
        JLabel label8 = new JLabel ("Ingrese el logIn de los conductores adicionales \n separados por una coma(no ingrese nada si no requiere conductores adicionales: ");
        conducAdicionales = new JTextField();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 2, 5, 5));
	    crearReserva = new JButton("Crear Reserva");
	    crearReserva.setBackground(new Color(65, 105, 225));
	    crearReserva.setForeground(Color.WHITE);
	    crearReserva.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			String cat = categoria.getText();
        			String sedeReclamo = sedeRec.getText();
        			String sedeRetorno = sedeRet.getText();
        			String fechaReclamo = fechaRec.getText();
        			String fechaRetorno = fechaRet.getText();
        			String horaRetorno = horaRet.getText();
        			String seg = seguro.getText();
        			String conducAd = conducAdicionales.getText();
        			if (cliente.crearReserva(app, cat, sedeReclamo, sedeRetorno, fechaReclamo,fechaRetorno, horaRetorno,seg,conducAd) == false) {
        				JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR, NO HAY CARROS DISPONIBLES", "ERROR",JOptionPane.INFORMATION_MESSAGE);}
        			else {
        			cliente.crearReserva(app, cat, sedeReclamo, sedeRetorno, fechaReclamo,fechaRetorno, horaRetorno,seg,conducAd) ;
        			JOptionPane.showMessageDialog(null, "SE HA CREADO LA RESERVA", "CREADA",JOptionPane.INFORMATION_MESSAGE);
        			}
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR, REVISE LOS DATOS", "ERROR",JOptionPane.ERROR_MESSAGE);
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
	    
	    panel.add(label1);
	    panel.add(categoria);
	    panel.add(label2);
	    panel.add(sedeRec);
	    panel.add(label3);
	    panel.add(sedeRet);
	    panel.add(label4);
	    panel.add(fechaRec);
	    panel.add(label5);
	    panel.add(fechaRet);
	    panel.add(label6);
	    panel.add(horaRet);
	    panel.add(label7);
	    panel.add(seguro);
	    panel.add(label8);
	    panel.add(conducAdicionales);
	    panel.add(regresar);
	    panel.add(crearReserva);
	    add(panel);
	    
       
        setSize(1200, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}

}
	
	
	
