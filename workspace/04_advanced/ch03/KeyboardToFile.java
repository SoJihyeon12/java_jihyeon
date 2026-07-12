package ch03;

import java.io.FileOutputStream;
import java.io.IOException;

// 2. 표준입력장치(키보드) -> 파일(output.txt)
public class KeyboardToFile {
    void main(){
        try(
             FileOutputStream fos = new FileOutputStream("output.txt")
        ){
            // 표준 입력 장치로부터 1byte 읽어온다.
            int readData = 0;

            while((readData = System.in.read()) != -1){
                // 표준 출력 장치로 1byte 출력한다.
                fos.write(readData);
            }

        }catch(IOException e){
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
