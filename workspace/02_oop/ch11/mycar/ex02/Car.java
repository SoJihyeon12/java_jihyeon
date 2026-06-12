package ch11.mycar.ex02;

// 필드와 메서드 정의한 클래스
// 생성자 추가
public class Car {
    // 필드
    String model;
    int speed; // 필드를 초기화 하지 않으면 기본값으로 초기화 됨
    int gear;

    // 생성자: 인스턴스가 생성될 때 자동으로 호출되는 메서드
    // 클래스 내부에 생성자를 하나도 만들지 않을 경우에 자바 컴파일러가 기본 생성자를 만들어준다.
    // 생성자를 하나라도 명시적으로 만들었을 경우에는 기본 생성자가 만들어지지 않음.
    // 기본 생성자: 매개변수가 없는 생성자
    Car(){
        System.out.println("Car() 생성자 호출됨.");
    }

    // 생성자는 오버로딩이 가능함
    Car(String model){
        System.out.println("Car(String name) 생성자 호출됨.");
        this.model = model; // this는 자기 자신 인스턴스의 참조 변수
    }

    // 생성자는 오버로딩이 가능함
    Car(String model, int speed){
        System.out.println("Car(String name) 생성자 호출됨.");
        this.model = model; // this는 자기 자신 인스턴스의 참조 변수
        this.speed = speed;
    }

    // 10Km/h 가속한다.
    void speedUp(){
        speed += 10;
        System.out.println("가속합니다. 현재 속도는 " + speed + "Km/h 입니다.");
    }

    // 10Km/h 감속한다.
    void speedDown(){
        speed -= 10;
        System.out.println("감속합니다. 현재 속도는 " + speed + "Km/h 입니다.");
    }

    // 기어를 1단 올린다.
    void gearUp(){
        gear++;
        System.out.println("기어를 1단 올려서 " + gear + "단이 되었습니다.");
    }

    // 기어를 1단 내린다.
    void gearDown(){
        gear--;
        System.out.println("기어를 1단 내려서 " + gear + "단이 되었습니다.");
    }

    // 출발한다.
    void start(){
        System.out.println(model + ": 출발합니다.");
        gearUp();
        speedUp();
    }

    // 멈춘다.
    void stop(){
        System.out.println("멈춥니다.");
        gear = 0;
        while(speed > 0){
            speedDown();
        }
    }
}
