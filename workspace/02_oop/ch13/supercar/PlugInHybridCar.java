package ch13.supercar;

public class PlugInHybridCar extends SuperCar implements Chargeable{

    PlugInHybridCar(int zero100){
        super(zero100);
    }

    @Override
    void move() {
        super.move();
        System.out.println("기름과 전기를 사용합니다.");
    }

    public void charge(){
        System.out.println("전기를 충전합니다.");
    }
}
