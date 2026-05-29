package ch08;

public class ForTest7 {
    public static void main(String[] args){
        // continue를 이용한 홀수 합계
        int sum = 0;
        for(int i=1; i<=100; i++){
            if(i % 2 == 0){ // 짝수일 때는 아래 실행문을 넘어가고 다음턴(for문)으로 넘어감
                continue;
            }
            sum += i;
        }
        System.out.println("1~100 홀수 합계: " + sum);

        // 1~100 합계
        int num = 1;
        sum = 0;
        while(true){
            sum += num; // 0, 1, 3, 6, 10, 15...
            num++; //1, 2, 3, 4...
            if(num > 100){
                break; // while문 중단
            }
        }
        System.out.println("1~100 합계: " + sum);
    }
}
