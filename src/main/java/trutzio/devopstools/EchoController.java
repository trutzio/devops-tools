package trutzio.devopstools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentelemetry.instrumentation.annotations.WithSpan;


@RestController
public class EchoController {

    @SuppressWarnings("static-access")
    @GetMapping("/")
    @WithSpan(value = "test span")
    public String echo() throws InterruptedException {
        Thread.currentThread().sleep(100);
        return "OK";
    }
    
}
