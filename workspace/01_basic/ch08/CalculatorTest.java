package ch08;


import java.util.Scanner; //Scanner 클래스를 사용하겠다고 가져오는(import) 문장
                        //Scanner는 키보드로 입력한 값을 읽어오는 클래스

// 계산기
// 5 + 4 -> 5 + 4 = 9
// 4 * 2 -> 4 * 2 = 8
public class CalculatorTest {
    public static void main(String[] args){
        System.out.println("*** 계산기 프로그램 ***");
        System.out.println("계산식을 입력하세요.(예시: 5 + 4)");
        Scanner s = new Scanner(System.in); // 스캐너 s 변수 생성, System.in = 키보드 입력
        int num1 = s.nextInt(); // 5, s라는 키보드에서 정수(int) 하나 입력받아서 num1에 저장, 넥스트"인트"를 받음
        String operator = s.next(); // "+" , s라는 키보드에서 문자열(String) 하나 입력받아서 operator에 저장,
        int num2 = s.nextInt(); // 4, s라는 키보드에서 정수(int) 하나 입력받아서 num2에 저장, 넥스트"인트"

        String result = switch(operator){
            case "+" -> num1 +  " " + operator + " " + num2 + " = " + (num1 + num2);
            case "-" -> num1 +  " " + operator + " " + num2 + " = " + (num1 - num2);
            case "*" -> num1 +  " " + operator + " " + num2 + " = " + (num1 * num2);
            case "/" -> num1 +  " " + operator + " " + num2 + " = " + ((double)num1 / num2);//num1과 num2가 int라서
            default -> "수식에 오류가 있습니다.";                                             //계산값을 double(소수)로 명시적 형변환함
        };

        System.out.println(result);
    }
}
