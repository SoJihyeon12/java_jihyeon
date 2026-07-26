package ch03;
// 키보드로 입력한 내용을 output.txt 파일에 저장하는 프로그램

import java.io.FileOutputStream;
import java.io.IOException;

// 2. 표준입력장치(키보드) -> 파일(output.txt)
public class KeyboardToFile { // 키보드로 입력한 내용을 파일에 저장하는 클래스
    void main(){
        try( // 자원 선언 ()
             FileOutputStream fos = new FileOutputStream("output.txt") // 출력 스트림 생성, output.txt 파일을 만들고 데이터를 쓸 준비를 한다.
        ){ // 코드 실행 {}
            // 표준 입력 장치로부터 1byte 읽어온다.
            int readData = 0; // 키보드에서 읽은 1바이트의 데이터를 저장하는 변수입니다. 0으로 초기화

            while((readData = System.in.read()) != -1){ // 키보드에서 1바이트를 읽는다. readData에 저장한다. 입력 종료가 아니면 계속 반복한다.
                // 표준 출력 장치로 1byte 출력한다.
                fos.write(readData); // readData에 저장된 1바이트를 output.txt에 저장합니다.
            }

        }catch(IOException e){ // 예외 발생
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
