package ch03;
// 이 코드는 output.txt 파일의 내용을 읽어서 output-copy.txt라는 새로운 파일에 복사하는 프로그램
// FileToFile 파일 → 파일

import java.io.*;

// 4. 파일(output.txt) -> 파일(output-copy.txt)
public class FileToFile { // 파일의 내용을 다른 파일로 복사하는 클래스
    void main(){
        try( // 자원선언 ()
                InputStream fis = new FileInputStream("output.txt"); // output.txt 파일을 읽기 위한 입력 스트림을 생성한다.
                OutputStream fos = new FileOutputStream("output-copy.txt") // 출력 스트림 생성, output-copy.txt 파일을 생성하고 데이터를 저장할 준비를 한다.
        ){ // 실행코드 {}
            int readData = 0; // 파일에서 읽은 1바이트를 저장하는 변수입니다.
            while((readData = fis.read()) != -1){ // 파일 끝까지 반복, 파일 끝(-1)이 나올 때까지 계속 반복하라.
                fos.write(readData); // 읽은 1바이트를 복사 파일에 계속 저장합니다. 결국 내용이 완전히 동일한 복사파일이 생성됩니다. println()과의 차이 println()은 줄바꿈하고 write()는 줄을 바꾸지 않습니다.
            }
        }catch(IOException e){ // 예외 처리
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}