
//Imports

	import java.io.*;
	import java.net.*;

public class Ejercicio1Cliente {

	public static void main(String[] args) {
		
		//Variables
		
			String mensaje="";
			boolean conexionCorrecta = true;
		
		//Creamos una instancia BufferedReader
		
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			
		//Objeto socket para realizar la comunicacion entre el cliente y el servidor
			
			Socket socket;
			
		//Objeto byte
			
			 byte[] mensaje_bytes = new byte[256];
			 
		//Try para capturar excepciones
			 
			 try{		 
			 
				//Instanciamos el socket con la ip y el puerto del servidor
					 
					 socket = new Socket("192.168.24.141", 8100);			 
				 
				 //Instanciamos DataOutputStream para enviar datos al servidor
				 
				 	DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				 	DataInputStream inServ = new DataInputStream(socket.getInputStream());
				 	
				 //do while para enviar al servidor los mensajes
				 	
				 	do{
				 		
				 		mensaje = buffer.readLine();
				 		
				 		//Enviamos el mensaje al servidor
				 		
				 			out.writeUTF(mensaje);
				 			
				 		//Mostramos los mensajes del servidor
				 			
				 			String mensajeServidor ="";
				 			mensajeServidor = inServ.readUTF();
				 			System.out.println(mensajeServidor);
				 		
				 	}
				 
				 	while(!mensaje.startsWith("fin"));
				 
			 }
			 
			catch(Exception e){
				
				conexionCorrecta=false;
				
				
			}
		
		
	}

}
