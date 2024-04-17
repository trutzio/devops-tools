package trutzio.devopstools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;

@SpringBootApplication
public class DevopsToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevopsToolsApplication.class, args);
	}

	@Bean
	public OpenTelemetry openTelemetry() {
		return GlobalOpenTelemetry.get();
	}

}
