package ch13.familly.ex02;

// 상속, 다형성, instanceof 사용
// 추상클래스로 변경
// 추상클래스
// 1. 추상 메서드가 하나라도 있으면 반드시 추상 클래스로 선언
// 2. 직접 객체 생성이 불가
public abstract class Parent {
    String name;

    // 기본 생성자: 컴파일러가 자동으로 만들어줌
//    Parent(){}

    // 생성자: 클래스명과 동일한 이름, 리턴타입은 없음
    Parent(String name){
        this.name = name;
    }

    void eat(){
        System.out.println(name + ": 음식을 맛있게 먹는다.");
    }

    void play(){
        System.out.println(name + ": 등산한다.");
    }

    void sleep(){
        System.out.println(name + ": 집에서 꿀잠을 잔다.");
    }

    // 부모 관점에서는 구현할 내용이 없음
    // 자식이 오버라이드해서 구현하기를 원함(강제로 오버라이드 하도록 지정)
    // 추상메서드
    abstract void study();
}
