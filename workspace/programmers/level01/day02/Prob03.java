package level01.day02;

import java.util.Scanner;

public class Prob03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str.length()>=1&&str.length()<=10){
            for(int i=0; i< str.length(); i++){
                System.out.println(str.charAt(i));
            }
        }
    }
}
