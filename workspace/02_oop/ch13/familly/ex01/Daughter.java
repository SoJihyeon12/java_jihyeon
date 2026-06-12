package ch13.familly.ex01;

public class Daughter extends Parent{
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
}
