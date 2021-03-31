package tntshk.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tntshk.domain.Response;
import tntshk.server.dao.Point;
import tntshk.server.dao.repo.PointRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("points")
public class PointController {
    private static final Logger log = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/")
    public String getLastPoints(@RequestParam(name = "id") int id, @RequestParam(name = "count") int count) throws IOException {
        log.info("Sending points");

        List<Point> allPoints = (List<Point>) pointRepository.findAll();
        List<Point> lastPoints = new ArrayList();

        if (allPoints.size() <= count) {
            lastPoints = allPoints;
        } else {
            for (int i = allPoints.size() - 1; i >= allPoints.size() - count; i--) {
                log.info(String.valueOf(allPoints.get(i)));
                lastPoints.add(allPoints.get(i));
            }
            Collections.reverse(lastPoints);
        }

        return listToJson(lastPoints);
    }

    @GetMapping("/all")
    public String getAllPoints() throws IOException {
        return listToJson((List<Point>) pointRepository.findAll());
    }

    private String listToJson(List<?> list) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(out, list);

        return out.toString();
    }

    @PostMapping("/delete")
    public String deletePoint(@RequestBody int id) {
        log.info("Deleting By Id " + id);
        pointRepository.deleteById(id);

        Response response = new Response("true");
        return response.toJson();
    }
}
