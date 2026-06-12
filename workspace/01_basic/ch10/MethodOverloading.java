package ch10;

public class MethodOverloading {// 메서드 오버로딩이란 메서드 이름은 같은데 괄호 안의 매개변수 타입이 다르면 여러 개 만들 수 있음
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
    String toString(int[] arr) { // int형 매개변수 인자를 가진 메서드
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
    String toString(double[] arr) { // double형 매개변수 인자를 가진 메서드
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

    String toString(String[] arr) { // String형 매개변수 인자를 가진 메서드
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
