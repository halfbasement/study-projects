package hello;

import hello.boot.MySpringApplication;
import hello.boot.MySpringBootApplication;

@MySpringBootApplication
public class MySpringBootMain {

    //tomcat
    public static void main(String[] args) {
        System.out.println("MySpringBootMain.main");

        MySpringApplication.run(MySpringBootMain.class,args);
    }
}
