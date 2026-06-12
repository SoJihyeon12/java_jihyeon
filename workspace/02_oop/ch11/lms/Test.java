package ch11.lms;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        강의실 room1 = new 강의실(); // 인스턴스
        room1.위치 = "인문동";
        room1.호수 = 102;
        room1.수용인원 = 30;

        강의실 room2 = new 강의실();
        room2.위치 = "공대";
        room2.호수 = 304;
        room2.수용인원 = 20;

        과목 sub1 = new 과목();
        sub1.과목번호 = 1;
        sub1.과목명 = "인문학 개론";
        sub1.강의시간 = "월요일 3~4교시";
        sub1.수용인원 = 25;
        sub1.담당교수 = "김교수";
        sub1.진행강의실 = room1;

        과목 sub2 = new 과목();
        sub2.과목번호 = 2;
        sub2.과목명 = "자바 기초";
        sub2.강의시간 = "수요일 1~2교시";
        sub2.수용인원 = 20;
        sub2.담당교수 = "박교수";
        sub2.진행강의실 = room2;

        학생 s1 = new 학생();
        s1.생년월일 = 20050105;
        s1.학번 = "2025123";

        학생 s2 = new 학생();
        s2.생년월일 = 20030804;
        s2.학번 = "2023456";

        교수 l1 = new 교수();
        l1.이름 = "김교수";

        교수 l2 = new 교수();
        l2.이름 = "박교수";

        l1.강의를개설한다("자바 기초");
        String[] subList = l1.담당과목목록을조회한다();
        System.out.println(Arrays.toString(subList));

        String[] result = s1.과목을조회한다();
        System.out.println(Arrays.toString(result));
    }
}
