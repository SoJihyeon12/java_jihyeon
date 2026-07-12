package ch06.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 메서드를 대상으로 지정
@Target(ElementType.METHOD)
// 실행 시점에 사용 가능하도록 유지 정책을 RUNTIME으로 지정함
@Retention(RetentionPolicy.RUNTIME)
// 지정된 메서드의 실행 시간을 출력하는 어노테이션
public @interface MeasureTime {
    // 어노테이션의 taskName 속성 정의
    // default가 있으면 선택 사항이 됨
    String taskName() default "";
}