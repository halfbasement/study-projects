package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV3SpringMvc implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("AppInitV3SpringMvc.onStartup");


        //스프링 컨테이너 생성
        AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
        appCtx.register(HelloConfig.class);

        // 스프링 mvc 디스패처 서블릿 생성 , 스프링 컨테이너 연결
        DispatcherServlet dispatcher = new DispatcherServlet(appCtx);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV3", dispatcher);
        servlet.addMapping("/");


    }
}
