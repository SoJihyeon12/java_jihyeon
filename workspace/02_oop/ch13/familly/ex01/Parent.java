package ch13.familly.ex01;

// 상속, 다형성, instanceof 사용
public class Parent {
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
}
