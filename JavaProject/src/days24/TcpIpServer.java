package days24;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		try {
			ss = new ServerSocket(7777);
			System.out.println(f.format(new Date()) + "서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("서버 설정에 실패하였습니다.");
			return;
		}
		
		try {
			System.out.println(f.format(new Date()) + "연결 요청을 기다립니다.");
			Socket s = ss.accept();
			System.out.println(f.format(new Date()) + s.getInetAddress() + "로 부터 연결 요청이 들어왔습니다.");
			//s.getInetAddress() : 클라이언트의 아이피 주소를 추출하는 메소드
			
			//클라이언트에게 메세지를 전송(출력)할 수 있는 권한을 Socket s로 부터 얻어서 
			// OutputStream 객체에 저장
			OutputStream out = s.getOutputStream();
			
			//권한에 실제 출력 도구를 포함하려면 out을 생성자로 전달한 DataOutputStream객체 필요
			DataOutputStream dos = new DataOutputStream(out);
			//최종 통신 출력 도구 : dos
			
			//dos를 통해 클라이언트에게 간단 메세지를 전송
			dos.writeUTF("[System] 연결에 성공하였습니다. (204호 00번 서버)");
			dos.close();
			s.close();
			
		} catch (IOException e) { e.printStackTrace(); }

		try {
			ss.close();
		} catch (IOException e) { e.printStackTrace(); }
		
		
	}
}