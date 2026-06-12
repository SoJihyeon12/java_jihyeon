package ch08;

public class ForTest { //WhileTest를 좀더 간략하게 표현가능
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]); // (args[0])에 들어온 값은 문자열(String), args는 배열변수이름, [0]은 배열번호 0번
        int sum = 0;                         // Integer.parseInt() = 문자열을 int 숫자로 변환
                                             // 즉, 첫 번째 입력값(String)을 숫자(int)로 변환 하는 코드
        for(int i = 1; i <= num; i++){
            sum += i;
            System.out.println("i: " + i + ", sum: " + sum);
        }

        System.out.println("1부터 " + num + "까지의 합계: " + sum);
    }
}

// 여기서는 Scanner가 아닌 program argument 사용
// Program Argument는 프로그램 시작 전에 외부에서 전달하는 입력값
// program argument는 키보드 입력(Scanner)과 달리 프로그램이 시작될 때 이미 전달되어 있는 값
// Integer.parseInt()를 쓰는 이유는 program argument의 값이 문자열이기 때문
// Program Argument의 값은 하나만 입력할 경우 배열 번호 0번에 들어감
// 만약 2개(ex> 1, 2) 입력하면 배열번호 0번, 1번에 들어감,
// 3개 입력하면 배열번호 0번, 1번, 2번에 들어가겠지.