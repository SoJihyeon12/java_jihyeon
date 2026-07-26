package ch03;
// 이 코드는 파일을 복사하는 방법을 3가지 방식으로 비교하는 예제
// 핵심은 파일을 읽어서(Output) 다른 파일에 그대로 쓰는(Input) 것입니다.

import java.io.*;

// 4. 파일(output.txt) -> 파일(output-copy.txt)
public class FileCopyTest {
    void main(){
        long start = System.currentTimeMillis();

//        copyFile("lib/mysql-connector-j-9.7.0.jar", "mysql-connector-j-9.7.0.jar"); // copyFile()은 버퍼를 사용하지 않고 한 바이트씩 복사하는 방식(일반적으로), copyFile(원본파일경로, 복사될파일이름(또는 경로))
//        copyFileUseBuffer("lib/mysql-connector-j-9.7.0.jar", "mysql-connector-j-9.7.0.jar"); //copyFileUseBuffer는 버퍼를 이용해서 파일을 복사하는 메서드, (원본파일경로, 복사될파일이름(또는 경로))
        copyFileCustomBuffer("lib/mysql-connector-j-9.7.0.jar", "mysql-connector-j-9.7.0.jar"); // copyFileCustomBuffer는 직접 만든 버퍼를 이용해서 파일을 복사하는 메서드, (원본파일경로, 복사될파일이름(또는 경로))

        long end = System.currentTimeMillis(); // 이 코드는 프로그램이 실행되는 데 걸린 시간을 측정하여 출력하는 코드, System.currentTimeMillis(): 현재 시간을 밀리초(ms) 단위로 반환하는 메서드
        System.out.println("소요시간: " + (end-start) + "ms");
    }

    /**
     * 1차 스트림(FileInputStream, FileOutputStream)을 이용해서 파일을 복사한다.
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFile(String org, String dest){ // 이 메서드는 원본 파일을 1바이트씩 읽어서 다른 파일로 복사하는 메서드, org : 원본 파일의 경로, dest : 복사해서 저장할 파일의 경로
        try( // 괄호 () 안에는 try에서 사용할 자원(Resource)을 선언하는 부분, try문이 2개인 것이 아니다.
                // 여기서는 두 개의 객체를 생성합니다.
                InputStream fis = new FileInputStream(org); //원본 파일을 읽기 위한 입력 스트림(통로)을 생성한다.
                OutputStream fos = new FileOutputStream(dest) //복사한 내용을 저장할 출력 스트림(통로)을 생성한다.
        ){ // {} 이부분은 실행할 코드
            int readData = 0; //파일에서 읽은 1바이트의 데이터를 저장하는 변수, 일단 0으로 초기화함
            while((readData = fis.read()) != -1){ // 파일 끝까지 반복, fis.read():파일에서 1바이트를 읽습니다. 파일 끝(EOF, End Of File)에 도착하면 -1이라는 데이터를 반환한다, 그래서 -1(파일 끝)이 아닐때까지 반복
                fos.write(readData); // 읽은 데이터를 그대로 복사 파일에 저장합니다.
            }
        }catch(IOException e){ // 예외 처리, IOException 타입의 예외 객체를 e라는 이름으로 받겠다.
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }

    /**
     * 2차 스트림(BufferedInputStream, BufferedOutputStream)을 이용해서 파일을 복사한다.
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFileUseBuffer(String org, String dest){ // 이 메서드는 버퍼(Buffer)를 사용해서 파일을 복사하는 메서드, 버퍼(Buffer)는 데이터를 잠시 저장해 두는 임시 저장 공간, 예를 들어 버퍼 크기가 8KB라면 파일에서 한 번에 8KB를 읽어 버퍼에 저장, 그 후 프로그램은 버퍼에서 데이터를 하나씩 가져옵니다.  org : 원본 파일의 경로, dest : 복사해서 저장할 파일의 경로
        try(
                // 이 코드는 두 객체를 함께 사용합니다.
                InputStream fis = new BufferedInputStream(new FileInputStream(org)); // 8KB의 버퍼를 사용, 원본 파일을 읽기 위한 스트림을 만듭니다. FileInputStream을 BufferedInputStream으로 감쌉니다. 이렇게 하면 버퍼를 이용하여 데이터를 읽게 됩니다.
                OutputStream fos = new BufferedOutputStream(new FileOutputStream(dest)) // 출력 스트림 생성, 바로 파일에 쓰는 것이 아니라 먼저 버퍼에 저장합니다. 버퍼가 가득 차면 한 번에 파일로 저장합니다.
        ){
            int readData = 0; //파일에서 읽은 1바이트의 데이터를 저장하는 변수, 일단 0으로 초기화함
            while((readData = fis.read()) != -1){ // fis.read():파일에서 1바이트를 읽습니다(가져옵니다). 파일 끝(EOF, End Of File)에 도착하면 -1이라는 데이터를 반환한다, 그래서 -1(파일 끝)이 아닐때까지 반복
                fos.write(readData); //읽은 데이터를 버퍼에 씁니다. 버퍼가 가득 차면 파일로 한번에 저장됨
            }
        }catch(IOException e){ // 예외 처리, IOException 타입의 예외 객체를 e라는 이름으로 받겠다.
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
    // copyFileUseBuffer가 copyFile보다 왜 더 빠를까? copyFile()은 파일과 계속 통신합니다. copyFileUseBuffer()은 파일과 통신하는 횟수가 크게 줄어듭니다. 그래서 속도가 더 빠르다.

    /**
     * 1차 스트림(FileInputStream, FileOutputStream)을 이용해서 파일을 복사한다.
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFileCustomBuffer(String org, String dest){ // 직접 만든 버퍼(byte[])를 사용해서 파일을 복사하는 메서드, org : 원본 파일의 경로, dest : 복사해서 저장할 파일의 경로
        // 앞에서 본 copyFile()은 1바이트씩 복사했고, copyFileUseBuffer()는 BufferedInputStream과 BufferedOutputStream이 내부적으로 버퍼를 사용했습니다.
        // 이번 메서드는 우리가 직접 8KB 크기의 버퍼를 만들어 여러 바이트를 한 번에 읽고 쓰는 방식입니다.
        try(
                InputStream fis = new FileInputStream(org); // 원본 파일을 읽기 위한 스트림을 생성합니다.
                OutputStream fos = new FileOutputStream(dest) // 복사 파일에 데이터를 저장하기 위한 스트림을 생성합니다.
        ){
            byte[] buffer = new byte[1024 * 8]; // 8KB의 버퍼 생성, byte[]: byte형 배열을 만든다는 뜻입니다. 배열 하나에 여러 개의 바이트를 저장할 수 있습니다. 1024 * 8=8192, 즉, 8192Byte = 8KB
            int readSize = 0; // 읽은 바이트 수를 저장합니다.
            while((readSize = fis.read(buffer)) != -1){ // fis.read(buffer): 파일에서 데이터를 8kb씩 읽어서 buffer 배열에 저장하라. 파일 끝이 아닐 때까지 계속 반복하라는 뜻입니다.
                fos.write(buffer, 0, readSize); // write(배열, 시작위치, 개수), buffer: 복사할 데이터가 들어있는 배열, 0: 배열의 0번째 인덱스부터 쓰라는 뜻, readSize: 실제로 읽은 바이트 수만큼만 저장하라는 뜻
            }
        }catch(IOException e){ // 예외 처리, IOException 타입의 예외 객체를 e라는 이름으로 받겠다.
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}