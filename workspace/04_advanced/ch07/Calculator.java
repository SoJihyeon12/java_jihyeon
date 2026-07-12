package ch07;

public class Calculator {
    Calculator(){
        System.out.println("Calculator 기본 생성자 호출.");
    }

    int add(int n1, int n2){
        return n1 + n2;
    }

    double divide(int n1, int n2){
        if(n2 == 0) throw new ArithmeticException();
        return Math.round(((double)n1 / n2) * 100) / 100.0;
    }
}