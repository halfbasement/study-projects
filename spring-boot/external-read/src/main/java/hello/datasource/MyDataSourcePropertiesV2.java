package hello.datasource;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {
    private String url;
    private String username;
    private String password;
    private Etc etc;//properties 에 etc는 분리를 한번 더해야함

    @Getter
    public static class Etc{
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();

        public Etc(int maxConnection, Duration timeout,@DefaultValue({"asd","dd"}) List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }

    public MyDataSourcePropertiesV2(String url, String username, String password, Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }
}
