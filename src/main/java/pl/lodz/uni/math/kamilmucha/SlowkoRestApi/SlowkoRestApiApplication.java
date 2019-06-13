package pl.lodz.uni.math.kamilmucha.SlowkoRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class SlowkoRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlowkoRestApiApplication.class, args);
	}

}
