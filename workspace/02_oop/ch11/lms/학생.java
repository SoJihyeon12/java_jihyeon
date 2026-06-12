package ch11.lms;

public class 학생 {
    // 필드(멤버변수) 선언
    String 학번;
    String 학과;
    String 이름;
    String 전화번호;
    int 생년월일;
    byte 학년;

    // 메서드 작성
    String[] 과목을조회한다(){
        String[] 과목목록 = {"자바 기초", "자바 고급", "인문학 개론"};
        return 과목목록;
    }

    boolean 수강신청한다(String 과목){
        System.out.println(과목 + " 수강신청합니다.");
        return true;
    }

    String 교수조회(int 교수번호){
        return "아무개 교수";
    }


}
