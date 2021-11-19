package days24;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpipServer02 {
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
			ss.setSoTimeout(10000);
			// 서버 소켓이 클라이언트의 요청을 기다리는 시간 설정.
			// 설정된 시간이 지날 때까지 요청이 없으면 SocketTimeoutException 예외가 발생
			// ss.close()를 쓰지 않아도 10000밀리초 후 자동으로 ss가 종료된다.
			// 한번 연결이 되면 다음 연결이 또 있을 때까지 설정한 시간만큼 연장된다.
			Socket s = ss.accept();
			System.out.println(f.format(new Date()) + s.getInetAddress() + "로 부터 연결 요청이 들어왔습니다.");
			OutputStream out = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF("[System] 연결에 성공하였습니다. (204호 00번 서버)");
			dos.close();
			s.close();

		} catch (SocketTimeoutException e) {
			System.out.println(f.format(new Date()) + "접속 시간 초과. 서버를 종료합니다.");
			System.exit(0); // return과 비슷한 프로그램 종료 명령
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
