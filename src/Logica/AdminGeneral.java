package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminGeneral extends Persona {

	//Atributos
	
	
	//Metodos
	public AdminGeneral(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String login,
			String password) {
		super(nombre, apellido, fechaNacimiento, nacionalidad, login, password);
	}

	public void agregarVehículo(Aplicacion app, String placa, String marca, String modelo, String color, String tipoTransmision,
			String precio, String categoria, String sedeActual ) {
		    ArrayList<Integer> disp =  new ArrayList<>();
		    for (int i = 0; i < 30; i++) {
		    	disp.add(0);
	        }
		    HashMap<String,Vehiculo> vehiculos = app.getInventario();
		    HashMap<String,Categoria> categorias = app.getCategorias();
		    HashMap<String,Sede> sedes = app.getSedes();
		    String id = String.valueOf(app.getidActualCar()+1);
		
			Vehiculo vel = new Vehiculo(id,placa,marca,modelo,color,tipoTransmision,precio,categoria,sedeActual,"0",disp);
		    vehiculos.put(id, vel);
		    
		    Sede sedeAgregar = sedes.get(sedeActual);
		    ArrayList<String> carrosSede = sedeAgregar.getCarrosEnSede();
		    carrosSede.add(id);
		    sedeAgregar.setCarrosEnSede(carrosSede);
		    System.out.println("Se agrego con exito el nuevo vehiculo");
		    String textoAAgregar = "\n"+id+";"+placa+";"+marca+";"+modelo+";"+color+";"+tipoTransmision+";"+precio+";"+categoria+";"+sedeActual+";"+"0"+";"+"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0";
		    
		    try {
	            
	            FileWriter fileWriter = new FileWriter("Datattt/Vehiculos.txt", true);

	            
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
			String nombre="";
			String horaCierre="";
			String  horaAbrir="";
			String empleados="";
			String admin="";
			String carros="";
		 	try {
				BufferedReader br = new BufferedReader(new FileReader("Datattt/Sedes.txt"));
				
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
	                //System.out.println("adentro2.7");
	                nombre = partes[0].trim();
	                if (sedeActual.equals(nombre)) {
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
		 	String NuevoTexto = nombre+";"+horaAbrir+";"+horaCierre+";"+empleados+";"+admin+";"+carros+","+id;
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
	            for (String updatedLine : lineas) {
	                bw.write(updatedLine);
	                bw.newLine();
	            }
	            bw.close();

	            System.out.println("Peristencia Actualizada");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		
		    
		    
    }
	
	
	public void eliminarVehículo(Aplicacion app, String idEliminar) {
			
		 	HashMap<String,Vehiculo> vehiculos = app.getInventario();
		 	Vehiculo vel = vehiculos.get(idEliminar);
		 	String sedeActual = vel.getSedeActual();
		 	HashMap<String,Sede> sedes = app.getSedes();
		    Sede sedeElim = sedes.get(sedeActual);
		    ArrayList<String> carrosSede = sedeElim.getCarrosEnSede();
		    int indiceElim = carrosSede.indexOf(idEliminar);
		    carrosSede.remove(indiceElim);
		    sedeElim.setCarrosEnSede(carrosSede);
		    
		 	vehiculos.remove(idEliminar);
		 	String lienaAEliminar = "nada";
		 	try {
				BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
				String linea;
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					String id = partes[0].trim();
					if (idEliminar.equals(id)) {
						lienaAEliminar = linea;
						break;}
				}
				//System.out.println(lienaAEliminar);
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error ubicando linea a eliminar");
			}
		 	ArrayList<String> lineas = new ArrayList<>();
		 	try {
	            BufferedReader br = new BufferedReader(new FileReader("Datattt/Vehiculos.txt"));
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                if (!linea.equals(lienaAEliminar)) {
	            
	                    lineas.add(linea);
	                }
	            }
	            br.close();

	            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Vehiculos.txt"));
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
		 	String lienaCambiar = "nada";
			String linea="";
			String nombre="";
			String horaCierre="";
			String  horaAbrir="";
			String empleados="";
			String admin="";
			String carrosNuevo2="";
		 	try {
				BufferedReader br = new BufferedReader(new FileReader("Datattt/Sedes.txt"));
				
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
	                //System.out.println("adentro2.7");
	                nombre = partes[0].trim();
	                if (sedeActual.equals(nombre)) {
						lienaCambiar = linea;
						horaAbrir = partes[1].trim();
						horaCierre = partes[2].trim();
						empleados = partes[3].trim();
						
						admin = partes[4].trim();
						String[] carros = partes[5].split(",");
						String carrosNuevo = "";
				        for (String element : carros) {
				            
				            
				            if (!element.equals(idEliminar)) {
				                
				            	carrosNuevo = carrosNuevo+","+element;
				            }
				        }
				        carrosNuevo2 = carrosNuevo.substring(1, carrosNuevo.length());
						
						break;}
				}
				//System.out.println(lienaAEliminar);
				br.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error ubicando linea a cambiar");
			}
		 	String NuevoTexto = nombre+";"+horaAbrir+";"+horaCierre+";"+empleados+";"+admin+";"+carrosNuevo2;
		 	ArrayList<String> lineas3 = new ArrayList<>();
		 	try {
	            BufferedReader br = new BufferedReader(new FileReader("Datattt/Sedes.txt"));
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

	            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Sedes.txt")); 
	            for (String updatedLine : lineas3) {
	                bw.write(updatedLine);
	                bw.newLine();
	            }
	            bw.close();

	            System.out.println("Peristencia Actualizada");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	public void nuevoSeguro(Aplicacion app, String nombre, String precio) {
		HashMap<String,Seguro> seguros = app.getSeguros();
		String id = String.valueOf(app.getidActualSeg()+1);
		Seguro seg = new Seguro(id,nombre,precio);
		
		seguros.put(id, seg);
		String textoAAgregar = "\n"+id+";"+nombre+";"+precio;
		try {
            
            FileWriter fileWriter = new FileWriter("Datattt/Seguros.txt", true);

            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            
            bufferedWriter.write(textoAAgregar);
            //bufferedWriter.newLine(); 
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Peristencia Actualizada");
            app.setidActualSeg();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	 }
	public void eliminarSeguro(Aplicacion app, String id_elim) {
		HashMap<String,Seguro> seguros = app.getSeguros();
	 	seguros.remove(id_elim);
	 	//app.setSeguros(seguros);
	 	String lienaAEliminar = "nada";
	 	try {
			BufferedReader br = new BufferedReader(new FileReader("Datattt/Seguros.txt"));
			String linea;
			//System.out.println("adentro1");
			while((linea=br.readLine()) != null) {
				String[] partes = linea.split(";");
				String id = partes[0].trim();
				if (id_elim.equals(id)) {
					lienaAEliminar = linea;
					break;}
			}
			//System.out.println(lienaAEliminar);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error ubicando linea a eliminar");
		}
	 	ArrayList<String> lineas = new ArrayList<>();
	 	try {
            BufferedReader br = new BufferedReader(new FileReader("Datattt/Seguros.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.equals(lienaAEliminar)) {
                    lineas.add(linea);
                }
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Seguros.txt")); 
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
	public void editarSeguro(Aplicacion app, String id_edit, String Edicion) {
		HashMap<String,Seguro> seguros = app.getSeguros();
		Seguro seg =  seguros.get(id_edit);
		seg.setCostoExtra(id_edit);
		String lienaCambiar = "nada";
		String linea;
		String nombre= "";
	 	try {
			BufferedReader br = new BufferedReader(new FileReader("Datattt/Seguros.txt"));
			
			//System.out.println("adentro1");
			while((linea=br.readLine()) != null) {
				String[] partes = linea.split(";");
				String id = partes[0].trim();
				if (id_edit.equals(id)) {
					lienaCambiar = linea;
					nombre = partes[1].trim();
					break;}
			}
			//System.out.println(lienaAEliminar);
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error ubicando linea a cambiar");
		}
	 	String NuevoTexto = id_edit+";"+nombre+";"+Edicion;
	 	ArrayList<String> lineas = new ArrayList<>();
	 	try {
            BufferedReader br = new BufferedReader(new FileReader("Datattt/Seguros.txt"));
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

            BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/Seguros.txt")); 
            for (String updatedLine : lineas) {
                bw.write(updatedLine);
                bw.newLine();
            }
            bw.close();

            System.out.println("Peristencia Actualizada");
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
	public void CambiarHorariosSedes(Aplicacion app, String sede, int cambiar, LocalTime nuevaHora) {
			
		HashMap<String,Sede> sedes = app.getSedes();
		if (sedes.containsKey(sede)) {
		Sede sedeCambiar = sedes.get(sede);
			if(cambiar == 0) {
				sedeCambiar.setHoraApertura(nuevaHora);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		        String formattedTime = nuevaHora.format(formatter);
		        
				String lienaCambiar = "nada";
				String linea="";
				String nombre="";
				String horaCierre="";
				String empleados="";
				String admin="";
				String carros="";
			 	try {
					BufferedReader br = new BufferedReader(new FileReader("Datattt/Sedes.txt"));
					
					//System.out.println("adentro1");
					while((linea=br.readLine()) != null) {
						String[] partes = linea.split(";");
		                //System.out.println("adentro2.7");
		                nombre = partes[0].trim();
		                if (sede.equals(nombre)) {
							lienaCambiar = linea;
							
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
			 	String NuevoTexto = nombre+";"+formattedTime+";"+horaCierre+";"+empleados+";"+admin+";"+carros;
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
		            for (String updatedLine : lineas) {
		                bw.write(updatedLine);
		                bw.newLine();
		            }
		            bw.close();

		            System.out.println("Peristencia Actualizada");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

			}
			else if( cambiar == 1){
				sedeCambiar.setHoraCierre(nuevaHora);
				//sedeCambiar.setHoraApertura(nuevaHora);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		        String formattedTime = nuevaHora.format(formatter);
		        
				String lienaCambiar = "nada";
				String linea="";
				String nombre="";
				String horaApertura="";
				String empleados="";
				String admin="";
				String carros="";
			 	try {
					BufferedReader br = new BufferedReader(new FileReader("Datattt/Sedes.txt"));
					
					//System.out.println("adentro1");
					while((linea=br.readLine()) != null) {
						String[] partes = linea.split(";");
		                //System.out.println("adentro2.7");
		                nombre = partes[0].trim();
		                if (sede.equals(nombre)) {
							lienaCambiar = linea;
							
							horaApertura = partes[1].trim();
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
			 	String NuevoTexto = nombre+";"+horaApertura+";"+formattedTime+";"+empleados+";"+admin+";"+carros;
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
		            for (String updatedLine : lineas) {
		                bw.write(updatedLine);
		                bw.newLine();
		            }
		            bw.close();

		            System.out.println("Peristencia Actualizada");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
			else {System.out.println("No ingreso un horario para cambiar");}
		}
		else{System.out.println("La sede ingresada no existe");
}
	
}
	
	public void setTemporada(Aplicacion app, Boolean temp) {
		app.setTemporada(temp);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Datattt/temp.txt"));
			if (temp == true) {
				bw.write("true");}
			else {
				bw.write("false");}
			
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Cargando temporalidad");
		}
	}
	public void generarLog(String id) {
		 ArrayList<String> lineas = new ArrayList<>();
		 try {
				BufferedReader br = new BufferedReader(new FileReader("Datattt/reservas.txt"));
				
				String linea;
				//System.out.println("adentro1");
				while((linea=br.readLine()) != null) {
					String[] partes = linea.split(";");
					if (partes[8].equals(id)) {
					lineas.add(linea);}
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Cargando Datos Reservas");
				e.printStackTrace();
			}

		try {
			File file = new File("./Datattt/"+id+".txt");
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String linea: lineas)
            	bw.write(linea);
            bw.close();
            System.out.println("archivo log creada exitosamente.");
            
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
	}
}
