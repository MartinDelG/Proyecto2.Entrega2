package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;


public class Empleado extends Persona {

	//Atributos
	private boolean activo;
	private String sede;

	
	//Metodos
	public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String login,
			String password, boolean activo, String sede) {
		super(nombre, apellido, fechaNacimiento, nacionalidad, login, password);
		this.activo = activo;
		this.sede = sede;
	}
	
	public void modificarDisponiblidad(Aplicacion aplicacion, String id, int diasNoDisponible, LocalDate inicioNoDisp) {
		HashMap<String,Vehiculo> vehiculos =aplicacion.getInventario();
		int diaInicio = (int)(ChronoUnit.DAYS.between(LocalDate.parse("2023-10-16"), inicioNoDisp));
		Vehiculo vehiculo = vehiculos.get(id);
		ArrayList<Integer>disp=vehiculo.getDisponibilidad();
		for(int i=diaInicio;i<=diasNoDisponible+diaInicio;i++) {disp.set(i, 1);}
		vehiculo.setDisponibilidad(disp);
		
		String lienaCambiar = "nada";
		String id_car="";
		String placa="";
		String marca="";
		String modelo="";
		String  color="";
		String tipoTransmision="";
		String precio="";
		String categoria="";
		String sedeActual="";
		String clienteActual="";
		String disponibilidad="";
		String disponibilidad2="";
		String disponibilidad3="";
	 	try {
			BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
			String linea;
			//System.out.println("adentro1");
			while((linea=br.readLine()) != null) {
				String[] partes = linea.split(";");
                //System.out.println("adentro2.7");
                id_car = partes[0].trim();
                if (id.equals(id_car)) {
					lienaCambiar = linea;
					 placa = partes[1].trim();
					
					 marca = partes[2].trim();
					 modelo = partes[3].trim();
					 color = partes[4].trim();
					 tipoTransmision = partes[5].trim();
					 precio = partes[6].trim();
					 categoria = partes[7].trim();
					 sedeActual = partes[8].trim();
					 clienteActual = partes[9].trim();
			        for (Integer element : disp) {

			        	disponibilidad = disponibilidad+","+Integer.toString(element);
			            }
			        
			        disponibilidad2 = disponibilidad.substring(0, disponibilidad.length() - 1);
			        disponibilidad3 = disponibilidad2.substring(1, disponibilidad2.length());
					break;}
			}
			//System.out.println(lienaAEliminar);
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error ubicando linea a cambiar");
		}
	 	String NuevoTexto = id_car+";"+placa+";"+marca+";"+modelo+";"+color+";"+tipoTransmision+";"+precio+";"+categoria+";"+sedeActual+";"+clienteActual+";"+disponibilidad2;
	 	ArrayList<String> lineas3 = new ArrayList<>();
	 	try {
            BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
            String linea2;
            while ((linea2 = br.readLine()) != null) {
                if (!linea2.equals(lienaCambiar)) {
                	lineas3.add(linea2);
                  
                }
                else {
                	lineas3.add(NuevoTexto);
                }
                
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Vehiculos.txt")); 
            int cont = 1;
            for (String updatedLine : lineas3) {
            	if (cont != lineas3.size()) {
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
	
	public void retornarVehiculo(Aplicacion aplicacion, String id) {
		HashMap<String,Reserva> res = aplicacion.getReservas();
		String id_vel = res.get(id).getVehiculoAsignado();
		String id_client = res.get(id).getCliente();
		
		HashMap<String,Vehiculo> vehiculos =aplicacion.getInventario();
		Vehiculo vehiculo = vehiculos.get(id_vel);
		vehiculo.setClienteActual("0");
		vehiculo.setSedeActual(this.sede);
		
		HashMap<String,Cliente> clientes =aplicacion.getClientes();
		Cliente clm = clientes.get(id_client);
		clm.getMediosPago().setEstadoTarjeta(true);
		
		//persistencia vehiculo
		String lienaCambiar = "nada";
		String id_car="";
		String placa="";
		String marca="";
		String modelo="";
		String  color="";
		String tipoTransmision="";
		String precio="";
		String categoria="";
		String sedeActual="";
		String clienteActual="";
		String disponibilidad="";
	 	try {
			BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
			String linea;
			//System.out.println("adentro1");
			while((linea=br.readLine()) != null) {
				String[] partes = linea.split(";");
                //System.out.println("adentro2.7");
                id_car = partes[0].trim();
                if (id_vel.equals(id_car)) {
					lienaCambiar = linea;
					 placa = partes[1].trim();
					
					 marca = partes[2].trim();
					 modelo = partes[3].trim();
					 color = partes[4].trim();
					 tipoTransmision = partes[5].trim();
					 precio = partes[6].trim();
					 categoria = partes[7].trim();
					 sedeActual = partes[8].trim();
					 clienteActual = partes[9].trim();
					 disponibilidad = partes[10].trim();
					 break;}
			//System.out.println(lienaAEliminar);
			br.close();}} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error ubicando linea a cambiar");
		}
	 	String NuevoTexto = id_car+";"+placa+";"+marca+";"+modelo+";"+color+";"+tipoTransmision+";"+precio+";"+categoria+";"+sedeActual+";0;"+disponibilidad;
	 	ArrayList<String> lineas3_car = new ArrayList<>();
	 	try {
            BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
            String linea2;
            while ((linea2 = br.readLine()) != null) {
                if (!linea2.equals(lienaCambiar)) {
                	lineas3_car.add(linea2);
                  
                }
                else {
                	lineas3_car.add(NuevoTexto);
                }
                
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Vehiculos.txt")); 
            for (String updatedLine : lineas3_car) {
                bw.write(updatedLine);
                bw.newLine();
            }
            bw.close();

            System.out.println("Peristencia Actualizada(vehiculo)");
        } catch (IOException e) {
            e.printStackTrace();
        }
	 	
	 	//persistencia cliente
	 			String lienaCambiar2 = "nada";
	 			String nombre="";
	 			String apellido="";
	 			String fechaNacimiento="";
	 			String nacionalidad="";
	 			String login="";
	 			String password="";
	 			String numMedioP = "";
	 			String cvv="";
	 			String id_licencia="";
	 			String pais="";
	 			String fechaVencimiento="";
	 			String foto="";
	 			String tel="";
	 		 	try {
	 				BufferedReader br = new BufferedReader(new FileReader("Datattt/Clientes.txt"));
	 				String linea;
	 				//System.out.println("adentro1");
	 				while((linea=br.readLine()) != null) {
	 					String[] partes = linea.split(";");
	 	                //System.out.println("adentro2.7");
	 	                login = partes[4].trim();
	 	                if (login.equals(id_client)) {
	 						lienaCambiar2 = linea;
	 						nombre = partes[0].trim();
	 						apellido = partes[1].trim();
	 						fechaNacimiento = partes[2].trim();
	 						nacionalidad = partes[3].trim();
	 						password = partes[5].trim();
	 						String[] partes2 = partes[6].split(",");
	 		                numMedioP = partes2[0].trim(); 
	 		                cvv = partes2[2].trim(); 
	 		                String[] partes3 = partes[7].split(",");
	 		                id_licencia = partes3[0].trim();
	 		                pais = partes3[1].trim();
	 		                fechaVencimiento = partes3[2];
	 		                foto = partes3[3].trim();
	 		                tel = partes[8].trim();
	 						 break;}
	 				//System.out.println(lienaAEliminar);
	 				br.close();}} 
	 			catch (Exception e) {
	 				// TODO: handle exception
	 				System.out.println("Error ubicando linea a cambiar");
	 			}
	 		 	String textoAAgregar = nombre+";"+apellido+";"+fechaNacimiento+";"+nacionalidad+";"+login+";"+password+";"+numMedioP+","+"true,"+cvv+";"+id_licencia+","+pais+","+fechaVencimiento+","+foto+";"+tel;
	 		 	ArrayList<String> lineas3 = new ArrayList<>();
	 		 	try {
	 	            BufferedReader br = new BufferedReader(new FileReader("Datattt/Clientes.txt"));
	 	            String linea2;
	 	            while ((linea2 = br.readLine()) != null) {
	 	                if (!linea2.equals(lienaCambiar2)) {
	 	                	lineas3.add(linea2);
	 	                  
	 	                }
	 	                else {
	 	                	lineas3.add(textoAAgregar);
	 	                }
	 	                
	 	            }
	 	            br.close();

	 	            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Clientes.txt")); 
	 	           int cont = 1;
	 	            for (String updatedLine : lineas3) {
	 	            	if (cont != lineas3.size()) {
	 	                bw.write(updatedLine);
	 	                bw.newLine();
	 	                cont++;}
	 	            	else {
	 	            	bw.write(updatedLine);
	 	            	}
	 	            }
	 	            bw.close();

	 	            System.out.println("Peristencia Actualizada(clientes)");
	 	        } catch (IOException e) {
	 	            e.printStackTrace();
	 	        }		
	 	
	 	
	}
	public void entregarVehiculo(Aplicacion aplicacion, String id) {
		HashMap<String,Reserva> res = aplicacion.getReservas();
		String id_vel = res.get(id).getVehiculoAsignado();
		String id_client = res.get(id).getCliente();
		
		HashMap<String,Vehiculo> vehiculos =aplicacion.getInventario();
		Vehiculo vehiculo = vehiculos.get(id_vel);
		vehiculo.setClienteActual(id_client);
		//vehiculo.setSedeActual(this.sede);
		
		HashMap<String,Cliente> clientes =aplicacion.getClientes();
		Cliente clm = clientes.get(id_client);
		clm.getMediosPago().setEstadoTarjeta(false);
		
		//persistencia vehiculo
		String lienaCambiar = "nada";
		String id_car="";
		String placa="";
		String marca="";
		String modelo="";
		String  color="";
		String tipoTransmision="";
		String precio="";
		String categoria="";
		String sedeActual="";
		String clienteActual="";
		String disponibilidad="";
	 	try {
			BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
			String linea;
			//System.out.println("adentro1");
			while((linea=br.readLine()) != null) {
				String[] partes = linea.split(";");
                //System.out.println("adentro2.7");
                id_car = partes[0].trim();
                if (id_vel.equals(id_car)) {
					lienaCambiar = linea;
					 placa = partes[1].trim();
					
					 marca = partes[2].trim();
					 modelo = partes[3].trim();
					 color = partes[4].trim();
					 tipoTransmision = partes[5].trim();
					 precio = partes[6].trim();
					 categoria = partes[7].trim();
					 sedeActual = partes[8].trim();
					 clienteActual = partes[9].trim();
					 disponibilidad = partes[10].trim();
					 break;}
			//System.out.println(lienaAEliminar);
			br.close();}} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error ubicando linea a cambiar");
		}
	 	String NuevoTexto = id_car+";"+placa+";"+marca+";"+modelo+";"+color+";"+tipoTransmision+";"+precio+";"+categoria+";"+sedeActual+";"+id_client+";"+disponibilidad;
	 	ArrayList<String> lineas3_car = new ArrayList<>();
	 	try {
            BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
            String linea2;
            while ((linea2 = br.readLine()) != null) {
                if (!linea2.equals(lienaCambiar)) {
                	lineas3_car.add(linea2);
                  
                }
                else {
                	lineas3_car.add(NuevoTexto);
                }
                
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Vehiculos.txt")); 
            int cont = 1;
            for (String updatedLine : lineas3_car) {
            	if (cont != lineas3_car.size()) {
                bw.write(updatedLine);
                bw.newLine();
                cont++;}
            	else {
            	bw.write(updatedLine);
            	}
            }
            bw.close();

            System.out.println("Peristencia Actualizada(vehiculo)");
        } catch (IOException e) {
            e.printStackTrace();
        }
	 	
	 	//persistencia cliente
	 			String lienaCambiar2 = "nada";
	 			String nombre="";
	 			String apellido="";
	 			String fechaNacimiento="";
	 			String nacionalidad="";
	 			String login="";
	 			String password="";
	 			String numMedioP = "";
	 			String cvv="";
	 			String id_licencia="";
	 			String pais="";
	 			String fechaVencimiento="";
	 			String foto="";
	 			String tel="";
	 		 	try {
	 				BufferedReader br = new BufferedReader(new FileReader("Datattt/Clientes.txt"));
	 				String linea;
	 				//System.out.println("adentro1");
	 				while((linea=br.readLine()) != null) {
	 					String[] partes = linea.split(";");
	 	                //System.out.println("adentro2.7");
	 	                login = partes[4].trim();
	 	                if (login.equals(id_client)) {
	 						lienaCambiar2 = linea;
	 						nombre = partes[0].trim();
	 						apellido = partes[1].trim();
	 						fechaNacimiento = partes[2].trim();
	 						nacionalidad = partes[3].trim();
	 						password = partes[5].trim();
	 						String[] partes2 = partes[6].split(",");
	 		                numMedioP = partes2[0].trim(); 
	 		                cvv = partes2[2].trim(); 
	 		                String[] partes3 = partes[7].split(",");
	 		                id_licencia = partes3[0].trim();
	 		                pais = partes3[1].trim();
	 		                fechaVencimiento = partes3[2];
	 		                foto = partes3[3].trim();
	 		                tel = partes[8].trim();
	 						 break;}
	 				//System.out.println(lienaAEliminar);
	 				br.close();}} 
	 			catch (Exception e) {
	 				// TODO: handle exception
	 				System.out.println("Error ubicando linea a cambiar");
	 			}
	 		 	String textoAAgregar = nombre+";"+apellido+";"+fechaNacimiento+";"+nacionalidad+";"+login+";"+password+";"+numMedioP+","+"false,"+cvv+";"+id_licencia+","+pais+","+fechaVencimiento+","+foto+";"+tel;
	 		 	ArrayList<String> lineas3 = new ArrayList<>();
	 		 	try {
	 	            BufferedReader br = new BufferedReader(new FileReader("Datattt/Clientes.txt"));
	 	            String linea2;
	 	            while ((linea2 = br.readLine()) != null) {
	 	                if (!linea2.equals(lienaCambiar2)) {
	 	                	lineas3.add(linea2);
	 	                  
	 	                }
	 	                else {
	 	                	lineas3.add(textoAAgregar);
	 	                }
	 	                
	 	            }
	 	            br.close();

	 	            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Clientes.txt")); 
	 	           int cont = 1;
	 	            for (String updatedLine : lineas3) {
	 	            	if (cont != lineas3.size()) {
	 	                bw.write(updatedLine);
	 	                bw.newLine();
	 	                cont++;}
	 	            	else {
	 	            	bw.write(updatedLine);
	 	            	}
	 	            }
	 	            bw.close();

	 	            System.out.println("Peristencia Actualizada(clientes)");
	 	        } catch (IOException e) {
	 	            e.printStackTrace();
	 	        }		
	 	
	 	
	}
}