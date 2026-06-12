package ch11.capsule.ex02;

// 시험 결과를 관리하는 클래스
// 캡슐화를 통해서 불필요한 sum 호출을 막음
// 기본 생성자 대신 각 점수를 전달받는 생성자로 수정
// 필드를 private으로 지정해서 외부의 직접 접근을 제한함
// Getter와 Setter는 private으로 숨겨 놓은 변수에 접근하기 위한 메서드
// Getter와 Setter는 캡슐화에서 아주 많이 사용됨

// Getter의 특징
// 1. 이름이 보통 get으로 시작
// 2. 매개변수(괄호 안)가 없음
// 3. 값을 return 함

// Setter의 특징
// 1. set으로 시작
// 2. 매개변수가 있음 (int kor)
// 3. 보통 void
// 4. 값을 반환하지 않음

// getKor()   // 국어 점수 가져오기
// getMath()  // 수학 점수 가져오기

// setKor(90)   // 국어 점수 변경
// setMath(80)  // 수학 점수 변경

public class Score {
    private int kor;
    private int eng;
    private int math;

    public int getKor() { // 국어 점수를 반환
        return kor;
    }

    public void setKor(int kor) { // 국어 점수를 변경
        this.kor = kor; // this. → 객체 안에서 "현재 객체 자신"을 가리킬 때 사용
    }

    public int getEng() { // 영어 점수를 반환
        return eng;
    }

    public void setEng(int eng) { // 영어 점수를 변경
        this.eng = eng;
    }

    // Getter 메서드
    public int getMath(){ // 수학 점수를 반환한다.
        return this.math;
    }

    // Setter 메서드
    public void setMath(int math){ // 수학 점수를 새로운 값으로 교체한다.
        if(math > 100 || math < 0){
            System.out.println("math 값은 0 ~ 100 사이로 입력해야 됩니다.");
        }else{
            this.math = math;
        }
    }

    public Score(int kor, int eng) { // 점수 2개를 받는 생성자, 생성자 오버로딩
        this.kor = kor;
        this.eng = eng;
    }

    Score(int kor, int eng, int math){ // 점수 3개를 받고 유효성 검사까지 하는 생성자, 생성자 오버로딩
        if(kor > 100 || kor < 0){
            System.out.println("kor 값은 0 ~ 100 사이로 입력해야 됩니다.");
        }else{
            this.kor = kor;
        }
        if(eng > 100 || eng < 0){
            System.out.println("eng 값은 0 ~ 100 사이로 입력해야 됩니다.");
        }else{
            this.eng = eng;
        }
        if(math > 100 || math < 0){
            System.out.println("math 값은 0 ~ 100 사이로 입력해야 됩니다.");
        }else{
            this.math = math;
        }
    }

    // 총점을 계산해서 반환하는 메서드
    private int sum(){
        return kor + eng + math;
    }

    // 평균을 계산해서 반환하는 메서드(소수 세째자리에서 반올림)
    double avg(){
//        int sum = kor + eng + math;
        double result = Math.round(100 * sum() / 3.0) / 100.0;
        return result;
    }

}