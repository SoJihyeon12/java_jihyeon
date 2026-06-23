package level01.day01;

import java.util.Scanner;

public class Prob03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int i = 0;
        while (i < n) {
            System.out.print(str);
            i++;
        }
    }
}
