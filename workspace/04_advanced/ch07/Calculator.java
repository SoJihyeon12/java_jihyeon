package ch07;
// 이 코드는 간단한 계산기(Calculator) 클래스입니다.
// 이 클래스는
//객체가 생성될 때 생성자를 실행하고,
//덧셈(add)과 나눗셈(divide) 기능을 제공합니다.

public class Calculator { // Calculator라는 클래스를 생성합니다. 이 클래스는 계산 기능을 제공합니다.
    Calculator(){ // 이 부분은 생성자(Constructor) 입니다. 생성자는 객체가 생성될 때 자동으로 한 번 실행되는 특별한 메서드입니다.
        System.out.println("Calculator 기본 생성자 호출.");
    }

    int add(int n1, int n2){ // 이 메서드는 두 수를 더해서 결과를 반환합니다.
        return n1 + n2;
    }

    double divide(int n1, int n2){ // 이 메서드는 나눗셈을 수행하여 double 타입으로 반환합니다.
        if(n2 == 0) throw new ArithmeticException(); // 0으로 나누는지 확인, n2가 0인지 확인합니다. 0이면 예외 발생, ArithmeticException은 산술 연산 오류를 나타내는 예외입니다.
        return Math.round(((double)n1 / n2) * 100) / 100.0; // (double)n1은 정수 나눗셈이 아닌 실수 나눗셈을 하기 위한 형변환입니다.
    }
}
// Math.round(... * 100) / 100.0은 결과를 소수 둘째 자리까지 반올림하기 위한 계산입니다.