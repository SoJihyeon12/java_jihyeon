package ch13.supercar;

public class SuperCar {
    int zero100;

    SuperCar(int zero100){
        this.zero100 = zero100;
    }

    void move(){
        // 4
        System.out.println("슈퍼카가 100미터를 달리는데 " + zero100 + "초 걸렸다.");
    }
}

