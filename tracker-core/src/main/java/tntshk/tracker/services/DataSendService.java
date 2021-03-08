package tntshk.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tntshk.domain.Point;

/**
 * @author tentoshka
 */

@Service
public class DataSendService {
    // объявление логгера
    private static final Logger log = LoggerFactory.getLogger(DataKeepService.class);

    // автовайринг сервиса хранения
    @Autowired
    DataKeepService dataKeepService;

    // берем данные из очереди каждый крон и выводим в лог json
    @Scheduled(cron = "${cron.prop}")
    void takeData() throws InterruptedException, JsonProcessingException {
        Point point = dataKeepService.getQueue().take();
        log.info(point.toJson());
    }
}
