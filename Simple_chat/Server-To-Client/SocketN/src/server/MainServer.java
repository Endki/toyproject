package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket s_socket=new ServerSocket(8888);
			
			Socket c_socket=s_socket.accept();
			
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
