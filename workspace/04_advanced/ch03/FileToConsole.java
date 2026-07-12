package ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

// 3. 파일(output.txt) -> 표준출력장치(콘솔)
public class FileToConsole {
    void main(){
        try(
                InputStream fis = new FileInputStream("output.txt")
        ){
            int readData = 0;
            while((readData = fis.read()) != -1){
                System.out.write(readData);
            }
        }catch(IOException e){
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}