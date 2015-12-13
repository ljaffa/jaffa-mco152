package jaffa.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

	public static void main(String[] args) throws UnknownHostException, IOException{
		String serverIP = "192.168.117.144";
		Socket socket = new Socket(serverIP, 52746);

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("Hi There!\n");
		out.flush();

		// read outputstream to the screen
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String response = reader.readLine();

		System.out.println("RESPONSE");
		System.out.println(response);

		socket.close();
	}

}