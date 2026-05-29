package ch08;

// 1~9 구구단 (2단부터 9단까지만)
// 2 x 1 = 2  3 x 1 = 3  ...  9 x 1 = 9
// 2 x 2 = 4  3 x 2 = 6  ...  9 x 2 = 18
// ...        ...        ...  9 x 3 = 27
// 2 x 9 =18  3 x 9 = 27

public class ForTest6 {
    public static void main(String[] args){
        for(int i=1; i<=9; i++){ // 9행
            for(int k=2; k<=9; k++){ // 8열
                System.out.print(k + "x" + i + "="+ (k*i) + "\t" ); // k = 2, 3, 4 ... 9, \t는 일정 간격 띄어쓰기
            }
            System.out.println();
        }
    }
}
