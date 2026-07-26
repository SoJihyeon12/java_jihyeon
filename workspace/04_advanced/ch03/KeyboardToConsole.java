package ch03;
// 키보드로 입력한 내용을 1바이트씩 읽어서 그대로 콘솔(화면)에 출력하는 프로그램

import java.io.IOException;

// 1. 표준입력장치(키보드) -> 표준출력장치(콘솔)
public class KeyboardToConsole { // 키보드로 입력한 내용을 콘솔에 출력하는 클래스
    void main(){
        try{ // 입출력 작업 중에는 오류가 발생할 수 있으므로 try로 감쌉니다.
            int readData = 0; // 키보드에서 읽은 1바이트의 데이터를 저장하는 변수

            while((readData = System.in.read()) != -1){ // 키보드에서 1바이트를 읽는다. readData에 저장한다. -1이 아니면 반복한다.
                // 표준 출력 장치로 1byte 출력한다.
                System.out.write(readData); // readData에 저장된 1바이트를 그대로 화면에 출력합니다. println()과의 차이 println()은 줄바꿈하고 write()는 줄을 바꾸지 않습니다.
            }

        }catch(IOException e){ // 예외 처리, 입출력 중 오류가 발생하면 실행됩니다.
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
