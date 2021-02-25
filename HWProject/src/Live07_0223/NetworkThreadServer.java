package Live07_0223;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkThreadServer {
	public static void main(String[] args) {
		int port = 5100;
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			System.out.println("NetworkThreadServer Started");
			
			while (true) {
				Socket socket = serverSocket.accept();
				NetworkThread thread = new NetworkThread(socket);
				thread.start();
			}
			
		 } catch (IOException e) {
			 System.out.println("NetworkThreadServer exception: " + e.getMessage());
			 e.printStackTrace();
		 }
	}
}
