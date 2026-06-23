package level01.day01;

import java.util.Scanner;

public class Prob04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        StringBuilder result = new StringBuilder();

        if(1<=a.length()&&a.length()<=20) {
            for (int i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);

                if (Character.isUpperCase(ch)) {
                    result.append(Character.toLowerCase(ch));
                } else {
                    result.append(Character.toUpperCase(ch));
                }
            }
        }

        System.out.println(result.toString());
    }
}
