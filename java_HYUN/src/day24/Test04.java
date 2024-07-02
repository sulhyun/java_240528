package day24;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test04 {

	public static void main(String[] args) {
		
		int port = 3000;
		String serverIP = "192.168.20.34";
		
		try(Socket socket = new Socket(serverIP, port)) {
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
