package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;



public class Aplicacion {

	//Atributos
	 public HashMap<String,Vehiculo> inventarioAlquilado;
	 public HashMap<String,Vehiculo>  inventarioNoAlquilado;
	 public HashMap<String,Vehiculo>  inventario;
	 public HashMap<String,Sede>  sedes;
	 public HashMap<String,Reserva>   reservas;
	 private HashMap<String,String>   AdminGeneral_log;
	 private HashMap<String,String>  Adminloc_log;
	 private HashMap<String,String>  Empleados_log;
	 private HashMap<String,String>  Clientes_log;
	 public HashMap<String,Categoria> categorias;
	 public HashMap<String,Seguro> Seguros;
	 
	 public HashMap<String,AdminGeneral>  AdminGeneral;
	 public HashMap<String,AdminLocal>  Adminlocales;
	 public HashMap<String,Empleado>  Empleados;
	 public HashMap<String,Cliente>  Clientes;
	
	 public boolean temporadaAlta;
	 
	 private int idActualSeg;
	 private int idActualCar;
	 private int numReservas;
	 
	 public Aplicacion() {
		 
		 this.inventarioAlquilado = new HashMap<>();
		 this.inventarioNoAlquilado = new HashMap<>();
		 this.inventario = new HashMap<>();
		 this.sedes = new HashMap<>();
		 this.reservas = new HashMap<>();
		 this.AdminGeneral_log = new HashMap<>();
		 this.Adminloc_log = new HashMap<>();
		 this.Empleados_log = new HashMap<>();
		 this.Clientes_log = new HashMap<>();
		 this.Adminlocales = new HashMap<>();
		 this.AdminGeneral = new HashMap<>();
		 this.Empleados = new HashMap<>();
		 this.Clientes = new HashMap<>();
		 this.categorias = new HashMap<>();
		 this.Seguros = new HashMap<>();
	 }
	 public HashMap<String,Vehiculo> getInventario() {
		 return this.inventario;
	 }
	 
	 public HashMap<String,Categoria> getCategorias() {
		 return this.categorias;
	 }
	 public int getNumReservas() {
		 return this.numReservas;
	 }
	 public int getidActualSeg() {
		 return this.idActualSeg;
	 }
	 public int getidActualCar() {
		 return this.idActualCar;
	 }
	 public void setNumReservas() {
		  this.numReservas++;
	 }
	 public void setidActualSeg() {
		  this.idActualSeg++;
	 }
	 public void setidActualCar() {
		 this.idActualCar++;
	 }
	 public HashMap<String,Sede> getSedes(){
		 return this.sedes;
	 }
	 public HashMap<String,Reserva> getReservas(){
		 return this.reservas;
	 }
	 
	 public AdminGeneral getAdmin(String logIn) {
		 return AdminGeneral.get(logIn);
	 }
	 public HashMap<String,Seguro> getSeguros(){
		 return this.Seguros;
	 }
	 public AdminLocal getAdminloc(String logIn) {
		 return Adminlocales.get(logIn);
	 }
	 public HashMap<String,Empleado> getEmpleados(){
		 return this.Empleados;
	 }
	 public Empleado getEmpleado(String logIn){
			 return Empleados.get(logIn);
	 }
	 public HashMap<String,Cliente> getClientes(){
		 return this.Clientes;
	 }
	 public Cliente getCliente(String logIn) {
		 return Clientes.get(logIn);
	 }
	 
	 public void setSeguros(HashMap<String, Seguro> seguros) {
		Seguros = seguros;
	}
	public void cargarAdminGeneral(String archivoAdminGeneral){
		 try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminGeneral));
				String linea;
				linea=br.readLine();		
				String[] partes = linea.split(";");
				String nombre = partes[0].trim();
				//System.out.println(nombre);
                String apellido = partes[1].trim();
                //System.out.println(apellido);
                
                LocalDate fechaNacimiento = LocalDate.parse(partes[2].trim());
                //System.out.println(fechaNacimiento);
                String nacionalidad = partes[3].trim(); 
                String usuario = partes[4].trim(); 
                String Contrasenia = partes[5].trim(); 
                //System.out.println(usuario);		
                //System.out.println(Contrasenia);
                //System.out.println(nacionalidad);
                AdminGeneral ADMINg = new AdminGeneral(nombre, apellido, fechaNacimiento, nacionalidad, usuario, Contrasenia);
                AdminGeneral.put(usuario, ADMINg);
                AdminGeneral_log.put(usuario, Contrasenia);
                br.close();
	            
				
				} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos AdminGeneral");
				}
		 
	 }
	 public void cargarAdminsLocales(String archivoAdminsloc) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String nombre = partes[0].trim();
					//System.out.println("adentro2");
	                String apellido = partes[1].trim();
	                //System.out.println(apellido);
	                
	                LocalDate fechaNacimiento = LocalDate.parse(partes[2].trim());
	                //System.out.println(fechaNacimiento);
	                String nacionalidad = partes[3].trim(); 
	                String usuario = partes[4].trim(); 
	                String Contrasenia = partes[5].trim(); 
	                //System.out.println(usuario);		
	                //System.out.println(Contrasenia);
	                //System.out.println(nacionalidad);
	                Boolean Activo = Boolean.parseBoolean(partes[6].trim());
	                String sede = partes[7].trim(); 
	                
	                AdminLocal ADMINloc= new AdminLocal(nombre, apellido, fechaNacimiento, nacionalidad, usuario, Contrasenia,Activo,sede);
	                Adminlocales.put(usuario, ADMINloc);
	                Adminloc_log.put(usuario, Contrasenia);
	                
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos");
			}

		}
	 public void cargarCategorias(String archivoAdminsloc) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					//System.out.println("adentro2");
					String nombre = partes[0].trim();
					Integer tarifaTemporadaAlta = Integer.parseInt( partes[1].trim());
					Integer tarifaTemporadaBaja = Integer.parseInt( partes[2].trim());
					Integer valorExtraOtraSede = Integer.parseInt( partes[3].trim());
					Integer valorExtraConductorAdd = Integer.parseInt( partes[4].trim());
					Categoria categoria = new Categoria(nombre, tarifaTemporadaAlta, tarifaTemporadaBaja,valorExtraOtraSede, valorExtraConductorAdd);
					//System.out.println("adentro3");
	                categorias.put(nombre,categoria);
	                
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos Categorias");
			}

		}
	 public void cargarClientes(String archivoAdminsloc) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String nombre = partes[0].trim();
					//System.out.println("adentro2");
	                String apellido = partes[1].trim();
	                //System.out.println(apellido);
	                
	                LocalDate fechaNacimiento = LocalDate.parse(partes[2].trim());
	                //System.out.println(fechaNacimiento);
	                String nacionalidad = partes[3].trim(); 
	                String usuario = partes[4].trim(); 
	                String Contrasenia = partes[5].trim(); 
	                //System.out.println(usuario);		
	                //System.out.println(Contrasenia);
	                //System.out.println(nacionalidad);
	                String[] partes2 = partes[6].split(",");
	                String numMedioP = partes2[0].trim(); 
	                Boolean EstadoTar = Boolean.parseBoolean(partes2[1].trim()); 
	                String CSV = partes2[2].trim(); 
	                String[] partes3 = partes[7].split(",");
	                String id = partes3[0].trim();
	                String pais = partes3[1].trim();
	                LocalDate fechaExpiracion = LocalDate.parse(partes3[2].trim());
	                String foto = partes3[3].trim();
	                String NumTelef = partes[8].trim();
	                
	                MedioPago medioPago = new MedioPago(numMedioP,EstadoTar,CSV);
	                Licencia lis = new Licencia(id,pais,fechaExpiracion,foto);
	                Cliente cliente = new Cliente(nombre, apellido, fechaNacimiento, nacionalidad, usuario, Contrasenia,medioPago,lis,NumTelef);
	                Clientes.put(usuario,cliente);
	                Clientes_log.put(usuario, Contrasenia);
	                //System.out.println(Clientes.get(usuario));
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos Clientes");
			}

		}
	 public void cargarEmpleados(String archivoAdminsloc){
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String nombre = partes[0].trim();
					//System.out.println("adentro2");
	                String apellido = partes[1].trim();
	                //System.out.println(apellido);
	                
	                LocalDate fechaNacimiento = LocalDate.parse(partes[2].trim());
	                //System.out.println(fechaNacimiento);
	                String nacionalidad = partes[3].trim(); 
	                String usuario = partes[4].trim(); 
	                String Contrasenia = partes[5].trim(); 
	                //System.out.println(usuario);		
	                //System.out.println(Contrasenia);
	                //System.out.println(nacionalidad);
	                Boolean Activo = Boolean.parseBoolean(partes[6].trim());
	                String sede = partes[7].trim(); 
	                
	                Empleado empleado = new Empleado(nombre, apellido, fechaNacimiento, nacionalidad, usuario, Contrasenia,Activo,sede);
	                Empleados.put(usuario,empleado);
	                Empleados_log.put(usuario, Contrasenia);
	                //System.out.println(Empleados_log.get(usuario));
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos Empleados");
			}
		}
	 public void cargarSedes(String archivoAdminsloc){
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String nombre = partes[0].trim();
					//System.out.println("adentro2");
	                
	                LocalTime horaApertura = LocalTime.parse(partes[1].trim());
	                //System.out.println("adentro2.5");
	                LocalTime horaCierre = LocalTime.parse(partes[2].trim());
	                //System.out.println("adentro2.7");
	                ArrayList<String> empleados = new ArrayList<>();
	                String[] partes2 = partes[3].split(",");
	                //System.out.println("adentro3");
	                for(String empleado: partes2) {
	                	empleados.add(empleado);
	                }
	                String admin = partes[4].trim();
	                ArrayList<String> carros = new ArrayList<>();
	                String[] partes3 = partes[5].split(",");
	                for(String carro: partes3) {
	                	carros.add(carro);
	                }
	                Sede sede = new Sede(nombre,horaApertura,horaCierre,empleados,admin,carros);
	                sedes.put(nombre,sede);
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos Sedes");
			}
		}
	 public void cargarSeguro(String archivoAdminsloc){
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String id = partes[0].trim();
					String nombre = partes[1].trim();
					String Costo = partes[2].trim();
					//System.out.println("adentro2");
					Seguro seg = new Seguro(id,nombre, Costo);
					Seguros.put(id,seg);
					idActualSeg = Integer.parseInt(id);
					//System.out.println("adentro3");
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos Seguros");
			}
		}
	 public void cargarVehiculos(String archivoAdminsloc){
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String id = partes[0].trim();
					String placa = partes[1].trim();
					
					String marca = partes[2].trim();
					String modelo = partes[3].trim();
					String color = partes[4].trim();
					String transmision = partes[5].trim();
					String precio = partes[6].trim();
					String categoria = partes[7].trim();
					String sede = partes[8].trim();
					String cliente = partes[9].trim();
					
					ArrayList<Integer> dispo = new ArrayList<>();
	                String[] partes2 = partes[10].split(",");
	                for(String disp: partes2) {
	                	dispo.add(Integer.parseInt(disp));
	                }
					Vehiculo vel = new Vehiculo(id,placa,marca,modelo,color,transmision,precio,categoria,sede,cliente,dispo);
					//System.out.println("adentro2");
					inventario.put(id, vel);
					idActualCar = Integer.parseInt(id); 
					if (vel.getClienteActual().equals("0")) {
						inventarioNoAlquilado.put(id, vel);
						//ystem.out.println("adentro3");
					}
					else {
						inventarioAlquilado.put(id, vel);
					}
					
					//System.out.println("adentro3");
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos vehiculos");
				e.printStackTrace();
			}
		}
	 public void cargarTemporada(String archivoAdminsloc){
			try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro1");
				linea=br.readLine(); 
				Boolean temp = Boolean.parseBoolean(linea);
				this.temporadaAlta = temp;
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos temp");
			}
		} 
	 public void cargarReservas(String archivoAdminsloc) {
		 try {
				BufferedReader br = new BufferedReader(new FileReader(archivoAdminsloc));
				String linea;
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String id = partes[0].trim();
					String cliente = partes[1].trim();
					
					String categoria = partes[2].trim();
					String montoPagar = partes[3].trim();
					String sedeRecogida = partes[4].trim();
					String sedeDevolucion = partes[5].trim();
					LocalDate fechaReserva = LocalDate.parse(partes[6].trim());
					LocalTime horaDevolucion = LocalTime.parse(partes[7].trim());
					String vehiculoAsignado = partes[8].trim();
					
					
					ArrayList<String> seguros = new ArrayList<>();
					if (!(partes[9].equals(""))) {	
	                String[] partes2 = partes[9].split(",");
	                for(String seg: partes2) {
	                	seguros.add((seg));
	                }}
	                ArrayList<String> conductoresAdicionales = new ArrayList<>();
	                if(!(partes[10].equals(""))) {	
	                String[] partes3 = partes[10].split(",");
	                for(String clm: partes3) {
	                	seguros.add((clm));
	                }}
	                LocalDate fechaRecogida = LocalDate.parse(partes[11].trim());
	                
	                
					Reserva res = new Reserva(id,cliente,categoria,sedeRecogida,sedeDevolucion,fechaReserva,horaDevolucion,vehiculoAsignado,seguros,conductoresAdicionales,fechaRecogida);
					//System.out.println("adentro2");
					res.setMontoAPagar(montoPagar);
					reservas.put(id, res);
					this.numReservas ++;
					
					//System.out.println("adentro3");
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos Reservas");
				e.printStackTrace();
			}
		 
		 
	 }

	 
	 public void setTemporada(Boolean temp) {
		 this.temporadaAlta = temp;
		 System.out.println("La temporalidad se cambio exitosamente");
	 }
	 
	public Integer verificarUsuario(String logIn, String contrasenia) {
		 //private HashMap<String,String>   AdminGeneral_log;
		 //private HashMap<String,String>  Adminloc_log;
		 //private HashMap<String,String>  Empleados_log;
		 //private HashMap<String,String>  Clientes_log;
		if(AdminGeneral_log.containsKey(logIn)) {
			if (AdminGeneral_log.get(logIn).equals(contrasenia)) {
				return 1;}
			else {
				return 0;}
			}
		else if(Adminloc_log.containsKey(logIn)) {
			if (Adminloc_log.get(logIn).equals(contrasenia)) {
				return 2;}
			else {
				return 0;}
			
		}
		else if(Empleados_log.containsKey(logIn)) {
			if (Empleados_log.get(logIn).equals(contrasenia)) {
				return 3;}
			else {
				return 0;}
			
		}
		else if(Clientes_log.containsKey(logIn)) {
			if (Clientes_log.get(logIn).equals(contrasenia)) {
				return 4;}
			else {
				return 0;}
			
		}
		else 
		{
		return 0;}	
		}		
	

}
