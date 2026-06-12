package ch08;

// 첫달에 1원을 받고 매달 두배씩 받을 때
// 3년째 되는 달에는 얼마를 받는가?
public class ForTest2 {
    public static void main(String[] args){
        long sal = 1; // 월급

        for(int month = 1; month <= 36; month++){
            System.out.println(month + "달의 급여: " + sal);
            sal *= 2;
        }

        System.out.println("3년째의 급여: " + sal);
    }
}

//만약 month가 37이 되면 month <= 36 조건에 맞지 않아서 바로 for문 종료