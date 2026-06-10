package ch14;

public class StringTest {
    public static void main(String[] args){
        String s1 = "Hello";
        String s2 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1 == "Hello");
        System.out.println(s2 == "Hello");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals("Hello"));
        System.out.println(s2.equals("Hello"));

        s1 += " World";
        s1 += " Java";
        s1 += " Program";

        System.out.println(s1);


    }
}
