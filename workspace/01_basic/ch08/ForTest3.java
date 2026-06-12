package ch08;

public class ForTest3 {
    public static void main(String[] args){
        // 10부터 1까지 카운트 다운
        for(int i=10; i >= 1; i--){ // i : 10, 9, 8... 2, 1
            System.out.println("카운트 다운: " + i);
        }
        System.out.println("발사!!!");
    }
}
// i가 0이 되면 for문을 종료하고 발사!