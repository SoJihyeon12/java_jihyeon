package ch04.webserver;
// 이 코드는 웹 서버에서 클라이언트(브라우저) 한명의 요청을 처리하는 작업 클래스이다.
// 앞에서 본 WebServerMulti는 클라이언트가 접속하면 WebServerTask를 새로운 스레드에서 실행했습니다.
// 이 클래스 WebServerTask는 클라이언트 한 명의 요청을 받아서 HTML 파일을 읽고 응답을 보내는 역할을 합니다.
// 즉, 브라우저의 요청(URL)을 받아 해당 파일을 찾아 읽고, HTTP 형식으로 응답을 보내는 간단한 웹 서버의 핵심 처리 클래스입니다.

import java.io.*;
import java.net.Socket;

public class WebServerTask implements Runnable{ // implements Runnable: 이 클래스는 Thread에서 실행될 수 있는 클래스이다.
    private final Socket s; // 클라이언트와 연결된 소켓입니다. final이므로 한 번 저장하면 바꿀 수 없다.

    WebServerTask(Socket s){ // 생성자, 앞에서 본 WebServerMulti에서 new WebServerTask(s);를 실행하면 이 생성자가 호출됨 그러면 this.s = s가 되어 클라이언트와 연결됨
        this.s = s;
    }

    @Override
    public void run() { //Thread가 시작되면 가장 먼저 실행되는 메서드입니다.
        try(Socket clientSocket = this.s){ // 클라이언트 소켓을 사용합니다. 자원 선언 ()
            // 클라이언트의 메세지를 수신하는 InputStream 생성, 브라우저가 보낸 요청을 한 줄씩 읽기 위한 객체인 BufferedReader 생성, 왜 BufferedReader를 사용할까요? 호스트, 커넥션 등 여러줄을 하나씩 읽는 것
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 클라이언트에 메세지를 송신하는 OutputStream 생성, 브라우저에게 텍스트를 보내는 객체인 PrintWriter 생성
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

            // 클라이언트가 전달하는 1줄
            String line = "";

            System.out.println("===== 요청 헤더 시작 ====="); //요청 헤더(Request Header) 는 클라이언트가 서버에게 요청을 보낼 때 함께 보내는 추가 정보입니다. 요청에 대한 설명서" 또는 "요청의 부가 정보"라고 생각하면 됩니다.

            String requestLine = in.readLine(); // HTTP 요청의 첫 줄을 읽고 저정함
            String[] requestLineArr = requestLine.split(" "); // 공백(띄어쓰기) 기준으로 나눕니다.
            String url = requestLineArr[1]; // URL 추출, 배열의 1번에는 /index.html이 들어있다. 그래서 url변수에 저장함
            System.out.println("URL: " + url);

            System.out.println(requestLine);
            while((line = in.readLine()) != null){ // 요청 헤더 읽기, 한줄씩 읽기
                if(line.isEmpty()){ // 빈줄일 경우 종료, 빈 줄이 요청 헤더의 끝을 의미합니다.
                    break;
                }
                System.out.println(line);
            }
            System.out.println("===== 요청 헤더 종료 =====");

            // HTTP 응답 헤더 작성, 브라우저에게 아래 초록색 내용을 보냄
            String header = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html; charset=UTF-8\r\n";
            // 실제 HTTP 응답은 응답 헤더 뒤에 빈 줄(\r\n)이 하나 더 있어야 헤더와 본문이 구분됩니다.
            // 예제에서는 println()을 사용하면서 줄바꿈이 추가되므로 동작할 수 있지만, 실제 웹 서버에서는 헤더 종료를 명확하게 표시하는 것이 중요합니다.

            String body = loadFile(url.substring(1)); // HTML 파일 읽기, substring()은 문자열에서 원하는 부분(인덱스 시작부분부터)만 꺼내는 기능, url이 /index.html이라면 인덱스 1번부터라면 index.html만 꺼내줌
            System.out.println(body);

            //응답 보내기
            out.println(header); //응답 헤더 전송
            out.println(body); // HTML 전송
            out.close(); // 브라우저와의 연결을 종료합니다.
        }catch(IOException e){
            System.err.println("네트워크 예외 발생: " + e.getMessage());
        }
    }

    String loadFile(String path){
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader("resources/" + path))){ // 최종적으로 resources/index.html을 읽는다.
            String line = "";
            while((line = br.readLine()) != null){ // 파일 끝까지 한 줄씩 읽어서 result에 저장합니다.
                result += line;
            }
        }catch(IOException e){
            System.err.println("파일 읽기 실패. "+ e.getMessage());
        }
        return result;
    }
}