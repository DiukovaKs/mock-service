package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class IndexController {
    private final Environment env;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, String> index() {
        HashMap<String, String> body = new HashMap<>();

        body.put("profiles", String.join(", ", this.env.getActiveProfiles()));
        body.put("debug", this.env.getProperty("debug"));

        return body;
    }
}