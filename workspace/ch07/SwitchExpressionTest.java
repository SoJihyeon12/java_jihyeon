package ch07;

public class SwitchExpressionTest {
    public static void main(String[] args){
        String role = "USER";
        switch(role){
            case "ADMIN":
                System.out.println("관리자 권한");
                break; // 기존 스위치문은 case 마지막에 break가 있어야 함
            case "USER":
                System.out.println("일반 사용자 권한");
                break;
            default: // 나머지 외의 것들은 default로 묶기
                System.out.println("권한 없음");
                break;
        }

        // switch expression 새로운 switch
        switch(role){
            case "ADMIN" -> System.out.println("관리자 권한"); // 새 스위치문은 case 마지막에 break 없음
            case "USER" -> System.out.println("일반 사용자 권한");
            default -> System.out.println("권한 없음");
        }

        String result = switch(role){
            case "ADMIN" -> "관리자 권한";
            case "USER" -> "일반 사용자 권한";
            default -> "권한 없음";
        }; //여기에서는 세미콜론 ; 을 붙여준다. 이 switch(role)자체가 하나의 값을 만들어서 변수에 대입하는 표현식이다.
        System.out.println(result);         // 이 스위치문이 여러가지 들어있지만 하나의 표현식이라는 의미

        String day = "월요일";
        String type = switch(day){ //switch(day {내용}; 이거는 값이고, 그 앞에 string type이 변수임
            case "월요일", "화요일", "수요일", "목요일", "금요일" -> "평일";
            case "토요일", "일요일" -> "주말";
            default -> "잘못된 요일";
        }; // 이 스위치문이 여러가지 들어있지만 하나의 표현식이라는 의미
        System.out.println(type);

        int score = 90;
        String grade = switch(score){
            case 100, 90 -> {
                System.out.println("훌륭한 성적입니다.");
                yield "A"; // yield란 switch문에서 switch문 밖으로 값을 반환함, case문이 2줄 이상(출력문&값 반환문)일때 사용
            } // 2가지 이상일 때 { } 추가해서 내용 넣기       + return이 메서드 밖으로 값 반환이면
            case 80 -> "B";                            //  yield는 switch 밖으로 값 반환
            case 70 -> "C";                            // 메서드란 기능(작업)을 담아놓은 코드 묶음
            case 60 -> "D";                //println() → 출력 메서드, random() → 랜덤 메서드, main() → 프로그램 시작 메서드
            default -> "F";
        };
        System.out.println("학점: " + grade);
    }
}
