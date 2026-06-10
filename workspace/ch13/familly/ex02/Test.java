package ch13.familly.ex02;

public class Test {

    public static void main(String[] args){
        // 추상클래스는 객체를 생성할 수 없음
//        Parent p = new Parent("부모");
//        Parent p = new Son("아들"); // up casting(자동 형변환, 자식 -> 부모)
        Daughter p = new Daughter("딸");

        dailySchedule(p);
    }

    // 하루 일과
    private static void dailySchedule(Parent p){ // Parent 타입의 매개 변수 정의
        p.eat();
        p.play();

        p.study();

        p.sleep();
    }

    // 하루 일과
//    private static void dailySchedule(Son p){ // Son 타입의 매개 변수 정의
//        p.eat();
//        p.play();
//        p.sleep();
//    }

    // 하루 일과
//    private static void dailySchedule(Daughter p){ // Daughter 타입의 매개 변수 정의
//        p.eat();
//        p.play();
//        p.sleep();
//    }
}
