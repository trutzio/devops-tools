package trutzio.devopstools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EchoController {

    @SuppressWarnings("static-access")
    @GetMapping("/")
    public String echo() throws InterruptedException {
        Thread.currentThread().sleep(100);
        return "OK";
    }
    
}
