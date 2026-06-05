package ch12.family.ex01;

public class Test {
    public static void main(String[] args){
//        Parent p = new Parent("부모");
//        Son p = new Son("아들");
        Daughter p = new Daughter("딸");

        dailySchedule(p);
    }

    // 하루 일과
    private static void dailySchedule(Parent p){
        p.eat();
        p.play();
        p.sleep();
    }

    // 하루 일과
    private static void dailySchedule(Son p){
        p.eat();
        p.play();
        p.sleep();
    }

    // 하루 일과
    private static void dailySchedule(Daughter p){
        p.eat();
        p.play();
        p.sleep();
    }
}


