package hello.container;

import hello.servlet.HelloServlet;
import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements  AppInit{
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartup");

        //스프링 컨테이너 생성
        AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
        appCtx.register(HelloConfig.class);

        // 스프링 mvc 디스패처 서블릿 생성 , 스프링 컨테이너 연결
        DispatcherServlet dispatcher = new DispatcherServlet(appCtx);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcher);
        servlet.addMapping("/spring/*");
    }
}
