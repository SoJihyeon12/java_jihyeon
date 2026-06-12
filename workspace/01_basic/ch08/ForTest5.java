package ch08;

public class ForTest5 {
    public static void main(String[] args){
//        star1();
//        star2();
//        star3();
        star4();
    }


    // *
    // **
    // ***
    // ****
    // *****
    static void star1(){
        for(int i=0; i<1; i++){ // i가 0일때 별 하나 출력, i가 1되면 출력문 실행안하고 바로종료
            System.out.print("*"); // *
        }
        System.out.println();

        for(int i=0; i<2; i++){ // i가 0,1일때 별 하나씩 2개 출력, i가 2되면 출력문 실행안하고 바로종료
            System.out.print("*"); // **
        }
        System.out.println();

        for(int i=0; i<3; i++){ // i가 0,1,2일때 별 하나씩 3개 출력, i가 3되면 출력문 실행안하고 바로종료
            System.out.print("*"); // ***
        }
        System.out.println();

        for(int i=0; i<4; i++){ // i가 0,1,2,3일때 별 하나씩 4개 출력, i가 4되면 출력문 실행안하고 바로종료
            System.out.print("*"); // ****
        }
        System.out.println();

        for(int i=0; i<5; i++){ // i가 0,1,2,3,4일때 별 하나씩 5개 출력, i가 5되면 출력문 실행안하고 바로종료
            System.out.print("*");// *****
        }
        System.out.println();
    }

    // *
    // **
    // ***
    // ****
    // *****
    // ...
    // **... ** 50개
    static void star2(){
        for(int i=0; i<5; i++) { // i가 0,1,2,3,4일때 줄 만드는 것
            for (int k = 0; k < i+1; k++) { // 여기서는 k++이나 ++k나 동일하게 작용, 줄이 넘어가면 k는 다시 0이됨
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // *****
    // ****
    // ***
    // **
    // *
    static void star3(){
        for(int i=0; i<5; i++) { // i가 0,1,2,3,4일때 줄 만드는 것
            for (int k = 0; k < 5-i; k++) { // 여기서는 k++이나 ++k나 동일하게 작용, 줄이 넘어가면 k는 다시 0이됨
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //    *
    //   **
    //  ***
    // ****
    //*****
    static void star4(){
        for(int i=0; i<10; i++) {
            for (int k = 0; k < (10-1-i); k++) { // 여기서는 k++이나 ++k나 동일하게 작용, 줄이 넘어가면 k는 다시 0이됨
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++) { // 여기서는 k++이나 ++k나 동일하게 작용, 줄이 넘어가면 k는 다시 0이됨
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
