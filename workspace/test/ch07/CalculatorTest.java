package ch07;

public class CalculatorTest {
    private Calculator calc;

    void setUp(){
        calc = new Calculator();
    }

    void add(){
        int result = calc.add(2, 3);
        if(result == 5){ // 기대값은 5, 기대값과 실제값을 비교해서 일치하면 성공, 아니면 실패
            System.out.println("두 정수의 덧셈 검증 성공");
        }else{
            System.err.println("덧셈의 결과는 5여야 함");
        }
    }

    void add_3_4(){
        int result = calc.add(3, 4);
        if(result == 7){ // 기대값은 7, 기대값과 실제값을 비교해서 일치하면 성공, 아니면 실패
            System.out.println("두 정수의 덧셈 검증 성공");
        }else{
            System.err.println("덧셈의 결과는 7이어야 함");
        }
    }

    void divide(){
        double result = calc.divide(10, 6); // 소수 세째자리에서 반올림
        if(result == 1.67){ // 기대값은 1.67, 기대값과 실제값을 비교해서 일치하면 성공, 아니면 실패
            System.out.println("두 정수의 나눗셈 검증 성공");
        }else{
            System.err.println("10/6은 1.67이 되어야 함. " + result);
        }
    }

    void divide_byZero(){
        double result =0;
        try{
            result = calc.divide(10,0);
            System.err.println("ArithmeticException이 발생하지 않으면 테스트 실패. " + result);
        }catch (ArithmeticException e){
            System.out.println("0으로 나누면 ArithmeticException이 발생해야 함");
        }
    }

    void main(){
        setUp();
        add();
        add_3_4();
        divide();
        divide_byZero();
    }
}
