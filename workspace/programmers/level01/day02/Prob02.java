package level01.day02;

import java.util.Scanner;

public class Prob02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        if((str1.length()>=1&&str1.length()<=10)&&(str2.length()>=1&&str2.length()<=10)){
            System.out.println(str1+str2);
        }
    }
}
