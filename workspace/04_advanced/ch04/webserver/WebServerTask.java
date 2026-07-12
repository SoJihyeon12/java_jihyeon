package ch04.webserver;

import java.io.*;
import java.net.Socket;

public class WebServerTask implements Runnable{
    private final Socket s;

    WebServerTask(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try(Socket clientSocket = this.s){
            // 클라이언트의 메세지를 수신하는 InputStream 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 클라이언트에 메세지를 송신하는 OutputStream 생성
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

            // 클라이언트가 전달하는 1줄
            String line = "";

            System.out.println("===== 요청 헤더 시작 =====");

            String requestLine = in.readLine();
            String[] requestLineArr = requestLine.split(" ");
            String url = requestLineArr[1];
            System.out.println("URL: " + url);

            System.out.println(requestLine);
            while((line = in.readLine()) != null){
                if(line.isEmpty()){ // 빈줄일 경우 요청 헤더의 끝을 나타냄
                    break;
                }
                System.out.println(line);
            }
            System.out.println("===== 요청 헤더 종료 =====");

            // HTTP 응답 헤더 작성
            String header = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html; charset=UTF-8\r\n";

            String body = loadFile(url.substring(1));
            System.out.println(body);

            out.println(header);
            out.println(body);
            out.close();
        }catch(IOException e){
            System.err.println("네트워크 예외 발생: " + e.getMessage());
        }
    }

    String loadFile(String path){
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader("resources/" + path))){
            String line = "";
            while((line = br.readLine()) != null){
                result += line;
            }
        }catch(IOException e){
            System.err.println("파일 읽기 실패. "+ e.getMessage());
        }
        return result;
    }
}