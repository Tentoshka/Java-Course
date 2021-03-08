package tntshk.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tntshk.domain.Point;
import tntshk.domain.Response;

/**
 * @author tentoshka
 */

@Service
public class DataSendService {
    final String URL = "http://localhost:8080/coord";
    // объявление логгера
    private static final Logger log = LoggerFactory.getLogger(DataKeepService.class);
    RestTemplateBuilder builder = new RestTemplateBuilder();

    // автовайринг сервиса хранения
    @Autowired
    DataKeepService dataKeepService;

    // берем данные из очереди каждый крон и выводим в лог json
    @Scheduled(cron = "${cron.prop}")
    void takeData() throws InterruptedException, JsonProcessingException {
        Point point = dataKeepService.getQueue().take();
        log.info(point.toJson());

        String result = builder.build().postForObject(URL, point, String.class);

        log.info(result);
    }
}
