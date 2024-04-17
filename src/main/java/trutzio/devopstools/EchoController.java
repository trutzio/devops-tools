package trutzio.devopstools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.instrumentation.annotations.WithSpan;

@RestController
public class EchoController {

    @GetMapping("/")
    @WithSpan(value = "test span")
    public String echo() throws InterruptedException {
        return "OK";
    }

}
