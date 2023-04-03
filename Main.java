package client;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Aquí creamos objetos de Cliente
		Client c = new Client();
		System.out.println("Cliente conectado");
		
		//Ahora iniciamos la conexión.
		c.iniciarCliente();
		
	}

}
