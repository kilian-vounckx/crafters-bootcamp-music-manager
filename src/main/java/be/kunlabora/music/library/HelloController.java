package be.kunlabora.music.library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World again!";
    }

    @GetMapping("/test")
    public String test() {
        return "Test the auto deploy";
    }
}
