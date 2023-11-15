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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Aplicacion;
import Logica.Empleado;

public class VCambiarDisponibilidad extends JFrame {
	private JButton eliminarCarro;
	private JTextField TnumDias;
	private JTextField fechaInicio;
	private JButton regresar;
	private JComboBox<String> comboBox;
	public VCambiarDisponibilidad(VEmpleado vEmpleado, Empleado emp, Aplicacion app) {
		// TODO Auto-generated constructor stub
setLayout(new BorderLayout());
		
		JLabel IDLabel = new JLabel("Ingrese la ID del carro a cambiar Disponibilidad: ");
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
		
        comboBox = new JComboBox<>(app.getInventario().keySet().toArray(new String[0]));
        JLabel fecha = new JLabel("Ingrese la ID fecha a cambiar Disponibilidad: ");
        JLabel id_car = new JLabel("Ingrese la ID del vehiculo a Disponibilidad: ");
        fechaInicio = new JTextField();
        JLabel dias = new JLabel("Ingrese el numero de dias a cambiar Disponibilidad: ");
        TnumDias = new JTextField();
        
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2, 10, 10));
	    //panel.add(idEliminarCarro);
	    eliminarCarro = new JButton("Cambiar disp");
	    eliminarCarro.setBackground(new Color(65, 105, 225));
        eliminarCarro.setForeground(Color.WHITE);
	    eliminarCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			String idELim = (String)comboBox.getSelectedItem();
        			int numDias =  Integer.parseInt(TnumDias.getText());
        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        			LocalDate fechadisp = LocalDate.parse(fechaInicio.getText());
        			System.out.println(idELim);
        			emp.modificarDisponiblidad(app, idELim, numDias, fechadisp);
        			
        			JOptionPane.showMessageDialog(null, "EL VEHICULO CON ID "+idELim+" CAMBIO SU DISPONIBILIDAD", "ELIMINADO",JOptionPane.INFORMATION_MESSAGE);
        			comboBox.removeItem(idELim);
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
            	vEmpleado.setVisible(true);
        		dispose();
        		
            }

        });
	    panel.add(fecha);
	    panel.add(fechaInicio);
	    panel.add(dias);
	    panel.add(TnumDias);
	    panel.add(id_car);
	    panel.add(comboBox);
	    panel.add(eliminarCarro);
	    panel.add(regresar);
	    add(panel);
	    
       
        setSize(700, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}

}

