package sik.ch7;

public class PolyArgumentTest {
}


class Product{
    int price;
    int bonusPoint;


    public Product(int price) {
        this.price = price;
        this.bonusPoint = (int)(price/10.0);
    }
}

class Tv extends Product{
    Tv(){
        super(100);
    }

    public String toString(){
        return "tv";
    }
}

class Computer extends Product{
    Computer(){
        super(200);
    }

    public String toString(){
        return "com" ;
    }
}


class Buyer{
    int money =1000;
    int bonusPoint = 0;

    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액이 부족");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p+"을/를 구입하셨습니다");
    }
}