package ch13.supercar;

public class DriveTest {
    public static void main(String[] args){
        GasolineCar gcar = new GasolineCar(8);
        HybridCar hcar = new HybridCar(7);
        ElectricCar ecar = new ElectricCar(4);
        PlugInHybridCar pcar = new PlugInHybridCar(5);

        Driver driver = new Driver();
        // 1
        driver.drive(gcar);
        driver.drive(hcar);
        driver.drive(ecar);
        driver.drive(pcar);

        // 6
        System.out.println("프로그램 종료");
    }
}
