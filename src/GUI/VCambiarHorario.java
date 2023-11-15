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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.AdminGeneral;
import Logica.Aplicacion;

public class VCambiarHorario extends JFrame {
	
	private JButton cambiarHorario;
	private JButton regresar;
	private JTextField horarioAperturaOCierre;
	private JTextField nuevoHorario;
	
	public VCambiarHorario(VAdminGeneral VadminGeneral, AdminGeneral admin, Aplicacion app) {
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
        
        JLabel label1 = new JLabel("Ingrese la sede a la que le desea cambiar el horario: ");
        JComboBox<String> comboBox = new JComboBox<>(app.getSedes().keySet().toArray(new String[0]));
		JLabel label2 = new JLabel("Ingrese 0 si desea cambiar la hora de apertura 1 hora de cierre: ");
        horarioAperturaOCierre = new JTextField();
        JLabel label3 = new JLabel ("Ingrese la nueva hora (hh:mm:ss)");
        nuevoHorario = new JTextField();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2, 10, 10));
	    cambiarHorario = new JButton("Cambiar Horario");
	    cambiarHorario.setBackground(new Color(65, 105, 225));
	    cambiarHorario.setForeground(Color.WHITE);
	    cambiarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
        		try {
        			String sede = (String)comboBox.getSelectedItem();
        			System.out.println(sede);
        			int cambiar = Integer.parseInt(horarioAperturaOCierre.getText());
        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        			LocalTime hora = LocalTime.parse(nuevoHorario.getText(), formatter);
        			admin.CambiarHorariosSedes(app,sede,cambiar,hora);
        			
        			JOptionPane.showMessageDialog(null, "SE HA CAMBIADO EL HORARIO DE LA SEDE "+sede , "CAMBIADO",JOptionPane.INFORMATION_MESSAGE);
        		} catch (Exception a) {
        			 a.printStackTrace();
        			JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR, REVISE LOS HORARIOS", "ERROR",JOptionPane.ERROR_MESSAGE);
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
	    panel.add(label2);
	    panel.add(horarioAperturaOCierre);
	    panel.add(label3);
	    panel.add(nuevoHorario);
	    panel.add(regresar);
	    panel.add(cambiarHorario);
	    add(panel);
	    
       
        setSize(850, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(false);
	}

}

