package jaffa.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	public static void main(String[] args) throws IOException{
		//reads in a line and sends a message
		ServerSocket serverSocket = new ServerSocket(52746);

		//wait for a response
		Socket socket = serverSocket.accept();

		// read outputstream to the screen
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String response = reader.readLine();

		System.out.println("RESPONSE");
		System.out.println(response);

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HOW ARE YOU DOING?\n");
		out.flush();

		serverSocket.close();
	}

}