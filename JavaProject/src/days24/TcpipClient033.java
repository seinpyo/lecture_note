
import java.io.*;
import java.net.*;
import java.util.Scanner;

class Sender extends Thread{
	
	//���ο��� ���޹��� socket������ �޼��忡�� ����ϱ� ���Ͽ�
	//��������� socket������ ����.
	//�����ڷ� ���� ���� socket������ ������� socket�� �����Ѵ�
	Socket socket; 
	DataOutputStream out;
	String name;
	
	Sender(Socket s) {
		socket = s;
		while (out != null) {
			
		}
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = "[" + socket.getInetAddress()+ ":" + socket.getPort() + "]";
		} catch (IOException e) { e.printStackTrace();
		}
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(out!=null) {
			try {
				out.writeUTF(name + sc.nextLine());
				//ȭ�鿡 �Է��� ������ ������ ���Ӹ��� �Բ� ����
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Receiver extends Thread{
	
	Socket socket;
	DataInputStream in;
	Receiver(Socket s) {
		socket = s;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) { e.printStackTrace();
		}
	}
	
	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {e.printStackTrace();}
		}
	}
}

public class TcpipClient033 {

	public static void main(String[] args) {
		String severIp = "192.168.0.27";
		try {
			Socket s = new Socket(severIp, 5555);
			System.out.println("������ ����Ǿ����ϴ�.");
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);
			sender.start();
			receiver.start();
		} catch (UnknownHostException e) { e.printStackTrace(); 
		} catch (IOException e) {e.printStackTrace();}
		catch (Exception e) {e.printStackTrace();}
		
	}

}
