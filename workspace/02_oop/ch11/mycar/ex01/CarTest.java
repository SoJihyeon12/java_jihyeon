package ch11.mycar.ex01;

public class CarTest {
    void main(){
        // Car 인스턴스를 생성한다.
        // 인스턴스를 생성할 때 사용한 클래가 생성한 인스턴스의 타입이 된다.
        Car mycar = new Car();

        // 인스턴스의 필드나 메서드를 접근할때 . 연산자를 사용한다.
        mycar.model = "부가티";

        mycar.start();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.speedUp();

        mycar.stop();
    }
}
