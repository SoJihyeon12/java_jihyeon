package ch05.single;

public class OddNum {
    public void run(){
        System.out.println("2. 홀수 출력 시작.");
        // 1~10까지 홀수를 출력한다.
        for(int i=1; i<=10; i+=2){
            System.out.println("3. 홀수: " + i);
        }
        System.out.println("4. 홀수 출력 종료.");
    }
}