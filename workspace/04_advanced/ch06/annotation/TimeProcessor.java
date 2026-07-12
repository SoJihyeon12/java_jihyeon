package ch06.annotation;

import java.lang.reflect.Method;

public class TimeProcessor {
    public void process(Object target){
        // target 객체에 정의된 모든 메서드 목록
        Method[] methods = target.getClass().getDeclaredMethods();

        for(Method method : methods){ // 각 메서드를 순회
            // 어노테이션 객체 정보 확인
            if(method.isAnnotationPresent(MeasureTime.class)){
                MeasureTime measureTime = method.getAnnotation(MeasureTime.class);
                String taskName = measureTime.taskName().isEmpty() ? method.getName() : measureTime.taskName();
                long start = System.currentTimeMillis();

                try {
                    method.invoke(target); // 해당 메서드를 호출한다.
                } catch (Exception e) {
                    System.err.println("대상 메서드 호출 예외: " + e.getMessage());
                }

                long end = System.currentTimeMillis();
                System.out.println(taskName + " 소요 시간: " + (end - start) + "ms.");
            }
        }
    }
}