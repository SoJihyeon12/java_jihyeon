package ch13.supercar;

public class ElectricCar extends SuperCar implements Chargeable {
    // 컴파일러에 의해서 기본 생성자 만들어짐
//    ElectricCar() { super(); }

    ElectricCar(int zero100){
        super(zero100);
    }

    @Override
    void move() {
        super.move();
        System.out.println("전기를 사용합니다.");
    }

    public void charge(){
        System.out.println("전기를 충전합니다.");
    }
}
