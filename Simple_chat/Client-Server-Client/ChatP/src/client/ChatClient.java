package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	public static String UserID;

	public static void main(String[] args) {
		InetAddress local;
		try {
			local = InetAddress.getLocalHost(); 
			String ip = local.getHostAddress(); 
			
			Socket c_socket = new Socket(ip, 8888);
			
			ReceiveThread rec_thread = new ReceiveThread();
			rec_thread.setSocket(c_socket);
			
			SendThread send_thread = new SendThread();
			send_thread.setSocket(c_socket);

			send_thread.start();
			rec_thread.start();

		}catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
