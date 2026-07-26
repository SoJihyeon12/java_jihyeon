package ch04.webserver;
// 이 코드는 여러 명의 클라이언트가 동시에 접속할 수 있는 멀티스레드 웹 서버입니다.
// 앞에서 배운 EchoServer는 한 명의 클라이언트만 처리할 수 있었지만,
// WebServerMulti는 클라이언트가 접속할 때마다 새로운 스레드(Thread)를 만들어 동시에 여러 명을 처리할 수 있습니다.

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트로부터 수신된 메세지를 그대로 반송
// 네트워크 프로그램 개발 시 가장 먼저 만들어서 클라이언트와 서버간의 통신 상태를 확인하는데 사용
public class WebServerMulti { // 웹 서버를 실행하고 여러 클라이언트를 동시에 처리하는 클래스를 만듦
    void startServer(){ // 웹 서버를 시작하는 메서드입니다.
        try( // 자원 선언 ()
                // 서버소켓 생성, 웹 서버를 만들고 8080번 포트를 엽니다. 개발할 때는 8080을 많이 사용함
                ServerSocket ss = new ServerSocket(8080)
        ){
            System.out.println("웹서버 구동 완료 8080"); // 서버 시작 출력

            while(true){ // 무한 반복
                // 클라이언트의 접속 대기, accept()는 클라이언트가 접속할 때까지 기다리는 메서드입니다.
                Socket s = ss.accept(); // 블로킹 작업, 클라이언트가 올 때까지 다음 코드 실행 안 함이라는 의미
                System.out.println("클라이언트 접속: " + s.getInetAddress().getHostAddress());
                WebServerTask worker = new WebServerTask(s); // new WebServerTask(s): 클라이언트 한 명을 처리할 작업 객체를 만드는 것, 클라이언트가 3명 접속하면 server1, server2, server3이 생성됨, s는 소켓의 s
                new Thread(worker).start(); // 새로운 스레드 생성, new Thread(worker):worker를 실행할 스레드를 생성합니다. .start();:스레드를 시작합니다.
            }
            //왜 스레드를 사용할까? 만약 스레드를 사용하지 않으면 한 명씩만 처리할 수 있습니다. 하지만 스레드를 사용하면 여러명 동시에 처리 가능

        }catch(IOException e){ // 예외 처리
            System.err.println("네트워크 오류: " + e.getMessage());
        }
    }

    void main(){ // 프로그램이 시작되면 startServer();를 호출하여 웹 서버를 실행합니다.
        startServer();
    }
}