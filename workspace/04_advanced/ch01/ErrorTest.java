package ch01;
// 이 코드는 예외 처리(Exception Handling)와 에러(Error)의 차이를 보여주는 예제이다.

public class ErrorTest {
    public static void main(String[] args){
        try{ // 플랜 A, // 오류가 발생할 수 있는 코드, 일단 실행하고 싶은 코드
            int num = Integer.parseInt(args[0]); // 명령행(Command Line)으로 입력받은 문자열(args[0])을 정수(int)로 변환해(parasInt의 역할) 변수에 저장하는 코드입니다
            //int → 기본 자료형(숫자만 저장)
            //Integer → int를 감싸는 클래스(객체), 객체이기 때문에 다양한 기능(메서드)을 사용할 수 있습니다.
            int result = 10 / num;
            System.out.println("result: " + result);
        }catch(ArithmeticException e){ // 플랜 B, // 오류가 발생했을 때 실행되는 코드, ArithmeticException = 계산 중 발생한 예외라는 뜻, e는 발생한 예외를 저장하는 변수
            System.out.println(e.getMessage()); // e.getMessage()는 예외(오류) 객체가 가지고 있는 오류 메시지를 가져오는 메서드
        }catch(ArrayIndexOutOfBoundsException e){ // 플랜 C, // 오류가 발생했을 때 실행되는 코드, ArrayIndexOutOfBoundsException: 배열에 없는 인덱스(args[0]이 없는데 접근 등)를 사용할 때(배열범위 벗어남) 발생하는 예외, e는 발생한 예외를 저장하는 변수
            System.out.println(e.getMessage()); // e.getMessage()는 예외(오류) 객체가 가지고 있는 오류 메시지를 가져오는 메서드
        }

        try{
            makeError(); // 오류를 발생시키는 메서드, 이건 자바에 있던 게 아니라 누군가가 직접 만든 메서드 이름
        }catch(Throwable t){ // Throwable은 자바에서 모든 오류(Error)와 예외(Exception)의 최상위 부모 클래스, t → 발생한 예외(오류) 객체를 저장하는 변수, 의미 → "어떤 예외나 오류가 발생하더라도 여기에서 받아 처리하겠다."
            t.printStackTrace(); // 발생한 예외(오류)의 상세 정보를 출력하는 메서드, "오류가 어디서, 왜 발생했는지 자세한 정보를 보여줘."라는 뜻
            System.out.println("에러 발생: " + t.getClass().getSimpleName());// t.getClass()는 t라는 객체의 클래스가 무엇인지 알려줘라는 메서드, getSimpleName()은 클래스 이름만 가져오는 메서드입니다.
        }

        System.out.println("프로그램 종료.");
    }

    static void makeError(){
        makeError(); // 재귀 호출, 현재 실행 중인 makeError()가 다시 자기 자신을 호출하는 것
        // 결국 어떻게 될까?
        //메서드를 호출할 때마다 컴퓨터의 스택(Stack) 에 실행 정보가 쌓입니다. 스택 공간이 꽉 차면 StackOverflowError 발생
        // 이 코드는 보통 StackOverflowError가 어떻게 발생하는지 보여주기 위한 예제로 많이 사용됩니다.
        // 그렇기 때문에 올바른 재귀 호출은 반드시 종료 조건이 있어야 합니다.
    }
}