package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {

        ApplicationArguments appArgs = new DefaultApplicationArguments(args);

        log.info("SourceArgs={}", List.of(appArgs.getSourceArgs()));
        log.info("notOptionArgs ={}",appArgs.getNonOptionArgs());
    }
}
