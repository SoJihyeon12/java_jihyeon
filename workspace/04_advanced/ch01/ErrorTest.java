package ch01;

public class ErrorTest {
    public static void main(String[] args){
        try{ // 플랜 A
            int num = Integer.parseInt(args[0]);
            int result = 10 / num;
            System.out.println("result: " + result);
        }catch(ArithmeticException e){ // 플랜 B
            System.out.println(e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){ // 플랜 C
            System.out.println(e.getMessage());
        }

        try{
            makeError();
        }catch(Throwable t){
            t.printStackTrace();
            System.out.println("에러 발생: " + t.getClass().getSimpleName());
        }

        System.out.println("프로그램 종료.");
    }

    static void makeError(){
        makeError(); // 재귀 호출
    }
}