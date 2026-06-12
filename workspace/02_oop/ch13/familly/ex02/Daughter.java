package ch13.familly.ex02;

// 추상클래스를 상속받는 자식 클래스는
// 1. 추상메서드를 모두 구현하거나
// 2. 구현하지 못하는 추상메서드가 하나라도 남아 있을 경우 자신도 추상클래스가 되어야 함
public class Daughter extends Parent {
    Daughter(String name){
        super(name);
    }

    void play(){
        System.out.println(name + ": 코노에 간다.");
        doFaceMask();
    }

    // 마스크팩을 한다.
    private void doFaceMask(){
        System.out.println(name + ": 마스크 팩을 한다.");
    }

    public void study(){
        System.out.println(name + ": 과외를 받는다.");
    }
}
