package ch11.lms;

public class 교수 {
    // 필드
    int 교수번호;
    String 이름;
    String 학과;
    String[] 담당과목;
    String[] 소속;

    // 메서드
    String 학생을조회한다(){
        return "하루";
    }

    String[] 담당과목목록을조회한다(){
        return new String[]{"자바, DB"};
    }

    void 강의를개설한다(String 과목명){
        System.out.println(과목명 + " 개설되었습니다.");
    }
}
