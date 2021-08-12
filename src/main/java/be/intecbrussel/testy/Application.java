package be.intecbrussel.testy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Testy Backend", version = "1.1", description = "Intec Brussel Online Examination Portal"))
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
