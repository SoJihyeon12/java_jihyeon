package ch12.mycar;

public class BusTest {
    void main(){
        Bus mycar = new Bus("람보르기니", "10-2", "마을 버스"
                , new String[]{"우리집", "김포고등학교", "김포 시청"}
                , 1300, 15);
        mycar.start();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.stop();

        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();

        mycar.start();
        mycar.speedUp();
        mycar.stop();
        mycar.ride();
        mycar.ride();
        mycar.leave();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();

        mycar.start();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedDown();
        mycar.stop();
        mycar.leave();
        mycar.leave();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();
        mycar.ride();

        System.out.println(mycar.getBusInfo());
    }
}