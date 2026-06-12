package ch12.car;

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

//        Bus mycar2 = new Bus("전기버스", "3005", "광역 버스"
//                , new String[]{"김포 시청", "발산역", "홍대역", "서울 시청"}
//                , 3500, 45);

        Bus mycar2 = new Bus("람보르기니", "10-2", "마을 버스"
                , new String[]{"우리집", "김포고등학교", "김포 시청"}
                , 1300, 15);

        mycar2.start();
        mycar2.speedUp(50);
        mycar2.stop();

        mycar2.ride(4);
        mycar2.start();
        mycar2.speedUp();
        mycar2.stop();

        mycar2.ride(10);
        mycar2.leave(2);
        mycar2.start();
        mycar2.speedUp(30);
        mycar2.speedDown();
        mycar2.stop();

        mycar2.leave(2);
        mycar2.ride(12);

        System.out.println(mycar);
        System.out.println(mycar2);

        // 버스 노선이 같으면 같은 버스로 다루고 싶음
        System.out.println(mycar.equals(mycar2));
        System.out.println(mycar.hashCode());
        System.out.println(mycar2.hashCode());
    }
}
