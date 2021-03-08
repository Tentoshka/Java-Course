package tntshk.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tntshk.domain.Point;
import tntshk.domain.Response;

@RestController
public class CoordController {
    private static final Logger log = LoggerFactory.getLogger(CoordController.class);

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/coord")
    public String coord(@RequestBody Point point) throws JsonProcessingException {
        log.info(point.toJson());

        Response response = new Response("true");

        log.info(response.toJson());

        return response.toJson();
    }
}
