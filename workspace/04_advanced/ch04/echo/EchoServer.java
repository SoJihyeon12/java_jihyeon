package ch04.echo;
// 이 코드는 에코(Echo) 서버입니다. 에코 서버는 클라이언트가 보낸 데이터를 그대로 다시 클라이언트에게 돌려주는 서버입니다.

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트로부터 수신된(받은) 메세지를 그대로 반송
// 네트워크 프로그램 개발 시 가장 먼저 만들어서 클라이언트와 서버간의 통신 상태를 확인하는데 사용
public class EchoServer {
    void startServer(){ // 서버를 시작하는 메서드입니다.
        try( // 자원 선언()
                // 서버소켓 생성
                ServerSocket ss = new ServerSocket(50000) // ServerSocket은 클라이언트의 접속을 기다리는 서버용 소켓입니다. 손님이 문을 열고 들어오기를 기다리는 것과 같습니다. 50000번 포트를 사용하는 서버를 만든다는 뜻입니다.
        ){ // 코드 실행 {}
            System.out.println("ServerSocket 생성 완료.");

            // 클라이언트의 접속 대기
            Socket s = ss.accept(); // 클라이언트가 접속할 때까지 기다려라=블로킹 작업, 즉, 클라이언트가 없으면 계속 기다리고 클라이언트가 접속하면 다음코드 실행한다.
            System.out.println("클라이언트 접속: " + s.getInetAddress().getHostAddress()); // s.getInetAddress(): 접속한 클라이언트의 IP 주소를 가져옵니다. getHostAddress(): IP를 문자열로 반환합니다.

            // 클라이언트의 메세지를 수신하는(받는) InputStream 생성
            InputStream in = s.getInputStream();
            // 클라이언트에 메세지를 송신하는(보내는) OutputStream 생성
            OutputStream out = s.getOutputStream();

            int readData = 0; // 클라이언트가 보낸 1바이트를 저장하는 변수입니다.
            while((readData = in.read()) != -1){ // 클라이언트가 보낸 데이터를 1바이트씩 계속 읽습니다. 클라이언트가 ABC를 보내면 A, B, C 를 하나씩 읽는 것
                out.write(readData); // 클라이언트에 메세지 반송(다시 보내기)
                System.out.write(readData); // 클라이언트의 메세지를 서버화면에도 출력
            }
        }catch(IOException e){ // 예외 처리
            System.err.println("네트워크 오류: " + e.getMessage());
        }
    }

    void main(){ // main()에서 startServer();를 호출하여 서버를 실행한다.
        startServer();
    }
}