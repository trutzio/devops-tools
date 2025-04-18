package trutzio.devopstools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class DevopsToolsConfiguration {

    @Bean
    RestClient restClient() {
        return RestClient.create();
    }

}
