
//Hacemos los imports necesarios

import java.net.*;
import java.io.*;
import java.util.Date;

public class Ejercicio2Servidor {

	public static void main(String[] args)throws IOException {

		//Puerto al que escucha el servidor
		
			int puerto = 8100;
			
		byte msg [] = new byte[1024];
		
		//Creamos el socket del servidor UDP
		
			try{
				
				DatagramSocket socketServidor = new DatagramSocket(puerto);
				System.out.println("Servidor activo.");
				socketServidor.setSoTimeout(40000);
				
				//Bucle infinito para implementar el protocolo del servidor
				
					while(true){
						
						DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024);
						
						//Llega un datagrama
						
							socketServidor.receive(recibido);
							System.out.println("Peticion procedente de la direccion: "+recibido.getAddress()+" y puerto: "+recibido.getPort());
							System.out.println("Mesnaje recibido: "+new String(recibido.getData()));
							
						//Mensaje que envia el servidor
							
							String mensaje="";
							mensaje = Entrada.cadena();
							msg = mensaje.getBytes();
							
						//Datagram que contiene el mensaje del servidor que va a enviar al cliente
							
							DatagramPacket mensajeServidor = new DatagramPacket(msg,msg.length,recibido.getAddress(),recibido.getPort());
							
						//Enviamos el paquete al cliente
							
							socketServidor.send(mensajeServidor);
						
					}
					
				
			}
			
			catch(SocketTimeoutException e){
				
				System.out.println("40 segs sin recibir nada.");
				
			}
		
	}

}
