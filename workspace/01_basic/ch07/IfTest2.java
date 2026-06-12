package ch07;

// 입력받은 월(month)의 마지막 날짜를 출력하세요.(윤달은 계산하지 않음)
public class IfTest2 {
    public static void main (String[] args) {
        int month = 4;

        if (month < 1 || month > 12) { // 입력한 month가 1보다 작고, 12보다 크면
            System.out.println("1~12 사이의 숫자만 가능합니다.");
//            System.exit(0); // 프로그램 강제 종료
        } else {
            // v04
            if (month == 4 || month == 6 || month == 9 || month == 11) { // month가 4, 6, 9, 11일때
                System.out.println(month + "월의 마지막 날은 30일 입니다.");
            } else if (month == 2) { // month가 2일때
                System.out.println(month + "월의 마지막 날은 28일 입니다.");
            } else {
                System.out.println(month + "월의 마지막 날은 31일 입니다.");
            }

            // v03
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                System.out.println(month + "월의 마지막 날은 31일 입니다.");
            } else if (month == 2) {
                System.out.println(month + "월의 마지막 날은 28일 입니다.");
            } else {
                System.out.println(month + "월의 마지막 날은 30일 입니다.");
            }

            // v02
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                System.out.println(month + "월의 마지막 날은 31일 입니다.");
            } else if (month == 2) {
                System.out.println(month + "월의 마지막 날은 28일 입니다.");
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                System.out.println(month + "월의 마지막 날은 30일 입니다.");
            }

            // v01
            if (month == 1) {
                System.out.println("1월의 마지막 날은 31일 입니다.");
            } else if (month == 2) {
                System.out.println("2월의 마지막 날은 28일 입니다.");
            } else if (month == 3) {
                System.out.println("3월의 마지막 날은 31일 입니다.");
            } else if (month == 4) {
                System.out.println("4월의 마지막 날은 30일 입니다.");
            } else if (month == 5) {
                System.out.println("5월의 마지막 날은 31일 입니다.");
            } else if (month == 6) {
                System.out.println("6월의 마지막 날은 30일 입니다.");
            } else if (month == 7) {
                System.out.println("7월의 마지막 날은 31일 입니다.");
            } else if (month == 8) {
                System.out.println("8월의 마지막 날은 31일 입니다.");
            } else if (month == 9) {
                System.out.println("9월의 마지막 날은 30일 입니다.");
            } else if (month == 10) {
                System.out.println("10월의 마지막 날은 31일 입니다.");
            } else if (month == 11) {
                System.out.println("11월의 마지막 날은 30일 입니다.");
            } else if (month == 12) {
                System.out.println("12월의 마지막 날은 31일 입니다.");
            }
        }
    }
}