package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.AdminGeneral;
import Logica.AdminLocal;
import Logica.Aplicacion;
import Logica.Cliente;
import Logica.Empleado;
import consola.Consola;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VLogIn extends JFrame {
	
	private Aplicacion app = new Aplicacion(); 
    private JTextField usernameField;
    private JPasswordField passwordField;
    private VAdminGeneral vAdminGeneral;
    private VAdminLoc vAdminLoc;
    private VCliente vCliente;
    private VEmpleado vEmpleado;
    public VLogIn() {
    	//this.vAdminGeneral = new VAdminGeneral(this, app);
        setTitle("APP RESERVAS");

        usernameField = new JTextField(20);
        // usernameField.setPreferredSize(new Dimension(15,this.getWidth()));
        //usernameField.setBorder(new EmptyBorder(0, 0, 0, 20));
        passwordField = new JPasswordField(20);
        //passwordField.setBorder(new EmptyBorder(0, 0, 0, 20));
        this.setLayout(new BorderLayout());
        JLabel usernameLabel = new JLabel("USUARIO:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel passwordLabel = new JLabel("CONTRASENIA:");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JButton loginButton = new JButton("LogIn");
        loginButton.setBackground(new Color(65, 105, 225));
        loginButton.setForeground(Color.WHITE);
        VLogIn temp = this;
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (verificarUser(username, password)==1) {
                	AdminGeneral admin = app.getAdmin(username);
                	setVisible(false);
                	vAdminGeneral = new VAdminGeneral(temp, admin, app);
                	vAdminGeneral.setVisible(true);
                	
                }
                else if (verificarUser(username, password)==2) {
                	AdminLocal admin = app.getAdminloc(username);
                	setVisible(false);
                	vAdminLoc = new VAdminLoc(temp, admin, app);
                	vAdminLoc.setVisible(true);
                }
                else if (verificarUser(username, password)==3) {
                	Empleado admin = app.getEmpleado(username);
                	setVisible(false);
                	vEmpleado = new VEmpleado(temp, admin, app);
                	vEmpleado.setVisible(true);
                }
                else if (verificarUser(username, password)==4) {
                	Cliente admin = app.getCliente(username);
                	setVisible(false);
                	vCliente = new VCliente(temp, admin, app);
                	vCliente.setVisible(true);
                }
                
                else {
                	 //JOptionPane d =new JOptionPane();
                	 JOptionPane.showMessageDialog(null, "CONTRASENIA O USUARIO INCORRECTOS", "Error",JOptionPane.WARNING_MESSAGE);
                	 /*
                	d.setModal(true);
                	d.add(lab);
                	d.setSize(300, 150);
                    d.setLocationRelativeTo(null); 
                	d.setVisible(true);*/
                }
            }
        });

       
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 20));
        //panel.add(Box.createRigidArea(new Dimension(0,15)));
        //panel.add(Box.createRigidArea(new Dimension(0,15)));
        //panel.add(Box.createRigidArea(new Dimension(0,15)));
        //panel.add(Box.createRigidArea(new Dimension(0,15)));
        //panel.add(Box.createRigidArea(new Dimension(0,15)));
        
        panel.add(Box.createRigidArea(new Dimension(0,15)));
        panel.add(Box.createRigidArea(new Dimension(0,15)));
        
        panel.add(usernameLabel);
        panel.add(usernameField);
        
        
        
        panel.add(passwordLabel);
        panel.add(passwordField);
        
        panel.add(Box.createRigidArea(new Dimension(0,15)));
        panel.add(loginButton);
        
        panel.add(new JLabel()); 
        panel.add(Box.createRigidArea(new Dimension(0,15)));
         
        //panel.add(Box.createRigidArea(new Dimension(0,15)));
       // panel.add(Box.createRigidArea(new Dimension(0,15)));
        //setLayout(new FlowLayout());

        JPanel arriba = new JPanel();
        arriba.setBackground(new Color(65, 105, 225));
        arriba.add(Box.createRigidArea(new Dimension(0,15)));
        JPanel abajo = new JPanel();
        abajo.setBackground(new Color(65, 105, 225));
        abajo.add(Box.createRigidArea(new Dimension(0,15)));
        
        JPanel izq = new JPanel();
        izq.add(Box.createRigidArea(new Dimension(25,0)));
        JPanel der = new JPanel();
        der.add(Box.createRigidArea(new Dimension(15,0)));
        
        this.add(arriba, BorderLayout.NORTH);
        this.add(abajo, BorderLayout.SOUTH);
        this.add(panel,BorderLayout.CENTER);
        this.add(der, BorderLayout.EAST);
        this.add(izq, BorderLayout.WEST);
        //panel.setBackground();
       
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    public Integer verificarUser(String username, String password) {
    	return this.app.verificarUsuario(username, password);
    }

    
	public static void main(String[] args) {
		VLogIn vLogIn = new VLogIn();
		vLogIn.app.cargarAdminGeneral("Datattt/adminGeneral.txt");
		vLogIn.app.cargarAdminsLocales("Datattt/AdminLocal.txt");
		vLogIn.app.cargarCategorias("Datattt/Categorias.txt");
		vLogIn.app.cargarClientes("Datattt/Clientes.txt");
		vLogIn.app.cargarEmpleados("Datattt/Empleados.txt");
		vLogIn.app.cargarSedes("Datattt/Sedes.txt");
		vLogIn.app.cargarSeguro("Datattt/Seguros.txt");
		vLogIn.app.cargarVehiculos("Datattt/Vehiculos.txt");
		vLogIn.app.cargarTemporada("Datattt/temp.txt");
		vLogIn.app.cargarReservas("Datattt/reservas.txt");
		//vLogIn.ejecutarAplicacion();	 
	}
}