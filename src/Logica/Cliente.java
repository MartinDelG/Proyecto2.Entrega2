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

public class Cliente extends Persona {
	
	//Atributos
	private MedioPago mediosPago;
	private Licencia licencia;
	private String telefono;

	//Metodos
	public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String login,
			String password, MedioPago mediosPago, Licencia licencia, String telefono) {
		super(nombre, apellido, fechaNacimiento, nacionalidad, login, password);
		this.mediosPago = mediosPago;
		this.licencia = licencia;
		this.telefono = telefono;
	}

	

	public MedioPago getMediosPago() {
		return mediosPago;
	}
	
	public boolean crearReserva(Aplicacion aplicacion, String deseada, String sedeReclamo,String sedeDevolucion, String fechaReservaReclamo, String fechaReservaDevolucion,
			String horaDevolucion,String seguros,String conductoresAdicionales) {
		
		ArrayList<String> seguro = new ArrayList<String>();
		String[] seg = seguros.split(",");
		for (String elemento:seg) {
			//Seguro item = convertirSeguroDesdeString(aplicacion,elemento);
			seguro.add(elemento);
		}
		ArrayList<String> cliente = new ArrayList<String>();
		String[] cli = conductoresAdicionales.split(",");
		for (String element:cli) {
			//Cliente item = convertirClienteDesdeString(aplicacion,element);
			cliente.add(element);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaReservaRec = LocalDate.parse(fechaReservaReclamo,formatter);
		LocalDate fechaReservaDev = LocalDate.parse(fechaReservaDevolucion,formatter);
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm:ss");
			//LocalTime horaRec = LocalTime.parse(horaReclamo,formater);
		LocalTime horaDev = LocalTime.parse(horaDevolucion,formater);
		HashMap<String,Sede> sedes=aplicacion.getSedes();
		Sede sedeReclamoS = sedes.get(sedeReclamo);
		int carroA = buscarCarro(aplicacion, sedeReclamoS,fechaReservaRec, fechaReservaDev, deseada);
		if (carroA!=0) {
			HashMap<String,Vehiculo> vehiculos =aplicacion.getInventario();
			Categoria cate = aplicacion.getCategorias().get(vehiculos.get(String.valueOf(carroA)).getCategoria());
			Reserva reserva = new Reserva(String.valueOf(aplicacion.getNumReservas())+1,this.getLogin(),
					cate.getNombre(),sedeReclamo, sedeDevolucion, fechaReservaDev, horaDev, String.valueOf(carroA),seguro,cliente,fechaReservaRec);
					
					reserva.setMontoAPagar(reserva.calcularCosto(aplicacion,aplicacion.temporadaAlta,cate,fechaReservaDev,fechaReservaRec));
					ArrayList<Integer>disp=vehiculos.get(String.valueOf(carroA)).getDisponibilidad();
					int diaInicio = (int)(ChronoUnit.DAYS.between(LocalDate.parse("2023-10-16"), fechaReservaRec));
					int diasNecesidad = (int)(ChronoUnit.DAYS.between(fechaReservaRec, fechaReservaDev));
					for(int i=diaInicio;i<=diasNecesidad+diaInicio;i++) {disp.set(i, 1);}
					vehiculos.get(String.valueOf(carroA)).setDisponibilidad(disp);
			//persistencia
					String textoAAgregar = "\n"+String.valueOf(aplicacion.getNumReservas()+1)+";"+this.getLogin()+";"+cate.getNombre()+";"+reserva.getMontoAPagar()+";"+sedeReclamo+";"+sedeDevolucion+";"+fechaReservaReclamo+";"+horaDevolucion+";"+String.valueOf(carroA)+";"+seguros+";"+conductoresAdicionales+";"+fechaReservaReclamo;
			try {
	            
	            FileWriter fileWriter = new FileWriter("Datattt/reservas.txt", true);
	
	            
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	
	            
	            bufferedWriter.write(textoAAgregar);
	            //bufferedWriter.newLine(); 
	            bufferedWriter.close();
	            fileWriter.close();
	
	            System.out.println("Peristencia Actualizada");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
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
	                if (String.valueOf(carroA).equals(id_car)) {
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
				        disponibilidad3 = disponibilidad.substring(1, disponibilidad.length());
						break;}
				}
				//System.out.println(lienaAEliminar);
				br.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error ubicando linea a cambiar");
			}
		 	String NuevoTexto = id_car+";"+placa+";"+marca+";"+modelo+";"+color+";"+tipoTransmision+";"+precio+";"+categoria+";"+sedeActual+";"+clienteActual+";"+disponibilidad3;
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

	            System.out.println("Peristencia Actualizada Carro");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
				return true;}
								
		else {
			System.out.println("No se pudo compleatarla reserva pues no hay un carro con sus condiciones");
			return false;
		}
		
		
		
		
		
	}
	private int buscarCarro(Aplicacion aplicacion, Sede sedeR, LocalDate fechaReservaReclamo, LocalDate fechaReservaDevolucion, String categoria) {
		int diasNecesidad = (int)(ChronoUnit.DAYS.between(fechaReservaReclamo, fechaReservaDevolucion));
		ArrayList<String> carroseSede = sedeR.getCarrosEnSede();
		HashMap<String,Vehiculo> vehiculos =aplicacion.getInventario();
		ArrayList<String> carrosPosibles1 = new ArrayList<String>();
		for(String carro:carroseSede) {
			if (carroSirveDisp(vehiculos.get(carro),fechaReservaReclamo,diasNecesidad) ==true && carroSeriveTipo(vehiculos.get(carro), categoria)==true)  {
				carrosPosibles1.add(carro);
			}
		}
		for (String carroPos: carrosPosibles1) {
			if (vehiculos.get(carroPos).getCategoria().equals(categoria)) {
				return Integer.parseInt(carroPos);
			}
		}
		if (carrosPosibles1.size()!=0)
		{return Integer.parseInt(carrosPosibles1.get(0));}
		else {
		return 0;}
		
	}
	private boolean carroSirveDisp(Vehiculo carro,  LocalDate fechaReservaReclamo, int diasNecesidad ) {
		int diaInicio = (int)(ChronoUnit.DAYS.between(LocalDate.parse("2023-10-16"), fechaReservaReclamo));
		ArrayList<Integer>disp=carro.getDisponibilidad();
		for(int i=diaInicio;i<=diasNecesidad+diaInicio;i++) {
			if (disp.get(i)==1) {
			return false;}
		}
		return true;
	}
	private boolean carroSeriveTipo(Vehiculo carro, String categoria) {
		
		if (carro.getCategoria().equals(categoria)) {
			return true;
		}
		else if(carro.getCategoria().equals("van") && categoria.equals("camioneta")){
			return false;
		}
		else if(carro.getCategoria().equals("automovil") && categoria.equals("camioneta")){
			return false;
		}
		else if(carro.getCategoria().equals("van") && categoria.equals("automovil")){
			return true;
		}
		else if(carro.getCategoria().equals("camioneta") && categoria.equals("automovil")){
			return true;
		}
		else if(carro.getCategoria().equals("automovil") && categoria.equals("van")){
			return false;
		}
		else if(carro.getCategoria().equals("camioneta") && categoria.equals("van")){
			return true;
		}
		else {return false;}
	}
	
	public static Seguro convertirSeguroDesdeString(Aplicacion aplicacion,String seguros){
		String[] partes = seguros.split(",");
		String nombre = partes[0];
		return aplicacion.getSeguros().get(nombre);
	}
	
	public static Cliente convertirClienteDesdeString(Aplicacion aplicacion,String conductoresAdicionales){
		String[] partes = conductoresAdicionales.split(",");
		String login = partes[0];
		return aplicacion.getClientes().get(login);
	}
	
	public static MedioPago convertirMedioPagoDesdeString(String medioPago){
		String[] partes = medioPago.split(",");
		String numero = partes[0];
		boolean estadoTarjeta = Boolean.parseBoolean(partes[1]);
		String cvv = partes[2];
		return new MedioPago(numero,estadoTarjeta,cvv);
	}
	
	public static Licencia convertirLicenciaDesdeString(String licencia){
		String[] partes = licencia.split(",");
		String id = partes[0];
		String pais = partes[1];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaVencimiento = LocalDate.parse(partes[2],formatter);
		String foto = partes[3];
		return new Licencia(id,pais,fechaVencimiento,foto);
	}
	public int[][] matrizDispo(Aplicacion app,String sedeMostrar){
		int[][] resp = new int[12][30];
		int[][] resp2 = new int[12][30];
		
		 for (int i = 0; i < resp.length; i++) {
	            for (int j = 0; j < resp[i].length; j++) {
	                resp[i][j] = 0;
	            }
	        }

		Sede sedeM= app.getSedes().get(sedeMostrar);
		ArrayList<String> carroseSede = sedeM.getCarrosEnSede();
		HashMap<String,Vehiculo> vehiculos = app.getInventario();
		
		//int y = 0;
		for (String carro : carroseSede ) {
			int x = 0;
			for (Integer disp: vehiculos.get(carro).getDisponibilidad()) {
				if (disp == 1) {
					resp[0][x] += 1;	
				}
			x++;	
			}
			//sedeM.getCarrosEnSede().size()
		}
		for (int i = 0; i < resp.length; i++) {
            for (int j = 0; j < resp[i].length; j++) {
            	if (resp[i][j] == sedeM.getCarrosEnSede().size()) {
                	resp2[i][j] = 100;}
            	else if(resp[i][j]!= sedeM.getCarrosEnSede().size()&&resp[i][j]!=0){
            		resp2[i][j] = resp[i][j];
            	}
            	else {
            		resp2[i][j] = 0;
            	}
            }
        }
		
		
		return resp2;
		
	}
	
	
}
