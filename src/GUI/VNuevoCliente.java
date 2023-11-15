package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.AdminGeneral;
import Logica.AdminLocal;
import Logica.Aplicacion;

public class VNuevoCliente extends JFrame {
	private JButton NuevoEmpleado;
	private JButton regresar;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField fechaNacimiento;
	private JTextField nacionalidad;
	private JTextField login;
	private JTextField password;
	private JTextField numero;
	private JTextField cvv;
	private JTextField id_licencia;
	private JTextField pais;
	private JTextField fechaVencimiento;
	private JTextField foto;
	private JTextField tel;
	public VNuevoCliente(VAdminLoc vAdminLoc, AdminLocal admin, Aplicacion app) {
		setLayout(new BorderLayout());
		
		JLabel IDLabel = new JLabel("Ingrese los datos del nuevo Cliente: ");
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
		panel.setLayout(new GridLayout(14, 2, 10, 10));
		nombre = new JTextField();
		apellido = new JTextField();
		nacionalidad = new JTextField();
		login = new JTextField();
		password = new JTextField();
		fechaNacimiento = new JTextField();
		numero = new JTextField();
		cvv = new JTextField();
		id_licencia = new JTextField();
		pais = new JTextField();
		fechaVencimiento = new JTextField();
		foto = new JTextField();
		tel = new JTextField();
	    //panel.add(idEliminarCarro);
		NuevoEmpleado = new JButton("Crear Cliente");
		NuevoEmpleado.setBackground(new Color(65, 105, 225));
		NuevoEmpleado.setForeground(Color.WHITE);
		NuevoEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			String Fnombre = nombre.getText();
        			String Fapellido = apellido.getText();
        			String Fnacionalidad = nacionalidad.getText();
        			String Flogin = login.getText();
        			String Fpassword = password.getText();
        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        			LocalDate FfechaNacimiento = LocalDate.parse(fechaNacimiento.getText(),formatter);
        			String Fnumero = numero.getText();
        			String Fcvv = cvv.getText();
        			String Fid_licencia = id_licencia.getText();
        			String Fpais = pais.getText();
        			LocalDate FfechaVencimiento = LocalDate.parse(fechaVencimiento.getText(),formatter);
        			String Ffoto = foto.getText();
        			String Ftel = tel.getText();
        			
        			
        			
        			admin.agregarCliente(app, Fnombre, Fapellido, FfechaNacimiento, Fnacionalidad, Flogin, Fpassword, Fnumero, Fcvv, Fid_licencia, Fpais, FfechaVencimiento, Ffoto, Ftel);
        			
        			JOptionPane.showMessageDialog(null, "SE HA CREADO EXITOSAMENTE UN NUEVO EMPLEADO", "CREADO",JOptionPane.INFORMATION_MESSAGE);
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR CREANDO EL EMPLEADO", "ERROR",JOptionPane.ERROR_MESSAGE);
        		}
            }

        });
	    regresar = new JButton("Regresar");
	    regresar.setBackground(new Color(65, 105, 225));
	    regresar.setForeground(Color.WHITE);
	    regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vAdminLoc.setVisible(true);
        		dispose();
        		
            }

        });
	    JLabel Lplaca = new JLabel("nombe: ");
	    panel.add(Lplaca);
	    panel.add(nombre);
	    
	    JLabel Lmarca = new JLabel("apellido: ");
	    panel.add(Lmarca);
	    panel.add(apellido);
	    
	    JLabel LModelo = new JLabel("fecha nacimineto (aaaa-mm-dd): ");
	    panel.add(LModelo);
	    panel.add(fechaNacimiento);
	    
	    JLabel Lcolor = new JLabel("nacionalidad: ");
	    panel.add(Lcolor);
	    panel.add(nacionalidad);
	    
	    JLabel Lprecio = new JLabel("login: ");
	    panel.add(Lprecio);
	    panel.add(login);
	    
	    JLabel Ltransmision = new JLabel("password: ");
	    panel.add(Ltransmision);
	    panel.add(password);
	    
	    JLabel Lplaca1 = new JLabel("NUMERO: ");
	    panel.add(Lplaca1);
	    panel.add(numero);
	    
	    JLabel Lmarca1 = new JLabel("CVV: ");
	    panel.add(Lmarca1);
	    panel.add(cvv);
	    
	    JLabel LModelo1 = new JLabel("ID LICENCIA: ");
	    panel.add(LModelo1);
	    panel.add(id_licencia);
	    
	    JLabel Lcolor1 = new JLabel("pais: ");
	    panel.add(Lcolor1);
	    panel.add(pais);
	    
	    JLabel Lprecio1 = new JLabel("fechaVencimiento: ");
	    panel.add(Lprecio1);
	    panel.add(fechaVencimiento);
	    
	    JLabel Ltransmision1 = new JLabel("foto: ");
	    panel.add(Ltransmision1);
	    panel.add(foto);

	    JLabel Ltransmision2 = new JLabel("tel: ");
	    panel.add(Ltransmision2);
	    panel.add(tel);
	    
	    //panel.add(Box.createRigidArea(new Dimension(0,15)));
	    panel.add(NuevoEmpleado);
	    //panel.add(Box.createRigidArea(new Dimension(0,15)));
	    panel.add(regresar);
	    
	    add(panel);
	    
       
        setSize(350, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}	


}
