package ch09;

public class ArrayBasic {
    public static void main(String[] args){ //args라는 변수를 가진 문자열 배열 선언
        // scores int 배열을 선언하고 생성하세요.(크기는 3)
        int[] scores =new int[3];

        // names String 배열을 선언하고 생성하세요.(크기는 3)(크기는 5)
//        String[] names = new String[3];
        String[] names = new String[5];

        // scores 배열의 각 요소에 값을 할당
        scores[0] = 90;
        scores[1] = 80;
        scores[2] = 75;

        // names 배열의 각 요소에 값을 할당
//        String[] names = new String[]{"하루", "나무", "브롱이"};

        names[0] = "나무";
        names[1] = "하루";
        names[2] = "브롱이";
        names[3] = "몽이";
        names[4] = "김코딱지";

        // scores 배열의 두번째 요소값을 출력
        System.out.println(scores[1]); //첫번째 요소는 0, 두번째 요소는 1

        // names 배열의 모든 요소값을 출력
//        System.out.println(names[0]);
//        System.out.println(names[1]);
//        System.out.println(names[2]);
//        System.out.println(names[3]);
//        System.out.println(names[4]);

        for(int i=0; i<names.length; i++){ //외우기, 자주 쓰게 됨, i<names.length(배열의 끝까지)
            System.out.println(names[i]); // i=0일때 names[0]=나무,i=1 names[1]=하루
        }
    }
}
