package hello.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV1 {
    private String url;
    private String username;
    private String password;
    private Etc etc;//properties 에 etc는 분리를 한번 더해야함

    @Data
    public static class Etc{
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();

    }
}
