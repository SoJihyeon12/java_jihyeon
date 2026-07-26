package ch06.annotation;
// 이 코드는 애노테이션(Annotation) 을 사용하는 예제를 실행하는 테스트 클래스입니다.
// 현재 코드에서는 Work 객체를 만들어 task1(), task2()를 실행하고 있으며, TimeProcessor를 사용하는 부분은 주석 처리되어 있습니다.
// 어노테이션(Annotation) 은 자바에게 특별한 의미를 알려주는 표시(메모) 입니다.
// "이 클래스나 메서드는 이런 역할을 합니다." 라고 자바 컴파일러나 프레임워크에게 알려주는 표식입니다.
// 어노테이션은 @ 기호로 시작합니다.

public class AnnotationTest { // 이 클래스는 애노테이션 기능을 테스트하는 역할을 합니다.
    void main(){
        Work w = new Work(); // Work 클래스의 객체를 생성합니다.
        w.task1(); // Work 객체의 task1() 메서드를 호출합니다.
        w.task2(); // Work 객체의 task2() 메서드를 호출합니다.

//        TimeProcessor processor = new TimeProcessor(); // TimeProcessor 객체를 생성합니다.
//        processor.process(w); // Work 객체를 전달하여 처리합니다. process(w): Work 객체 안에 있는 메서드를 분석하는 역할을 합니다.
    }
}