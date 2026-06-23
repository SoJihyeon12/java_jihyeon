package ch01;

public class TryCatchTest {
    void main(){
        divide(100, new String[] {" hello  "}); // 정상
        divide(100, new String[] {"   "}); // ArithmeticException
        divide(100, new String[] {});
        divide(100, new String[] {null});

        System.out.println("프로그램 종료.");
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length(); // str이 null일 경우 NullPointerException 발생
            int result = num1 / num2; // str이 ""일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
            return;
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }catch(NullPointerException e) {
            System.out.println("arr[0]이 null입니다.");
            return;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("arr 사이즈가 0입니다.");
        }finally{
            System.out.println("finally는 try-catch 블럭이 실행된 뒤 항상 실행을 보장.");
        }

        System.out.println("finally 블럭과 try-catch 다음줄에 실행되는 코드는 무슨차이???");
    }
}