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

public class VAdminGeneral extends JFrame {
	VLogIn vlogin;
    JButton eliminarCarro;
    VEliminarVehiculo vEliminarVehiculo;
    VElimiarSeguro  vElimiarSeguro;
    VNuevoSeguro vNuevoSeguro;
    VEditarSeguro vEditarSeguro;
    VNuevoCarro vNuevoCarro;
    VCambiarHorario vCambiarHorario;
    VCambiarTemporada vCambiarTemporada;
    VCrearLog vCrearLog;
    JButton NuevoCarro;
    JButton eliminarSeguro;
    JButton NuevoSeguro;
    JButton EditarSeguro;
    JButton CambiarHorario;
    JButton CambiarTemporada;
    JButton CrearLog;
    JButton Regresar;

    public VAdminGeneral(VLogIn vlogin, AdminGeneral admin, Aplicacion app ) {
        setLayout(new BorderLayout());
        this.vlogin = vlogin;
        VAdminGeneral this_temp = this;
        //vEliminarVehiculo = new VEliminarVehiculo(this_temp, admin, app);
        //vElimiarSeguro = new VElimiarSeguro(this_temp, admin, app);
        //vNuevoSeguro = new VNuevoSeguro(this_temp, admin, app);
        //vEditarSeguro = new VEditarSeguro(this_temp, admin, app);
        //vNuevoCarro = new VNuevoCarro(this_temp, admin, app);
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
        JPanel buttonPanel = new JPanel(new GridLayout(5, 3, 10, 10));
        add(buttonPanel, BorderLayout.CENTER);

        eliminarCarro = new JButton("Eliminar Carro");
        eliminarCarro.setBackground(new Color(65, 105, 225));
        eliminarCarro.setForeground(Color.WHITE);
        eliminarCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vEliminarVehiculo = new VEliminarVehiculo(this_temp, admin, app);
                setVisible(false);
                vEliminarVehiculo.setVisible(true);
            }
        });
        
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        
        buttonPanel.add(eliminarCarro);

        NuevoCarro = new JButton("NuevoCarro");
        buttonPanel.add(NuevoCarro);
        NuevoCarro.setBackground(new Color(65, 105, 225));
        NuevoCarro.setForeground(Color.WHITE);
        NuevoCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vNuevoCarro = new VNuevoCarro(this_temp, admin, app);
                setVisible(false);
                vNuevoCarro.setVisible(true);
            }
        });
        
        eliminarSeguro = new JButton("Eliminar Seguro");
        buttonPanel.add(eliminarSeguro);
        eliminarSeguro.setBackground(new Color(65, 105, 225));
        eliminarSeguro.setForeground(Color.WHITE);
        eliminarSeguro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vElimiarSeguro = new VElimiarSeguro(this_temp, admin, app);
                setVisible(false);
                vElimiarSeguro.setVisible(true);
            }
        });

        NuevoSeguro = new JButton("NuevoSeguro");
        buttonPanel.add(NuevoSeguro);
        NuevoSeguro.setBackground(new Color(65, 105, 225));
        NuevoSeguro.setForeground(Color.WHITE);
        NuevoSeguro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vNuevoSeguro = new VNuevoSeguro(this_temp, admin, app);
                setVisible(false);
                vNuevoSeguro.setVisible(true);
            }
        });

        EditarSeguro = new JButton("Ediatar Seguro");
        buttonPanel.add(EditarSeguro);
        EditarSeguro.setBackground(new Color(65, 105, 225));
        EditarSeguro.setForeground(Color.WHITE);
        EditarSeguro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vEditarSeguro = new VEditarSeguro(this_temp, admin, app);
                setVisible(false);
                vEditarSeguro.setVisible(true);
            }
        });

        CambiarHorario = new JButton("Cambiar Horario");
        buttonPanel.add(CambiarHorario);
        CambiarHorario.setBackground(new Color(65, 105, 225));
        CambiarHorario.setForeground(Color.WHITE);
        CambiarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vCambiarHorario = new VCambiarHorario(this_temp, admin, app);
                setVisible(false);
                vCambiarHorario.setVisible(true);
            }
        });

        CambiarTemporada = new JButton("CambiarTemporada");
        buttonPanel.add(CambiarTemporada);
        CambiarTemporada.setBackground(new Color(65, 105, 225));
        CambiarTemporada.setForeground(Color.WHITE);
        CambiarTemporada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vCambiarTemporada = new VCambiarTemporada(this_temp, admin, app);
                setVisible(false);
                vCambiarTemporada.setVisible(true);
            }
        });
        CrearLog = new JButton("Crear Log");
        buttonPanel.add(CrearLog);
        CrearLog.setBackground(new Color(65, 105, 225));
        CrearLog.setForeground(Color.WHITE);
        CrearLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	vCrearLog = new VCrearLog(this_temp, admin, app);
                setVisible(false);
                vCrearLog.setVisible(true);
            }
        });

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
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        buttonPanel.add(Box.createRigidArea(new Dimension(0,15)));
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }

}