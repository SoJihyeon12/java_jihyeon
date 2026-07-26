package ch04.echo;
// 코드는 에코(Echo) 클라이언트, 클라이언트(Client) 는 서비스를 요청하는 쪽입니다.
// 반대로 서비스를 제공하는 쪽은 서버(Server) 입니다.
// 에코(Echo)란 내가 보낸 데이터를 서버가 그대로 다시 돌려주는 기능입니다.
// 내가 보낸 데이터를 서버가 그대로 다시 보내주기 때문에 Echo(메아리)라고 부릅니다.
// 즉, 키보드 → 클라이언트 → 서버 → 클라이언트 → 콘솔 순서로 데이터가 이동하며, 서버는 받은 데이터를 그대로 다시 보내 주는 역할을 합니다.

import java.io.*;
import java.net.Socket;

public class EchoClient { // 서버에 접속해서 데이터를 보내고 다시 받는 클래스 만듦
    void startClient(){
        try(
                // 서버에 접속 요청(localhost:50000)
                Socket s = new Socket("localhost", 50000); // 소켓(Socket)은 네트워크를 통해 데이터를 주고받는 통신 창구입니다. 소켓을 통해 클라이언트와 서버가 교류, "localhost": 내 컴퓨터를 의미, 50000은 포트번호, 포트번호는 프로그램의 번호를 말함,
                // 내 컴퓨터(localhost)의 50000번 포트에서 실행 중인 서버에 접속하라.

//                Socket s = new Socket("dain2.iptime.org", 50000);

                // Socket에서 데이터를 읽을 수 있는 통로인 InputStream 생성
                InputStream in = s.getInputStream();

                // Socket으로 데이터를 전송할 수 있는 통로인 OutputStream 생성
                OutputStream out = s.getOutputStream()
        ){
            System.out.println("서버 접속 완료.");
            int readData = 0; // 키보드에서 입력한 1Byte를 저장합니다.
            while((readData = System.in.read()) != -1){ // 키보드에서 1Byte씩 읽습니다.
                out.write(readData); // 입력한 데이터를 서버로 보냅니다.
                int echoData = in.read(); // 서버가 보낸 데이터 받기
                System.out.write(echoData); // 받은 데이터를 화면에 출력합니다.
            }
        }catch(IOException e){ // 예외처리
            System.err.println("네트워크 오류 발생: " + e.getMessage());
        }
    }

    void main(){ // 이 코드는 main() 메서드에서 startClient() 메서드를 호출하는 코드입니다.
        startClient();
    }
}