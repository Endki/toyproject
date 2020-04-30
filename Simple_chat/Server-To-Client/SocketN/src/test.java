import java.net.InetAddress;
import java.net.UnknownHostException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress local; try { local = InetAddress.getLocalHost(); String ip = local.getHostAddress(); System.out.println("local ip : "+ip); } catch (UnknownHostException e1) { e1.printStackTrace(); }

		
	}

}
