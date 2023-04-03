package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private final int PUERTO = 3306;
	private ServerSocket serverSocket;
	private Socket socket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(PUERTO);
		socket = new Socket(); 
	}

	public void iniciarServer() throws IOException {
		while (true) {
			System.out.println("Esperando la conexion del cliente");
			socket = serverSocket.accept();
			
			DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());
			DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());
			salidaServidor.writeUTF("Peticion rebida, escribe tu nombre");
			System.out.println(entradaServidor.readUTF());
	
			salidaServidor.writeUTF("Escribe la cantidad de tareas que quieres realizar");
			int cantTareas = entradaServidor.readInt();
	        System.out.println(cantTareas);
	        Tarea [] tareas = new Tarea[cantTareas];
			
	        //Bucle para tareas
	        for (int i = 1; i <= cantTareas; i++ ){
                Tarea laTarea = new Tarea();
                salidaServidor.writeUTF("Describe la tarea numero " + i );
                laTarea.setDescription(entradaServidor.readUTF());
                salidaServidor.writeUTF("Introduce el estado de la tarea: ");
                laTarea.setEstado(entradaServidor.readUTF());
                tareas[i-1] = laTarea;
            }
	        
	        salidaServidor.writeUTF("Tareas a realizar: ");
            for (int i = 0; i <cantTareas; i++){
            	salidaServidor.writeUTF("La tarea " + tareas[i].getDescripcion() + 
                		" con estado " + tareas[i].getEstado());
            }
			
			System.err.println("Fin de la conexion");
			socket.close();
		}
	}

	public void finalizarServer() throws IOException {
		serverSocket.close();
		System.out.println("Servidor cerrado");
	}

}
