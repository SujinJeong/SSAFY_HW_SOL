package Live07_0223;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class NetworkThread extends Thread{
	Socket client;
	
	public NetworkThread() {}
	public NetworkThread(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		try {
			OutputStream output = client.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			writer.println("Hello SSAFY!");			
		} catch (IOException e) {
			 System.out.println("NetworkSimpleServer exception: " + e.getMessage());
			 e.printStackTrace();
		}

	}
}	