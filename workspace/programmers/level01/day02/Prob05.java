package level01.day02;

public class Prob05 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int l = overwrite_string.length();
        int l2 = my_string.length();

        answer = my_string.substring(0,s) + overwrite_string + my_string.substring(s+l, l2);
        return answer;
    }

    public static void main(String[] args) {
        Prob05 p = new Prob05();
        System.out.println(p.solution("He11oWor1d", "lloWorl", 2));
        System.out.println(p.solution("Program29b8UYP", "merS123", 7));
    }
}


