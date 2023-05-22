package sik.ch6.ex;

public class Ex3_4 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        System.out.println("이름 : "+s.name);
        System.out.println("총점 : "+s.getTotal());
        System.out.println("평균 : "+s.getAverage());

    }
}

class Student{
     String name;
     int ban;
     int no;
     int kor;
     int eng;
     int math;

    public int getTotal(){

        int sum = this.kor + this.eng + this.math;

        return sum;
    }

    public float getAverage(){
        int sum = this.kor + this.eng + this.math;

        float avg = sum/3;


        return avg;
    }



}
