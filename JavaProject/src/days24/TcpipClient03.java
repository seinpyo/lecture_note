package days24;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpipClient03 {

	public static void main(String[] args) {
		String severIp = "192.168.0.27";
		try {
			Socket s = new Socket(severIp, 5555);
			System.out.println("서버에 연결되었습니다.");
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);
			sender.start();
			receiver.start();
		} catch (UnknownHostException e) { e.printStackTrace(); 
		} catch (IOException e) {e.printStackTrace();}
		catch (Exception e) {e.printStackTrace();}
		
	}

}
