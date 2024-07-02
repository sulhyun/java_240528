package day24;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test03 {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		int port = 3000;
		
		ServerSocket server;
		
		try {
			server = new ServerSocket(port);
			Socket client = server.accept();
			while(true) {
				
			}
		} catch(Exception e) {
			
		}
	}

}
