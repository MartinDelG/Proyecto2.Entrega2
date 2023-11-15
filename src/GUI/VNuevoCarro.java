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

public class VNuevoCarro extends JFrame {
	private JButton NuevoCarro;
	private JButton regresar;
	private JTextField placa;
	private JTextField marca;
	private JTextField modelo;
	private JTextField color;
	private JComboBox<String> transmicion;
	private JTextField precio;
	private JComboBox<String> categoria;
	private JComboBox<String> sede;
	public VNuevoCarro(VAdminGeneral VadminGeneral, AdminGeneral admin, Aplicacion app) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		JLabel IDLabel = new JLabel("Ingrese los datos del nuevo Carro: ");
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
		panel.setLayout(new GridLayout(5, 4, 10, 10));
		placa = new JTextField();
		marca = new JTextField();
		modelo = new JTextField();
		color = new JTextField();
		precio = new JTextField();
		String[] comboBoxOptiones = {"automatica", "mecanica"};
		transmicion = new JComboBox<>(comboBoxOptiones);
		categoria = new JComboBox<>(app.getCategorias().keySet().toArray(new String[0]));
		sede = new JComboBox<>(app.getSedes().keySet().toArray(new String[0]));
	    //panel.add(idEliminarCarro);
		NuevoCarro = new JButton("Crear Carro");
		NuevoCarro.setBackground(new Color(65, 105, 225));
		NuevoCarro.setForeground(Color.WHITE);
		NuevoCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			String placaM = placa.getText();
        			String marcaM = marca.getText();
        			String modeloM = modelo.getText();
        			String colorM = color.getText();
        			String precioM = precio.getText();
        			String transmicionM = (String)transmicion.getSelectedItem();
        			String categoriaM = (String)categoria.getSelectedItem();
        			String sedeM = (String)sede.getSelectedItem();
        			
        			admin.agregarVehículo(app, placaM, marcaM, modeloM, colorM, transmicionM, precioM, categoriaM, sedeM);
        			
        			JOptionPane.showMessageDialog(null, "SE HA CREADO EXITOSAMENTE UN NUEVO VEHICULO", "CREADO",JOptionPane.INFORMATION_MESSAGE);
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR CREANDO EL VEHICULO", "ERROR",JOptionPane.ERROR_MESSAGE);
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
	    JLabel Lplaca = new JLabel("Placa: ");
	    panel.add(Lplaca);
	    panel.add(placa);
	    
	    JLabel Lmarca = new JLabel("Marca: ");
	    panel.add(Lmarca);
	    panel.add(marca);
	    
	    JLabel LModelo = new JLabel("Modelo: ");
	    panel.add(LModelo);
	    panel.add(modelo);
	    
	    JLabel Lcolor = new JLabel("color: ");
	    panel.add(Lcolor);
	    panel.add(color);
	    
	    JLabel Lprecio = new JLabel("precio: ");
	    panel.add(Lprecio);
	    panel.add(precio);
	    
	    JLabel Ltransmision = new JLabel("Transmision: ");
	    panel.add(Ltransmision);
	    panel.add(transmicion);
	    
	    JLabel Lcategoria = new JLabel("categoria: ");
	    panel.add(Lcategoria);
	    panel.add(categoria);
	    
	    JLabel Lsede = new JLabel("sede: ");
	    panel.add(Lsede);
	    panel.add(sede);
		
	    panel.add(Box.createRigidArea(new Dimension(0,15)));
	    panel.add(NuevoCarro);
	    panel.add(Box.createRigidArea(new Dimension(0,15)));
	    panel.add(regresar);
	    
	    add(panel);
	    
       
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}	


}
