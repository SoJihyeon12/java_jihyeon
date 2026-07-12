package ch04.echo;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    void startClient(){
        try(
                // 서버에 접속 요청(localhost:50000)
                Socket s = new Socket("localhost", 50000);
//                Socket s = new Socket("dain2.iptime.org", 50000);
                // Socket에서 데이터를 읽을 수 있는 InputStream 생성
                InputStream in = s.getInputStream();
                // Socket으로 데이터를 전송할 수 있는 OutputStream 생성
                OutputStream out = s.getOutputStream()
        ){
            System.out.println("서버 접속 완료.");
            int readData = 0;
            while((readData = System.in.read()) != -1){
                out.write(readData);
                int echoData = in.read();
                System.out.write(echoData);
            }
        }catch(IOException e){
            System.err.println("네트워크 오류 발생: " + e.getMessage());
        }
    }

    void main(){
        startClient();
    }
}