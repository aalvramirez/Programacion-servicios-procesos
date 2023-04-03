package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private final String HOST = "localhost";
	private final int PUERTO = 3306;
	private Socket socket;

	public Client() throws IOException {
		socket = new Socket(HOST, PUERTO);}

	public void iniciarCliente() throws IOException {
		
		//Creamos objeto scanner para leer
	  Scanner scanner = new Scanner(System.in);
		
	  
	  try {
		//Obtenemos mensaje del server
		DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());
		//Enviamos respuesta
		DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());
		System.out.println(entradaServidor.readUTF()); 
		salidaServidor.writeUTF(scanner.nextLine());
		System.out.println(entradaServidor.readUTF());
		
		int cantTareas = Integer.parseInt(scanner.nextLine());
		salidaServidor.writeInt(cantTareas);
		
		for(int i=1; i<=cantTareas; i++) {
			System.out.println(entradaServidor.readUTF());
			salidaServidor.writeUTF(scanner.nextLine());
			System.out.println(entradaServidor.readUTF());
			salidaServidor.writeUTF(scanner.nextLine());}
		
		System.out.println(entradaServidor.readUTF());
		for(int i=0; i<cantTareas; i++) {
			System.out.println(entradaServidor.readUTF());}

		scanner.close();
		salidaServidor.close();
		entradaServidor.close();
		socket.close();
		
	  } catch (IOException ex) {
		  System.err.println("No se pudo conectar");}	  }
			
	}