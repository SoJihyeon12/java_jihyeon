package ch11.statictest;

public class MainMethodTest {

    public void instanceMethod() {
        System.out.println("인스턴스 메서드 호출.");
    }

    public static void staticMethod() {
        System.out.println("static 메서드 호출.");
    }

    // Java 21 이전
    public static void main(String[] args){
        // main 메서드에서 외부 메서드를 호출하는 첫번째 방법
        // static 메서드를 그냥 호출
        staticMethod();


        // 두번째 방법
        // instance를 생성한 후 호출
        MainMethodTest m = new MainMethodTest();
        m.instanceMethod();
    }

    // Java 21 이후
    void main(){
        staticMethod();
        instanceMethod();
    }

}
