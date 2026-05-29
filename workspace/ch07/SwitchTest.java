package ch07;

// 입력받은 월(month)에 마지막 날짜를 출력하세요.(윤달은 계산하지 않음)
public class SwitchTest {
    public static void main(String[] args) {
        int month = 4;

        if(month < 1 || month > 12) { //month가 1보다 작거나 12보다 크면
            System.out.println("1~12 사이의 숫자를 입력해야 합니다.");
            System.exit(0);
        }

        // v04
        int lastDay = 0;
        switch (month) {
            case 2:
                lastDay = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                lastDay = 30;
                break;
            default:
                lastDay = 31;
                break;
        } // switch

        System.out.println(month + "월의 마지막 날은 " + lastDay + "일 입니다.");

        // v03
        switch (month) {

            case 2:
                System.out.println(month + "월의 마지막 날은 28일 입니다.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + "월의 마지막 날은 30일 입니다.");
                break;
            default:
                System.out.println(month + "월의 마지막 날은 31일 입니다.");
                break;
        } // switch

        // v02
        switch (month) {

            case 2:
                System.out.println(month +"월의 마지막 날은 28일 입니다.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month +"월의 마지막 날은 30일 입니다.");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month +"월의 마지막 날은 31일 입니다.");
                break;
        } // switch

        // v01
        switch (month) {
            case 1:
                System.out.println("1월의 마지막 날은 31일 입니다.");
                break;
            case 2:
                System.out.println("2월의 마지막 날은 28일 입니다.");
                break;
            case 3:
                System.out.println("3월의 마지막 날은 31일 입니다.");
                break;
            case 4:
                System.out.println("4월의 마지막 날은 30일 입니다.");
                break;
            case 5:
                System.out.println("5월의 마지막 날은 31일 입니다.");
                break;
            case 6:
                System.out.println("6월의 마지막 날은 30일 입니다.");
                break;
            case 7:
                System.out.println("7월의 마지막 날은 31일 입니다.");
                break;
            case 8:
                System.out.println("8월의 마지막 날은 31일 입니다.");
                break;
            case 9:
                System.out.println("9월의 마지막 날은 30일 입니다.");
                break;
            case 10:
                System.out.println("10월의 마지막 날은 31일 입니다.");
                break;
            case 11:
                System.out.println("11월의 마지막 날은 30일 입니다.");
                break;
            case 12:
                System.out.println("12월의 마지막 날은 31일 입니다.");
                break;
        } // switch
        System.out.println("프로그램 종료.");
    } // main
} // class
