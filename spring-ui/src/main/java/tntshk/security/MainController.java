package tntshk.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tntshk.security.models.Point;

import java.util.Arrays;

@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    RestTemplateBuilder builder = new RestTemplateBuilder();

    final String URL = "http://localhost:8080/points/";

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/payments")
    public String payments() {
        return "payments";
    }

    @GetMapping("/routes")
    public String routes() {
        return "routes";
    }

    @GetMapping("/registerClient")
    public String registerClient() {
        return "registerClient";
    }

    @GetMapping("/registerManager")
    public String registerManager() {
        return "registerManager";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/points")
    public String points(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String json = builder.build().getForObject(URL + "all", String.class);

        Point[] allPoints = mapper.readValue(json, Point[].class);

        log.info(Arrays.toString(allPoints));

        model.addAttribute("points", allPoints);

        return "points";
    }

    @PostMapping("/points/{id}/delete")
    public String pointDelete(@PathVariable(value = "id") int id) {
        log.info("Deleting Point №" + id);

        builder.build().postForObject(URL + "delete", id, String.class);

        return "redirect:/points";
    }
}
