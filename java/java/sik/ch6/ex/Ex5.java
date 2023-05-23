package sik.ch6.ex;

public class Ex5 {

    public static void main(String[] args) {

        Student5 s = new Student5("홍길동", 1, 1, 100, 60, 76);

        System.out.println(s.info());
    }

}

class Student5{


    public Student5(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

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


    public String info(){
        return name+","+no+","+ban+","+kor+","+eng+","+math+","+this.getTotal()+","+this.getAverage();
    }

}
