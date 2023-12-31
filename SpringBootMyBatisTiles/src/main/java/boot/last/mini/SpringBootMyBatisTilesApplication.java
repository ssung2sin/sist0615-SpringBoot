package boot.last.mini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("boot.data.*")
@MapperScan("boot.data.mapper")
@ComponentScan("boot.last.mini")
public class SpringBootMyBatisTilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisTilesApplication.class, args);
	}

}
