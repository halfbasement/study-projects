package sik.ch7;


class Card{
    final int NUMBER;
    final String KIND;

    static int width = 100;
    static int height = 250;

    Card(String kind,int num){
        KIND = kind;
        NUMBER = num;
    }



    public String toString(){
        return KIND + " "+NUMBER;
    }

}

public class FinalCardTest {

    Card c = new Card("HEART",10);


}
