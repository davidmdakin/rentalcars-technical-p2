package RestExercise;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class RestExercise {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestExercise.class, args);
    }
}