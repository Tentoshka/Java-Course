package tntshk.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tntshk.domain.Response;
import tntshk.server.dao.repo.PointRepository;


@RestController
public class CoordController {
    private static final Logger log = LoggerFactory.getLogger(CoordController.class);

    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/coord")
    public String coord(@RequestBody tntshk.domain.Point point) throws JsonProcessingException {
        log.info(point.toJson());

        tntshk.server.dao.Point pointForDb = new tntshk.server.dao.Point();

        pointForDb.setLongitude(point.getLongitude());
        pointForDb.setLatitude(point.getLatitude());
        pointForDb.setAzimuth(point.getAzimuth());
        pointForDb.setSpeed(point.getSpeed());

        pointRepository.save(pointForDb);

        Response response = new Response("true");

        log.info(response.toJson());

        return response.toJson();
    }
}
