package ch01;
// 이 코드는 여러 가지 예외를 처리하는 방법을 비교하는 예제
// 핵심은 divide(), divide2(), divide3(), divide4()가 같은 기능을 하지만 예외를 처리하는 방식이 다르다는 것

public class MultiCatchTest {
    void main(){ // 각 호출에서 어떤 일이 발생하는지 테스트하는 코드
        // 이 코드는 divide4() 메서드를 호출하면서 두 개의 인수를 전달하는 코드
        divide4(100, new String[] {" hello  "}); // 정상, 정수 100과 문자열 하나{" hello  "}가 들어 있는 배열을 divide4() 메서드에 전달하여 호출한다."**는 뜻
        divide4(100, new String[] {"   "}); // ArithmeticException, 정수 100과 공백 문자열(" ")이 들어 있는 String 배열을 divide4() 메서드에 전달하여 호출하는 코드
        divide4(100, new String[] {}); // 100을 첫 번째 인수로 전달한다, 요소가 하나도 없는 빈 String 배열을 두 번째 인수로 전달한다.
        divide4(100, new String[] {null}); // 첫 번째 인수(num1)로 100을 전달한다. 첫 번째 요소가 null인 String 배열을 만들어 두 번째 인수(arr)로 전달한다.
        divide4(100, null); // 100 → 첫 번째 인수(num1)로 100을 전달한다. 두 번째 인수(arr)로 배열이 없는 상태를 전달한다.

        System.out.println("프로그램 종료.");
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide(int num1, String[] arr){
        try{ // 예외가 발생할 가능성이 있는 코드를 실행하는 영역

            int num2 = arr[0].trim().length(); //arr[0]: 배열의 첫 번째 값을 가져옵니다. trim(): 앞뒤 공백을 제거합니다. length(): 공백을 제거한 문자열의 길이를 구합니다.
            // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException

            int result = num1 / num2; // 나눗셈을 수행합니다. num2는 맨위에 첫번째 값을 예로 들면 {" hello  "}의 "hello"를 꺼내고 공백제거하고 문자열길이를 구한 값 5가 나오는 것
            // arr[0]이 "   "일 경우 ArithmeticException 발생

            System.out.println(num1 + " / " + num2 + " = " + result);

        }catch(ArithmeticException | NullPointerException e){ // ArithmeticException이 발생하거나 NullPointerException이 발생하면 둘 다 같은 catch 블록에서 처리하겠다는 의미입니다.
            // ArithmeticException은 산술 연산(계산) 중에 문제가 발생했을 때 생기는 예외, NullPointerException은 객체가 없는데(null) 객체를 사용하려고 할 때 발생하는 예외입니다.
            System.out.println(e.getMessage()); // e.getMessage() : 예외(Exception)가 발생한 이유를 문자열(String)로 가져오는 메서드입니다.
        }catch(ArrayIndexOutOfBoundsException e){ // ArrayIndexOutOfBoundsException은 배열의 존재하지 않는 인덱스(번호)에 접근했을 때 발생하는 예외, 그 예외를 e라는 변수에 저장
            System.out.println("arr 사이즈가 0입니다.");
        }
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide2(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length(); //arr[0]: 배열의 첫 번째 값을 가져옵니다. trim(): 앞뒤 공백을 제거합니다. length(): 공백을 제거한 문자열의 길이를 구합니다.
            // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException

            int result = num1 / num2; // 나눗셈을 수행합니다. num2는 맨위에 첫번째 값을 예로 들면 {" hello  "}의 "hello"를 꺼내고 공백제거하고 문자열길이를 구한 값 5가 나오는 것
            // arr[0]이 "   "일 경우 ArithmeticException 발생

            System.out.println(num1 + " / " + num2 + " = " + result);

        }catch(ArrayIndexOutOfBoundsException e){ // 플랜 C, // ArrayIndexOutOfBoundsException은 배열의 존재하지 않는 인덱스(번호)에 접근했을 때 발생하는 예외, 그 예외를 e라는 변수에 저장
            System.out.println("arr 사이즈가 0입니다.");
        }catch(Exception e){ // 플랜 B, catch(Exception e)는 Exception과 그 자식 예외가 발생하면 여기서 처리하겠다."라는 뜻
            System.out.println(e.getMessage()); // e.getMessage() : 예외(Exception)가 발생한 이유를 문자열(String)로 가져오는 메서드입니다.
        }
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide3(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length();  //arr[0]: 배열의 첫 번째 값을 가져옵니다. trim(): 앞뒤 공백을 제거합니다. length(): 공백을 제거한 문자열의 길이를 구합니다.
            // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException

            int result = num1 / num2; // 나눗셈을 수행합니다. num2는 맨위에 첫번째 값을 예로 들면 {" hello  "}의 "hello"를 꺼내고 공백제거하고 문자열길이를 구한 값 5가 나오는 것
            // arr[0]이 "   "일 경우 ArithmeticException 발생

            System.out.println(num1 + " / " + num2 + " = " + result);

        }catch(Exception e){ // 플랜 B
            System.out.println(e.getMessage());
        }
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide4(int num1, String[] arr){
        if(arr != null && arr.length > 0 && arr[0] != null && arr[0].trim().length() > 0){
        // 이 조건은 안전하게 계산할 수 있는지 하나씩 확인하는 것, arr != null: 배열 자체가 있는지 확인, arr.length > 0: 배열에 요소가 하나 이상 있는지 확인, arr[0] != null: 첫 번째 값이 null이 아닌지 확인
        // arr[0].trim().length() > 0 : 공백을 제거한 후 길이가 0보다 큰지 확인

            int num2 = arr[0].trim().length(); //arr[0]: 배열의 첫 번째 값을 가져옵니다. trim(): 앞뒤 공백을 제거합니다. length(): 공백을 제거한 문자열의 길이를 구합니다.
            // arr[0]이 null일 경우 NullPointerException 발생, arr가 빈 배열일 경우 ArrayIndexOutOfBoundsException

            int result = num1 / num2; // 나눗셈을 수행합니다. num2는 맨위에 첫번째 값을 예로 들면 {" hello  "}의 "hello"를 꺼내고 공백제거하고 문자열길이를 구한 값 5가 나오는 것
            // arr[0]이 "   "일 경우 ArithmeticException 발생

            System.out.println(num1 + " / " + num2 + " = " + result);
        }
    }
}