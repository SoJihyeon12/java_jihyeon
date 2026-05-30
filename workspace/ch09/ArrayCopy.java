package ch09;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args){
        // 1. 얕은 복사 (Shallow Copy)
        int[] original = {10, 20, 30};
        int[] shallow = original; // original을 복사함

        // original, shallow의 모든 요소를 출력
        System.out.println("---- 1. 얕은 복사 ----");
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }

        // shallow[0] 값을 수정
        shallow[0] = 99;
        original[0] = 88;

        // original, shallow의 모든 요소를 출력
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }

        // 2. 깊은 복사 (Deep Copy) - 수동 복사 (for 문 사용)
        System.out.println("---- 2. 깊은 복사 - 수동 복사 (for 문 사용) ----");
        // {10, 20, 30} 형태의 초기화 작업은 배열 선언과 함께 해야 함
        // 이미 선언된 변수에 새로운 배열을 할당하려면 new int[]{10, 20, 30} 형태로 작성해야 함
        original = new int[]{10, 20, 30, 40, 50};
        shallow = new int[original.length];

//        shallow[0] = original[0]; // 10
//        shallow[1] = original[1]; // 20
//        shallow[2] = original[2]; // 30
//        shallow[3] = original[3]; // 40
//        shallow[4] = original[4]; // 50

        // 원본 배열의 각 요소를 복사해서 복사본에 지정
        for(int i=0; i<original.length; i++){
            shallow[i] = original[i];
        }

        // original, shallow의 모든 요소를 출력
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }

        // shallow[0] 값을 수정
        shallow[0] = 99;
        original[0] = 88;

        // original, shallow의 모든 요소를 출력
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }

        // 3. 깊은 복사 (System.arraycopy() 이용)
        System.out.println("---- 3. 깊은 복사 (System.arraycopy() 이용) ----");
        original = new int[]{10, 20, 30, 40, 50};
        shallow = new int[original.length];

        // original 배열의 index 0부터 끝까지 shallow에 복사
        System.arraycopy(original, 2, shallow, 0, original.length-2);

        // original, shallow의 모든 요소를 출력
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }

        // shallow[0] 값을 수정
        shallow[0] = 99;
        original[0] = 88;

        // original, shallow의 모든 요소를 출력
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }

        // 4. 깊은 복사 (Arrays.copyOf() 이용)
        System.out.println("---- 4. 깊은 복사 (Arrays.copyOf() 이용) ----");
        original = new int[]{10, 20, 30, 40, 50};
        shallow = Arrays.copyOf(original, original.length); // 배열의 깊은 복사

        // original, shallow의 모든 요소를 출력
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }

        // shallow[0] 값을 수정
        shallow[0] = 99;
        original[0] = 88;

        // original, shallow의 모든 요소를 출력
        for(int i=0; i<original.length; i++){
            System.out.println("original: " + original[i] + ", shallow: " + shallow[i]);
        }
    }
}
