package ch13.familly.ex01;

// Son이 Parent의 필드와 메서드를 상속 받는다.
public class Son extends Parent{
    Son(String name){
        super(name); // super() 부모의 생성자 호출
    }

    // 오버라이딩(오버로딩 아님): 상속받은 메서드를 재정의
    void play(){
        work();
        System.out.println(name + ": 게임을 한다.");
    }

    private void work(){
        System.out.println(name + ": 일한다.");
    }

    public void study(){
        System.out.println(name + ": 도서관에서 공부한다.");
    }
}
