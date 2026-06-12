package ch14;

public class StringBufferTest {
    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer("Java"); // 멀티스레드에 최적화
        StringBuilder sb = new StringBuilder("Java"); // 싱글스레드에 최적화

        // 1. append(): 문자열 추가
        sb.append(" Programming");
        System.out.println(sb); // Java Programming

        // 2. insert(): 특정 인덱스 위치에 문자열 삽입
        sb.insert(4, " Standard");
        System.out.println(sb); // Java Standard Programming

        // 3. delete(): 특정 범위 문자 삭제 (5번 인덱스부터 13번 인덱스 직전까지)
        sb.delete(4, 13);
        System.out.println(sb); // Java Programming

        // 4. reverse(): 문자열 순서 반전
        sb.reverse();
        System.out.println(sb); // gnimmargorP avaJ

        // 5. toString(): 일반 String 객체로 변환
        sb.reverse(); // 원복
        String result = sb.toString();
        System.out.println(result); // Java Programming

        // 6. "Hello Hello ..." 1000개로 이루어진 문자열 생성해서 출력하세요.
        StringBuffer sb2 = new StringBuffer(6000);

        for(int i=0; i<100; i++){
            sb2.append("Hello ");
        }

        System.out.println(sb2);
    }
}
