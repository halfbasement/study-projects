package sik.ch7;

public class CastingTest {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;

        fe2 = (FireEngine) car;

    }
}

class Car{
    String color;
    int door;

    void drive(){
        System.out.println("부릉");
    }

    void stop(){
        System.out.println("멈춤");
    }
}

class FireEngine extends Car{
    void water(){
        System.out.println("물뿌리기");
    }
}
