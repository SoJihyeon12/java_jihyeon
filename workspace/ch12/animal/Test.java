package ch12.animal;

public class Test {
    public static void main(String[] args){
        Dog haru = new Dog();
//        Animal haru = new Dog(); // 자식 인스턴스를 부모의 타입으로 선언 가능함
        haru.eat(); // 부모에게 물려 받은 메서드
        haru.bark(); // 추가한 메서드

        animalCare(haru);


        // is-a 관계가 성립되지 않는 잘못된 상속
//        Notebook book = new Notebook();
//        animalCare(book);

        Animal c = new Cat();
        animalCare(c);
    }

    // 동물 관리 서비스
    static void animalCare(Animal a){
        // Animal.eat()를 호출하는 동일한 코드지만
        // 실제 생성된 객체의 오버라이딩 된 메서드가 호출됨
        // 3년뒤 신입사원 보거라!!! 오늘은 2023년 05월 13일이다.
        // 니가 2026.06.05일에 Cat의 eat() 메서드 만들것을 난 이미 알고 있다.
        // 나의 a.eat() 너의 Cat.eat()를 호출하게 될 것이다.
        a.eat();
        a.move();
        a.sleep();
//        a.bark();
//        a.liquefy();
    }

    // 강아지 관리 서비스
//    static void animalCare(Dog a){
//        a.eat();
//        a.move();
//        a.sleep();
//        a.bark(); // Animal에는 정의되어 있지 않음
//    }

    // 고양이 관리 서비스
//    static void animalCare(Cat a){
//        a.eat();
//        a.move();
//        a.liquefy(); // Animal에는 정의되어 있지 않음
//        a.sleep();
//    }
}