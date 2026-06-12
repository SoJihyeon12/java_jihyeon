package ch08;

public class DoWhileTest {
    public static void main(String[] args){
        int num = 0;

        do{
                // 주사위 던지기
                // Math.random() : 0이상 1미만의 무작위 double 타입의 숫자를 반환
            num = (int) (Math.random()* 6) + 1; // (Math.random()* 6)은 0이상 5.99999...미만의 수 int하면 5됨
            System.out.println(num);            // 그래서 마지막에 +1해서 6.9 되는데 int해서 6 됨
        } while(num != 6);
    }
}
