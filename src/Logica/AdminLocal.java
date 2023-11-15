package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminLocal extends Persona {

	//Atributos
	private boolean activo;
	private String sede;
	
	
	//Metodos
	public AdminLocal(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String login,
			String password, boolean activo, String sede) {
		super(nombre, apellido, fechaNacimiento, nacionalidad, login, password);
		this.activo = activo;
		this.sede = sede;
	}
	
	public void agregarEmpleado(Aplicacion app,String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String login,
			String password) {
			HashMap<String,Empleado> emps = app.getEmpleados();
			Empleado emp = new Empleado(nombre, apellido, fechaNacimiento, nacionalidad, login, password, true, this.sede);
		    emps.put(login, emp);
		    HashMap<String,Sede> sedes = app.getSedes();
		    Sede sedeAgregar = sedes.get(this.sede);
		    ArrayList<String> empleadosSede = sedeAgregar.getEmpleados();
		    empleadosSede.add(login);
		    sedeAgregar.setEmpleados(empleadosSede);
		    System.out.println("Se agrego con exito el nuevo empleado");
		    String textoAAgregar = "\n"+nombre+";"+apellido+";"+fechaNacimiento.toString()+";"+nacionalidad+";"+login+";"+password+";"+true+";"+this.sede;
		    
		    try {
	            
	            FileWriter fileWriter = new FileWriter("Datattt/Empleados.txt", true);

	            
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            
	            bufferedWriter.write(textoAAgregar);
	            //bufferedWriter.newLine(); 
	            bufferedWriter.close();
	            fileWriter.close();

	            System.out.println("Peristencia Actualizada");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		    
			String lienaCambiar = "nada";
			String linea="";
			String nombreSede="";
			String horaCierre="";
			String horaAbrir="";
			String empleados="";
			String admin="";
			String carros="";
		 	try {
				BufferedReader br = new BufferedReader(new FileReader("Datattt/Sedes.txt"));
				
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
	                //System.out.println("adentro2.7");
					nombreSede = partes[0].trim();
	                if (this.sede.equals(nombreSede)) {
						lienaCambiar = linea;
						horaAbrir = partes[1].trim();
						horaCierre = partes[2].trim();
						empleados = partes[3].trim();
						
						admin = partes[4].trim();
						carros = partes[5].trim();
		              
						break;}
				}
				//System.out.println(lienaAEliminar);
				br.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error ubicando linea a cambiar");
			}
		 	String NuevoTexto = nombre+";"+horaAbrir+";"+horaCierre+";"+empleados+","+login+";"+admin+";"+carros+",";
		 	ArrayList<String> lineas = new ArrayList<>();
		 	try {
	            BufferedReader br = new BufferedReader(new FileReader("Datattt/Sedes.txt"));
	            String linea2;
	            while ((linea2 = br.readLine()) != null) {
	                if (!linea2.equals(lienaCambiar)) {
	                    lineas.add(linea2);
	                  
	                }
	                else {
	                	lineas.add(NuevoTexto);
	                }
	                
	            }
	            br.close();

	            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Sedes.txt")); 
	            int cont = 1;
	            for (String updatedLine : lineas) {
	            	if (cont != lineas.size()) {
	                bw.write(updatedLine);
	                bw.newLine();
	                cont++;}
	            	else {
	            	bw.write(updatedLine);
	            	}
	            }
	            bw.close();

	            System.out.println("Peristencia Actualizada");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		}
	public void agregarCliente(Aplicacion app,String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String login,
			String password,String numero,String cvv,String id_licencia,String pais,LocalDate fechaVencimiento,String foto,String tel  ) {
			HashMap<String,Cliente> client = app.getClientes();
			MedioPago med= new MedioPago(numero, true, cvv );
			Licencia lis = new Licencia(id_licencia, pais, fechaVencimiento, foto );
			Cliente emp = new Cliente(nombre, apellido, fechaNacimiento, nacionalidad, login, password, med , lis, tel);
			client.put(login, emp);
		    String textoAAgregar = "\n"+nombre+";"+apellido+";"+fechaNacimiento.toString()+";"+nacionalidad+";"+login+";"+password+";"+numero+","+"True,"+cvv+";"+id_licencia+","+pais+","+fechaVencimiento.toString()+","+foto+";"+tel;
		    
		    try {
	            
	            FileWriter fileWriter = new FileWriter("Datattt/Clientes.txt", true);

	            
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            
	            bufferedWriter.write(textoAAgregar);
	            //bufferedWriter.newLine(); 
	            bufferedWriter.close();
	            fileWriter.close();

	            System.out.println("Peristencia Actualizada");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		    
			
	}
}
