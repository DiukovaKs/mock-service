package parcer.project.mockservice.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class MockService {

    public String getSeekData() {
        String filePath = "src/main/resources/json/seekJavaDeveloperData.json";

        return getMockData(filePath).toString();
    }

    public String getIndeedData() {
        String filePath = "src/main/resources/json/indeedJavaDeveloperData.json";

        return getMockData(filePath).toString();
    }

    private JsonElement getMockData(String filePath) {
        try {
            var fis = new FileInputStream(filePath);

            return JsonParser.parseReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
