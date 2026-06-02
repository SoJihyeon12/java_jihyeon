package ch10;

public class MethodOverloading {
    void main(){
        int[] scores = {89, 78, 79};
        System.out.println(toString(scores));

        double[] scores2 = {12.0, 45.6};
        System.out.println(toString(scores2));

        String[] names = {"haru", "namu", "brong"};
        System.out.println(toString(names));
    }

    // int 배열 내부의 모든 요소 값들을 문자열로 반환한다.
    // [34, 3, 45, 4, 5]
    String toString(int[] arr) {
        String result = "[";
        for(int i=0; i<arr.length; i++){
            result += arr[i];
            if(i != arr.length-1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    // double 배열 내부의 모든 요소 값들을 문자열로 반환한다.
    String toString(double[] arr) {
        String result = "[";
        for(int i=0; i<arr.length; i++){
            result += arr[i];
            if(i != arr.length-1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    String toString(String[] arr) {
        String result = "[";
        for(int i=0; i<arr.length; i++){
            result += arr[i];
            if(i != arr.length-1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
