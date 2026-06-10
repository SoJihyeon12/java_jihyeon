package ch13.supercar;

public class GasolineCar extends SuperCar{
    // 컴파일러에 의해서 기본 생성자 만들어짐
//    GasolineCar() { super(); }

    GasolineCar(int zero100){
        super(zero100);
    }

    @Override
    void move() {
        // 3
        super.move();
        // 5
        System.out.println("기름을 사용합니다.");
    }
}
