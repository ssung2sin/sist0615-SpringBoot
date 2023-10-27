package boot.mvc.tea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("data.model.cine")
@EntityScan("data.model.cine")
@EnableJpaRepositories("data.model.cine")
public class SpringBootQuizJpa5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuizJpa5Application.class, args);
	}

}
