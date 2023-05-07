package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {


    //HandleTypes에 AppInit인터페이스를 등록하면 AppInit을 구현한 구현체들을 c에 넣어준다
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("MyContainerInitV2 c = " + c);
        System.out.println("MyContainerInitV2 ctx = " + ctx);


        //클래스정보가 넘어ㅇ옴 (AppInitV1Servlet)
        for (Class<?> appInitClass : c) {
            try {
                AppInit e = (AppInit) appInitClass.getDeclaredConstructor().newInstance();
                e.onStartup(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
