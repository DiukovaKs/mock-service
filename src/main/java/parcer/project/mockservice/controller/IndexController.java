package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class IndexController {
    @Autowired
    private final Environment env;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, String>> index() {
        HashMap<String, String> body = new HashMap<>();

        body.put("profiles", String.join(", ", this.env.getActiveProfiles()));
        body.put("debug", this.env.getProperty("debug"));

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}