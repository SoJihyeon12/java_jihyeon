package ch11.capsule.ex02;

// 시험 결과를 관리하는 클래스
// 캡슐화를 통해서 불필요한 sum 호출을 막음
// 기본 생성자 대신 각 점수를 전달받는 생성자로 수정
// 필드를 private으로 지정해서 외부의 직접 접근을 제한함
public class Score {
    private int kor;
    private int eng;
    private int math;

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    // Getter 메서드
    public int getMath(){ // 수학 점수를 반환한다.
        return this.math;
    }

    // Setter 메서드
    public void setMath(int math){ // 수학 점수를 새로운 값으로 교체한다.
        if(math > 100 || kor < 0){
            System.out.println("math 값은 0 ~ 100 사이로 입력해야 됩니다.");
        }else{
            this.math = math;
        }
    }

    public Score(int kor, int eng) {
        this.kor = kor;
        this.eng = eng;
    }

    Score(int kor, int eng, int math){
        if(kor > 100 || kor < 0){
            System.out.println("kor 값은 0 ~ 100 사이로 입력해야 됩니다.");
        }else{
            this.kor = kor;
        }
        if(eng > 100 || kor < 0){
            System.out.println("eng 값은 0 ~ 100 사이로 입력해야 됩니다.");
        }else{
            this.eng = eng;
        }
        if(math > 100 || kor < 0){
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