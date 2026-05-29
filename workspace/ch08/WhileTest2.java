package ch08;

// 첫달에 1원을 받고 매달 두배씩 받을 때
// 몇달이 지나야 급여가 1억을 넘기는가?
public class WhileTest2 {
    public static void main(String[] args){
        int  month = 1;
        int sal = 1;

        while(sal < 100000000){
            month++;
            sal *= 2;
        }

        System.out.println(month + "달의 급여: " + sal);
    }
}
