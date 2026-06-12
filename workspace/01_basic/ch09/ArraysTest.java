package ch09;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args){
        int[] arr = {3,6,7,8,5,3,5,6,8,2,3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {2, 1, 3};
        int[] arr4 = {1, 2, 3};

        // 1. arr의 모든 요소를 출력하세요.
        // [3, 6, 7, 8, 5, 3, 5, 6, 8, 2, 3]
//        for(int i=0; i<arr.length; i++){
//            System.out.println(arr[i]);
//        }
        System.out.println(Arrays.toString(arr)); // 배열을 문자열로 변환하는 메서드

        // 2. arr2와 arr3, arr2와 arr4의 모든 요소가 같은 값을 가지고 있는지 출력하세요.(순서와 값이 모두 일치)
        // arr2, arr3 다름
        // arr2, arr4 같음
//        System.out.println(arr2 == arr3); // false
//        System.out.println(arr2 == arr4); // false

//        boolean isEqual = true; // 두 배열의 모든 요소가 같으면 true, 아니면 false
//        for(int i=0; i<arr2.length; i++){
//            if(arr2[i] != arr3[i]){
//                isEqual = false;
//                break;
//            }
//        }
//        System.out.println("arr2, arr3 " + (isEqual ? "같음" : "다름"));
//
//        isEqual = true; // 두 배열의 모든 요소가 같으면 true, 아니면 false
//        for(int i=0; i<arr2.length; i++){
//            if(arr2[i] != arr4[i]){
//                isEqual = false;
//                break;
//            }
//        }
//        System.out.println("arr2, arr4 " + (isEqual ? "같음" : "다름"));

        System.out.println("arr2, arr3 " + Arrays.equals(arr2, arr3));
        System.out.println("arr2, arr4 " + Arrays.equals(arr2, arr4));

        // 3. arr 요소의 최소값과 최대값을 구하세요.
        // 최소값: 2
        // 최대값: 8
//        int min = arr[0]; // 최소값
//        int max = arr[0]; // 최대값

//        for(int i=1; i<arr.length; i++){
//            if(arr[i] < min){ // 비교할 값이 최소값보다 작을 경우
//                min = arr[i]; // 최소값을 교체한다.
//            }
//            if(arr[i] > max){ // 비교할 값이 최대값보다 클 경우
//                max = arr[i]; // 최대값을 교체한다.
//            }
//        }
//
//        System.out.println("최소값: " + min);
//        System.out.println("최대값: " + max);

        Arrays.sort(arr);
        System.out.println("최소값: " + arr[0]);
        System.out.println("최대값: " + arr[arr.length-1]);

        // 4. arr의 요소를 오름차순으로 정렬하세요.
        // int[] arr = {2,3,3,8,7,6,5,6,8,5,3};
        // 2,3,3,3,5,5,6,6,7,8,8
//        for(int i=0; i<arr.length; i++){
//            for(int k=i; k<arr.length-1; k++){
//                if(arr[i] > arr[k+1]){
//                    // arr[i] <-> arr[k+1]
//                    int temp = arr[i];
//                    arr[i] = arr[k+1];
//                    arr[k+1] = temp;
//                }
//            }
//        }

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
