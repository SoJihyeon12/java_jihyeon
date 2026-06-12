package ch11;

public class MemberTest {
    String id;

    // 기본 생성자
//    MemberTest() {}

    // 생성자 정의: 리턴 타입 없음, 이름은 클래스명과 동일해야 함
    MemberTest(String id){
        this.id = id;
    }

    // JVM이 이런 방식으로 실행함
    // new MemberTest().main()
    public static void main(String[] args){
        MemberTest member = new MemberTest("yong");
        System.out.println("회원 아이디: " + member.id);
    }
}
