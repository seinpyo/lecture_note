package days24;

import java.io.*;
import java.net.*;
import java.util.Scanner;

//쓰레드를 이용한 TCP 통신

class Sender extends Thread{
	
	//메인에서 전달받은 socket정보를 메서드에서 사용하기 위하여
	//멤버변수로 socket변수를 선언.
	//생성자로 전달 받은 socket정보를 멤버변수 socket에 대입한다
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
				//화면에 입력한 내용을 만들어둔 말머리와 함께 전송
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

public class TcpipServer03 {
	public static void main(String[] args) {
		ServerSocket sS = null;
		Socket s = null;
		try {
			sS = new ServerSocket(5555);
			System.out.println("서버가 준비되었습니다.");
			s = sS.accept(); //s에 연결 및 상대 클라이언트 정보 저장
			
			 //소켓의 정보를 사용하기 위해 생성자로 전달해줌
			Sender sender = new Sender(s);
			Receiver receiver = new Receiver(s);
			sender.start();		//정보를 보내기 위한 쓰레드
			receiver.start();	//정보를 받아오기 위한 쓰레드
			
		} catch (IOException e) {e.printStackTrace();} 

	}
}
