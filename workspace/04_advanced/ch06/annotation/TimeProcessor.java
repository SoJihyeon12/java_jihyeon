package ch06.annotation;
// 어노테이션(Annotation) 은 자바에게 특별한 의미를 알려주는 표시(메모) 입니다.
// "이 클래스나 메서드는 이런 역할을 합니다." 라고 자바 컴파일러나 프레임워크에게 알려주는 표식입니다.
// 어노테이션은 @ 기호로 시작합니다.

// 이 코드는 애노테이션(@MeasureTime)이 붙은 메서드의 실행 시간을 자동으로 측정하는 클래스입니다.
// 핵심 역할은 다음과 같습니다. @MeasureTime이 붙은 메서드를 찾아 실행한 뒤, 실행 시간을 출력한다. 이 과정에서 리플렉션(Reflection) 을 사용합니다.

import java.lang.reflect.Method;

public class TimeProcessor {
    public void process(Object target){ // target은 검사할 객체입니다. Work라는 객체를 만들었다면 Work 객체 안에 있는 메서드들을 조사하게 됩니다.
        // 모든 메서드 가져오기
        Method[] methods = target.getClass().getDeclaredMethods(); // target.getClass(): 현재 객체의 클래스 정보를 가져옴, getDeclaredMethods(): 현재 클래스 안에 선언된 모든 메서드를 가져옵니다.
        // Method는 메서드 하나를 표현하는 객체이다.

        for(Method method : methods){ // 각 메서드를 순회(반복), 배열 안의 메서드를 하나씩 꺼냅니다.
            // 어노테이션 객체 정보 확인
            if(method.isAnnotationPresent(MeasureTime.class)){ //이 메서드에 @MeasureTime이 붙어 있습니까?라는 의미, 즉, 애노테이션이 붙은 메서드만 실행합니다.
                MeasureTime measureTime = method.getAnnotation(MeasureTime.class); // 어노테이션 객체 가져오기, 메서드에 붙어 있는 애노테이션 정보를 가져옵니다.
                String taskName = measureTime.taskName().isEmpty() ? method.getName() : measureTime.taskName(); //taskName의 값을 결정하는 코드입니다. taskName이 비어 있으면 → 메서드 이름을 사용하고 비어 있지 않으면 → 어노테이션에 적은 taskName을 사용한다.
                long start = System.currentTimeMillis(); // 시작 시간 저장, 현재 시간을 밀리초(ms) 단위로 저장합니다.

                try {
                    method.invoke(target); // 해당 메서드를 호출한다. 리플렉션을 이용해서 메서드를 직접 호출하는 것입니다
                } catch (Exception e) { // 메서드 실행 중 문제가 생기면
                    System.err.println("대상 메서드 호출 예외: " + e.getMessage());// 이거 출력
                }

                long end = System.currentTimeMillis(); // 종료 시간 저장
                System.out.println(taskName + " 소요 시간: " + (end - start) + "ms."); // 실행 시간 계산
            }
        }
    }
}