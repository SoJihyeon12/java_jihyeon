package ch12.mycar;

public class CarTest {
    void main(){
        Car mycar = new Car("람보르기니");
        mycar.speed = 100;

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