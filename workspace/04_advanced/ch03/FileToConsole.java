package ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

// 3. 파일(output.txt) -> 표준출력장치(콘솔), 이 코드는 파일(output.txt)의 내용을 읽어서 콘솔(화면)에 그대로 출력하는 프로그램
public class FileToConsole { // 파일의 내용을 콘솔에 출력하는 클래스
    void main(){
        try( // 자원선언 ()
                InputStream fis = new FileInputStream("output.txt") //입력 스트림 생성, 이 코드의 의미는 output.txt 파일을 읽을 준비를 한다. 입니다.
        ){ // 코드실행 {}
            int readData = 0; // 파일에서 읽은 1바이트를 저장하는 변수, 일단 0으로 초기화
            while((readData = fis.read()) != -1){ // 파일 끝까지 반복, fis.read(): 파일에서 1바이트를 읽는 메서드입니다. 파일 끝(-1)이 나올 때까지 계속 읽어라.
                System.out.write(readData); // 콘솔에 1바이트씩 출력, println()과의 차이 println()은 줄바꿈하고 write()는 줄을 바꾸지 않습니다.
            }
        }catch(IOException e){ //예외 처리, 파일이 없거나 읽는 도중 오류가 발생하면 실행됩니다.
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}