package client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket c_socket=new Socket("1.236.143.171",8888);
			
			ReceiveThread rec_thread=new ReceiveThread();
			rec_thread.setSocket(c_socket);
			
			SendThread send_thread = new SendThread();
			send_thread.setSocker(c_socket);
			
			rec_thread.start();
			send_thread.start();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
