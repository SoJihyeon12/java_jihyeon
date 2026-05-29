package ch08;

public class ForTest { //WhileTest를 좀더 간략하게 표현가능
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]); // (args[0])에 들어온 값은 문자열(String), [0]은 배열번호
        int sum = 0;                         // Integer.parseInt() = 문자열을 int 숫자로 변환
                                             // 즉, 첫 번째 입력값(String)을 숫자(int)로 변환 하는 코드
        for(int i = 1; i <= num; i++){
            sum += i;
            System.out.println("i: " + i + ", sum: " + sum);
        }

        System.out.println("1부터 " + num + "까지의 합계: " + sum);
    }
}
