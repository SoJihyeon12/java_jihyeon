package ch06.annotation;
// 이 코드는 직접 어노테이션을 만드는 코드입니다.
// 우리가 자주 사용하는 @Override, @Deprecated처럼 @MeasureTime이라는 새로운 어노테이션을 정의한 것입니다.
// 어노테이션(Annotation) 은 자바에게 특별한 의미를 알려주는 표시(메모) 입니다.
// "이 클래스나 메서드는 이런 역할을 합니다." 라고 자바 컴파일러나 프레임워크에게 알려주는 표식입니다.
// 어노테이션은 @ 기호로 시작합니다.

// 이 코드는 @MeasureTime이라는 사용자 정의 어노테이션을 만드는 코드입니다.
// 이 어노테이션은 **메서드에만 붙일 수 있고(@Target(ElementType.METHOD)),
// 프로그램 실행 중에도 정보를 읽을 수 있으며(@Retention(RetentionPolicy.RUNTIME)),
// taskName이라는 선택 속성(기본값은 빈 문자열)을 가질 수 있도록 정의한 것입니다.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 메서드를 대상으로 지정
@Target(ElementType.METHOD) // 이 어노테이션은 메서드에만 붙일 수 있다.라는 의미
// 실행 시점에 사용 가능하도록 유지 정책을 RUNTIME으로 지정함
@Retention(RetentionPolicy.RUNTIME) // 프로그램이 실행되는 동안에도 이 어노테이션 정보를 유지하겠다.라는 의미, 왜 필요한가? 실행중에 @MeasureTime이 붙어있는지 검사해서 실행 시간을 측정하려는 것
// 지정된 메서드의 실행 시간을 출력하는 어노테이션
public @interface MeasureTime { // @interface: "어노테이션을 만드는 문법"입니다. 즉, MeasureTime이라는 어노테이션을 만들겠다.
    // 어노테이션의 taskName 속성 정의
    // default가 있으면 선택 사항이 됨
    String taskName() default ""; // 어노테이션의 속성(attribute) 입니다. taskName이라는 문자열 속성을 만든다.
}