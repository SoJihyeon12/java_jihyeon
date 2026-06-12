package ch10;

import java.util.Arrays;

public class ArrayCopyMethod {

    // 전달받은 배열의 모든 요소를 출력
    static void printArr(int[] arr, String name){// void는 실행화면에 출력만 하고 값을 반환하지 않는다
        System.out.print(name + ": ");           // printArr()는 배열(arr)과 출력할 이름(name)을 받아서 배열 내용을 출력하는 메서드
        for(int elem : arr){                     // 출력만 하거나 작업만 할 때 void 사용
            System.out.print(elem + " ");        // 값을 돌려줘야 할때 return 사용 → int, double, String 등을 이용함
        }
        System.out.println();
    }

    // 원본 배열과 복사 배열을 출력한 후 값을 수정하고 다시 출력한다.
    static void testArr(int[] original, int[] shallow){
        // original, shallow의 모든 요소를 출력
        printArr(original, "원본 배열");
        printArr(shallow, "복사 배열");

        // shallow[0] 값을 수정
        shallow[0] = 99;
        original[0] = 88;

        // original, shallow의 모든 요소를 출력
        printArr(original, "원본 배열");
        printArr(shallow, "복사 배열");
    }

    public static void main(String[] args){

        int[] original = {10, 20, 30}; // 원본 배열

        System.out.println("---- 1. 얕은 복사 ----");
        // 1. 얕은 복사 (Shallow Copy)
        int[] shallow = original; // original을 복사함

        testArr(original, shallow);

        // 2. 깊은 복사 (Deep Copy) - 수동 복사 (for 문 사용)
        System.out.println("---- 2. 깊은 복사 - 수동 복사 (for 문 사용) ----");
        original = new int[]{10, 20, 30, 40, 50};
        shallow = new int[original.length];

        // 원본 배열의 각 요소를 복사해서 복사본에 지정
        for(int i=0; i<original.length; i++){
            shallow[i] = original[i];
        }

        testArr(original, shallow);

        // 3. 깊은 복사 (System.arraycopy() 이용)
        System.out.println("---- 3. 깊은 복사 (System.arraycopy() 이용) ----");
        original = new int[]{10, 20, 30, 40, 50};
        shallow = new int[original.length];

        // original 배열의 index 0부터 끝까지 shallow에 복사
        System.arraycopy(original, 0, shallow, 0, original.length);

        testArr(original, shallow);

        // 4. 깊은 복사 (Arrays.copyOf() 이용)
        System.out.println("---- 4. 깊은 복사 (Arrays.copyOf() 이용) ----");
        original = new int[]{10, 20, 30, 40, 50};
        shallow = Arrays.copyOf(original, original.length); // 배열의 깊은 복사

        testArr(original, shallow);
    }
}
