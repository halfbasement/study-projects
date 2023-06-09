package sik.ch7;

public class DrawShape {
}


class Shape{

    String color = "black";

    void draw(){
        System.out.printf("[color=%s]%n",color);
    }

}

//WHEN
class Point{
    int x;
    int y;

    Point (int x , int y){
        this.x = x;
        this.y = y;
    }

    Point(){
        this(0,0);
    }

    String getXY(){
        return "("+x+","+y+")";
    }
}

class Circle extends Shape{

    Point center;
    int r;

    Circle(){
        this(new Point(0,0),100);
    }

    Circle(Point center , int r){
        this.center = center;
        this.r = r;
    }

    void draw(){
        System.out.printf("[center=(%d,%d), r=%d, color=%s]%n",center.x , center.y , r, color);
    }


}

class Triangle extends Shape{
    Point[] p = new Point[3];

    Triangle(Point[] p ){
        this.p = p;
    }

    void draw(){
        System.out.println("[p1                                                                                                                                                                                      ");
    }
}