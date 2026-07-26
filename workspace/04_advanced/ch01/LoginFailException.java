package ch01;
//LoginFailException이라는 사용자 정의 예외(Custom Exception) 클래스를 만드는 코드
// 이 클래스는 "로그인 실패"를 표현하기 위한 나만의 예외를 만들고, 오류 메시지를 함께 저장할 수 있게 하는 클래스입니다.

public class LoginFailException extends Exception{ // Exception 클래스를 상속받아 예외 클래스를 만든다.
    public LoginFailException(String message) { // 이것은 생성자(Constructor) 입니다. 예외 객체를 만들 때 호출됩니다. new LoginFailException("비밀번호가 틀렸습니다.");를 실행하면 생성자 호출됨
        super(message); // super는 부모 클래스(Exception)의 생성자를 호출하는 것, 즉, 부모 클래스인 Exception에게 메시지를 전달하라 라는 뜻
    }
}