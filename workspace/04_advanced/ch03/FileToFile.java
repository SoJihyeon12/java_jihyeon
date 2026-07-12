package ch03;

import java.io.*;

// 4. 파일(output.txt) -> 파일(output-copy.txt)
public class FileToFile {
    void main(){
        try(
                InputStream fis = new FileInputStream("output.txt");
                OutputStream fos = new FileOutputStream("output-copy.txt")
        ){
            int readData = 0;
            while((readData = fis.read()) != -1){
                fos.write(readData);
            }
        }catch(IOException e){
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}