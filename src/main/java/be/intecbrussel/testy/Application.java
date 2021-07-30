package be.intecbrussel.testy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi //Enable open api 3.0.3 spec
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
