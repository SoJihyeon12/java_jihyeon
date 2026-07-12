package ch04.echo.multi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트로부터 수신된 메세지를 그대로 반송
// 네트워크 프로그램 개발 시 가장 먼저 만들어서 클라이언트와 서버간의 통신 상태를 확인하는데 사용
public class EchoServerMulti {
    void startServer(){
        try(
                // 서버소켓 생성
                ServerSocket ss = new ServerSocket(50000)
        ){
            System.out.println("ServerSocket 생성 완료.");

            while(true){
                // 클라이언트의 접속 대기
                Socket s = ss.accept(); // 블로킹 작업
                System.out.println("클라이언트 접속: " + s.getInetAddress().getHostAddress());
                EchoServerTask worker = new EchoServerTask(s);
                new Thread(worker).start();
            }

        }catch(IOException e){
            System.err.println("네트워크 오류: " + e.getMessage());
        }
    }

    void main(){
        startServer();
    }
}