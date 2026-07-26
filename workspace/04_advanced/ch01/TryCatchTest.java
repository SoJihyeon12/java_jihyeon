package ch01;
//이 코드는 try-catch-finally의 실행 순서와 return이 있어도 finally가 실행되는지를 배우기 위한 예제입니다.

public class TryCatchTest {
    void main(){
        divide(100, new String[] {" hello  "}); // 정상, 정수 100과 문자열 하나{" hello  "}가 들어 있는 배열을 divide4() 메서드에 전달하여 호출한다."**는 뜻
        divide(100, new String[] {"   "}); // ArithmeticException, 정수 100과 공백 문자열(" ")이 들어 있는 String 배열을 divide4() 메서드에 전달하여 호출하는 코드
        divide(100, new String[] {}); // 100을 첫 번째 인수로 전달한다, 요소가 하나도 없는 빈 String 배열을 두 번째 인수로 전달한다.
        divide(100, new String[] {null}); // 첫 번째 인수(num1)로 100을 전달한다. 첫 번째 요소가 null인 String 배열을 만들어 두 번째 인수(arr)로 전달한다.

        System.out.println("프로그램 종료.");
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length(); //arr[0]: 배열의 첫 번째 값을 가져옵니다. trim(): 앞뒤 공백을 제거합니다. length(): 공백을 제거한 문자열의 길이를 구합니다.
            // str이 null일 경우 NullPointerException 발생

            int result = num1 / num2; // 나눗셈을 수행합니다. num2는 맨위에 첫번째 값을 예로 들면 {" hello  "}의 "hello"를 꺼내고 공백제거하고 문자열길이를 구한 값 5가 나오는 것
            // str이 ""일 경우 ArithmeticException 발생

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
// 첫번째 메서드 호출은 System.out.println(num1 + " / " + num2 + " = " + result);까지 해서 return 해서 메서드 종료될 줄 알았지만 finally는 반드시 실핻된다.
// 두번째 메서드 호출은 100/0 하면서 ArithmeticException(수학(산술) 연산을 잘못했을 때 발생하는 자바의 기본 예외) 발생됨 그리고 finally 실행
// 세번째 메서드 호출은 배열이 비어서 arr.length = 0이지만 arr[0]을 꺼내려고 해서 ArrayIndexOutOfBoundsException(배열에 존재하지 않는 인덱스(index)에 접근하려고 할 때 발생하는 자바의 기본 예외) 발생, 실행되는 catch "arr 사이즈가 0입니다." 그리고 finally 실행
// 네번째 메서드 호출은 arr[0] = null인데 arr[0].trim() 실행해서 NullPointerException(null인 객체를 사용하려고 할 때 발생하는 자바의 기본 예외) 발생, 실행되는 catch-> arr[0]이 null입니다. 그리고 return을 만나서 종료되나 싶지만 finally 실행됨
