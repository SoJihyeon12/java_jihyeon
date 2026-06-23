package ch01;

public class MultiCatchTest {
    void main(){
        divide4(100, new String[] {" hello  "}); // 정상
        divide4(100, new String[] {"   "}); // ArithmeticException
        divide4(100, new String[] {});
        divide4(100, new String[] {null});
        divide4(100, null);

        System.out.println("프로그램 종료.");
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length(); // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException
            int result = num1 / num2; // arr[0]이 "   "일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }catch(ArithmeticException | NullPointerException e){
            System.out.println(e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("arr 사이즈가 0입니다.");
        }
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide2(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length(); // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException
            int result = num1 / num2; // arr[0]이 "   "일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }catch(ArrayIndexOutOfBoundsException e){ // 플랜 C
            System.out.println("arr 사이즈가 0입니다.");
        }catch(Exception e){ // 플랜 B
            System.out.println(e.getMessage());
        }
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide3(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length(); // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException
            int result = num1 / num2; // arr[0]이 "   "일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }catch(Exception e){ // 플랜 B
            System.out.println(e.getMessage());
        }
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide4(int num1, String[] arr){
        if(arr != null && arr.length > 0 && arr[0] != null && arr[0].trim().length() > 0){
            int num2 = arr[0].trim().length(); // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException
            int result = num1 / num2; // arr[0]이 "   "일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }
    }
}