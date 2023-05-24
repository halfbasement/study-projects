package sik.ch6.ex;

public class Ex9 {

    public static void main(String[] args) {


        Marine marine = new Marine();

        marine.weaponUp();
//
        System.out.println("marine = " + marine);

        Marine marine2 = new Marine();

        System.out.println("marine2 = " + marine2);

    }
}

class Marine{

    int x=0,y=0;

    int hp = 60;
     static int weapon =6;
    private static int armor = 0;


    void weaponUp(){
        weapon++;
    }

    void armorUp(){
        armor++;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Marine{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", hp=").append(hp);
        sb.append(", weapon=").append(weapon);
        sb.append(", armor=").append(armor);
        sb.append('}');
        return sb.toString();
    }
}
