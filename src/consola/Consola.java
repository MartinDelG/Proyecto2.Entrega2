package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Logica.*;

public class Consola {
	private Aplicacion app = new Aplicacion();
	public Consola() {
		// TODO Auto-generated constructor stub
	}
	/*
	public static void main(String[] args) {
		Consola consola = new Consola();
		consola.app.cargarAdminGeneral("Datattt/adminGeneral.txt");
		consola.app.cargarAdminsLocales("Datattt/AdminLocal.txt");
		consola.app.cargarCategorias("Datattt/Categorias.txt");
		consola.app.cargarClientes("Datattt/Clientes.txt");
		consola.app.cargarEmpleados("Datattt/Empleados.txt");
		consola.app.cargarSedes("Datattt/Sedes.txt");
		consola.app.cargarSeguro("Datattt/Seguros.txt");
		consola.app.cargarVehiculos("Datattt/Vehiculos.txt");
		consola.app.cargarTemporada("Datattt/temp.txt");
		consola.app.cargarReservas("Datattt/reservas.txt");
		consola.ejecutarAplicacion();
	}*/
	
	public void ejecutarAplicacion()
	{
		System.out.println("APLIACION ALQUILER DE CARROS\n");

		String logIn = (input("Por favor ingrese su logIn"));
		String contrasenia = (input("Por favor ingrese su Contrasenia"));		
		int val = app.verificarUsuario(logIn, contrasenia);
		
		if (val == 1) {
			System.out.println("SESION INICIADA COMO ADMINGENRAL");
			ConsolaAdminGeneral(logIn);
		}
		else if(val == 2) {
			System.out.println("SESION INICIADA COMO ADMINLOC");
			ConsolaAdminloc(logIn);
		}
		else if(val == 3) {
			System.out.println("SESION INICIADA COMO EMPLEADO");
			ConsolaEmpleado(logIn);
		}
		else if(val == 4) {
			System.out.println("SESION INICIADA COMO CLIENTE");
			ConsolaCliente(logIn);
		}
		else {
			System.out.println("CONTRASENIA O LOGIN INCORRECTO");
		}
		
	}
	
public String input(String mensaje)
{
	try
	{
		System.out.print(mensaje + ": ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}
	catch (IOException e)
	{
		System.out.println("Error leyendo de la consola");
		e.printStackTrace();
	}
	return null;
}
public void mostrarMenuPricipal()
{
	System.out.println("\nOpciones de la aplicación\n");
	System.out.println("1. Acceder como administrador General");
	System.out.println("2. Acceder como administrador Local");
	System.out.println("3. Acceder como empleado");
	System.out.println("4. Acceder como cliente");
	System.out.println("5. Salir de la app");

}
public void ConsolaAdminGeneral(String id)
{
	System.out.println("Consola ADMINGENRAL\n");
	AdminGeneral admin = app.getAdmin(id);
	boolean continuar = true;
	while (continuar)
	{
		try
		{
			mostrarMenuAdminGeneral();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				
				//String id_carro = input("\nIngrese el ID del nuevo vehiculo");
				String placa = input("Ingrese la placa del nuevo vehiculo");
				String marca = input("Ingrese la marca del nuevo vehiculo");
				String modelo = input("Ingrese el modelo del nuevo vehiculo");
				String color = input("Ingrese el color del nuevo vehiculo");
				String tipoTransmision = input("Ingrese el tipo Transmision del nuevo vehiculo");
				String precio = input("Ingrese el precio del nuevo vehiculo");
				String categoria = input("Ingrese la categoria del nuevo vehiculo");
				String sedeActual = input("Ingrese la sedeActual del nuevo vehiculo");
				
				admin.agregarVehículo(app, placa, marca, modelo, color, tipoTransmision, precio, categoria, sedeActual);
								
			}
				
			else if (opcion_seleccionada == 2){
				String id_carro = input("Ingrese el ID del vehiculo a eliminar");
				admin.eliminarVehículo(app, id_carro);
			}
				
			else if (opcion_seleccionada == 3){
				//String id_seg = input("\nIngrese el id del nuevo seguro");
				String nombre = input("Ingrese el nombre del nuevo seguro");
				String precio = input("Ingrese el precio del nuevo seguro");
				admin.nuevoSeguro(app, nombre, precio);
				
			}
			else if (opcion_seleccionada == 4){
				 String id_elim = input("\nIngrese el id del seguro a eliminar");
				 admin.eliminarSeguro(app, id_elim);
			}
			else if (opcion_seleccionada == 5){
				String id_edit = input("\nIngrese el id del seguro a cambiar");
				String edit = input("Ingrese el nuevo precio diario");
				admin.editarSeguro(app, id_edit, edit);
			}
			else if (opcion_seleccionada == 6){
				String sede = input("\nIngrese la sede a cambiar el horario");
				int cambiar = Integer.parseInt(input("Ingrese 0 si desea cambiar la hora de apertura 1 hora de cierre"));
				LocalTime nuevaHora = LocalTime.parse(input("Ingrese la nueva hora (hh:mm:ss)"));
				admin.CambiarHorariosSedes(app, sede, cambiar, nuevaHora);
			}	
			else if (opcion_seleccionada == 7){
				Boolean temp = Boolean.parseBoolean( input("es la temporada es alta? (true/false)"));
				admin.setTemporada(app, temp);
			}	
			else if (opcion_seleccionada == 8){
				String id_car = input("Id del carro a crear archivo");
				admin.generarLog(id_car);
			}	
			else if (opcion_seleccionada == 9)
				continuar = false;
			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
}

public void ConsolaAdminloc(String id)
{
	System.out.println("Consola ADMIN LOCAL\n");
	AdminLocal admin = app.getAdminloc(id);
	boolean continuar = true;
	while (continuar)
	{
		try
		{
			mostrarMenuAdminLoc();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				
				String nombre = input("\nIngrese el nombre del nuevo empleado");
				String apellido = input("Ingrese la apellido del nuevo empleado");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate fechaNacimiento = LocalDate.parse(input("Ingrese la fecha de nacimiento del nuevo empleado(yyyy-mm-dd)"),formatter);
				String nacionalidad = input("Ingrese el nacionalidad del nuevo del nuevo empleado");
				String login = input("Ingrese el login del nuevo empleado");
				String password = input("Ingrese el password  del nuevo empleado");
				
				
				admin.agregarEmpleado(app, nombre, apellido, fechaNacimiento, nacionalidad, login, password);
								
			}	
			else if (opcion_seleccionada == 2) {
				String nombre = input("\nIngrese el nombre del nuevo cliente");
				String apellido = input("Ingrese la apellido del nuevo cliente");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate fechaNacimiento = LocalDate.parse(input("Ingrese la fecha de nacimiento del nuevo cliente(yyyy-mm-dd)"),formatter);
				String nacionalidad = input("Ingrese el nacionalidad del nuevo del nuevo cliente");
				String login = input("Ingrese el login del nuevo cliente");
				String password = input("Ingrese el password  del nuevo cliente");
				String numero = input("Ingrese el numero del medio del pago del cliente");
				String cvv = input("Ingrese el CVV del medio del pago del cliente");
				String id_licencia = input("Ingrese el id de la licencia del cliente");
				String pais = input("Ingrese el pais de la licencia del cliente");
				LocalDate fechaVencimiento = LocalDate.parse( input("Ingrese la fecha de vencimiento de la licencia del cliente(yyyy-mm-dd)"));
				String foto = input("link de la foto licencia del cliente");
				String tel = input("telefono del cliente");
				admin.agregarCliente(app, nombre, apellido, fechaNacimiento, nacionalidad, login, password, numero, cvv, id_licencia, pais, fechaVencimiento, foto, tel);
			}
			else if (opcion_seleccionada == 3)
				continuar = false;
			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
}
public void ConsolaEmpleado(String id)
{
	System.out.println("Consola Empleado\n");
	Empleado emp = app.getEmpleado(id);
	boolean continuar = true;
	while (continuar)
	{
		try
		{
			mostrarMenuEmpleado();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				String id_res= input("\nIngrese el id de la reserva");
				emp.retornarVehiculo(app, id_res);
								
			}	
			else if (opcion_seleccionada == 3) {
				String id_res= input("\nIngrese el id de la reserva");
				//emp.retornarVehiculo(app, id_res);
				emp.entregarVehiculo(app, id_res);
			}
			else if (opcion_seleccionada == 3) {
				String id_car = input("\nIngrese el id del carro");
				int numDias =  Integer.parseInt(input("Ingrese el numero de dias a sacar de circulacion"));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate fechadisp = LocalDate.parse(input("Ingrese la fecha a partir que el carro no esta diponible(yyyy-mm-dd)"),formatter);
				
				emp.modificarDisponiblidad(app, id_car, numDias, fechadisp);
			}
			
			else if (opcion_seleccionada == 4)
				continuar = false;
			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
}

public void ConsolaCliente(String id)
{
	System.out.println("Consola CLIENTE\n");
	Cliente clm = app.getCliente(id);
	boolean continuar = true;
	while (continuar)
	{
		try
		{
			mostrarMenuCliente();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				
				String categoria = input("Ingrese la categoria que desea reservar: ");
				String sedeRec = input("Ingrese la sede donde va a reclamar el vehiculo: ");
 				String sedeRet = input("Ingrese la sede donde va a regresar el vehiculo: ");
				String fechaRec = input("Ingrese la fecha en la que desea reclamar el vehiculo (en formato yyyy-MM-dd: ");
				String fechaRet = input("Ingrese la fecha en la que desea retornar el vehiculo (en formato yyyy-MM-dd: ");
				//String horaRec = input("Ingrese la hora en la que desea reclamar su vehiculo(en formato hh:mm:ss: ");
				String horaRet = input("Ingrese la hora en la que desea retornar su vehiculo(en formato hh:mm:ss: ");
				String seguro = input("Ingrese el nombre de los seguros que desea tener separados por una coma(no ingrese nada si no quiere seguros): ");
				String conducAdicionales = input("Ingrese el logIn de los conductores adicionales separados por una coma(no ingrese nada si no requiere conductores adicionales: ");
				clm.crearReserva(app, categoria, sedeRec, sedeRet, fechaRec, fechaRet, horaRet, seguro, conducAdicionales);
								
			}	
			
			
			else if (opcion_seleccionada == 2)
				continuar = false;
			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
}




public void mostrarMenuAdminGeneral() {
	System.out.println("\nOpciones\n");
	System.out.println("1. Agregar un nuevo vehiculo---");
	System.out.println("2. Eliminar un vehiculo---");
	System.out.println("3. Agregar un nuevo seguro---");
	System.out.println("4. Eliminar un seguro---");
	System.out.println("5. Editar un seguro---");
	System.out.println("6. Cambiar horarios de una sede---");
	System.out.println("7. Cambiar temporalidad---");
	System.out.println("8. ArchivoLog de un carro---");
	System.out.println("9. Salir");
	}
public void mostrarMenuAdminLoc() {
	System.out.println("\nOpciones\n");
	System.out.println("1. Agregar un nuevo empleado");
	System.out.println("2. Agregar un nuevo cliente");
	System.out.println("3. Salir");
	}

public void mostrarMenuEmpleado() {
	System.out.println("\nOpciones\n");
	System.out.println("1. retornar Carro---");
	System.out.println("2. entregar Carro---");
	System.out.println("3. Modificar disponibilidad de un carro(limpieza o mantenimiento)---");
	System.out.println("4. Salir");
	}
public void mostrarMenuCliente() {
	System.out.println("\nOpciones\n");
	System.out.println("1. Nueva Reserva---");
	System.out.println("2. Salir");
	}
}
