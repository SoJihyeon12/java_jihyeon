package ch04.echo.multi;

import java.io.*;
import java.net.Socket;

public class EchoServerTask implements Runnable{
    private final Socket s;

    EchoServerTask(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try(Socket clientSocket = this.s){
            // 클라이언트의 메세지를 수신하는 InputStream 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 클라이언트에 메세지를 송신하는 OutputStream 생성
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

            String readData = "";
            while((readData = in.readLine()) != null){
                out.println("서버의 응답: " + readData); // 클라이언트에 메세지 반송
                System.out.println(readData); // 클라이언트의 메세지를 서버에도 출력
            }
        }catch(IOException e){
            System.err.println("네트워크 예외 발생: " + e.getMessage());
        }
    }
}