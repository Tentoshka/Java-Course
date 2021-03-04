package tntshk.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tntshk.tracker.DTO.PointDto;
import tntshk.tracker.Main;

/**
 * @author tentoshka
 */

@Service
public class GpsService {
    double x, y, a, speed;

    // автовайринг сервиса хранения
    @Autowired
    private DataKeepService dataKeepService;

    // кладем данные в очередь каждый крон
    @Scheduled(cron = "${cron.prop}")
    private void putData() throws InterruptedException {
        // генерация изменения координат и скорости
        x = x + rand();
        y = y + rand();
        a = a + rand();
        speed = rand();

        PointDto point = new PointDto(x, y, a, speed);
        dataKeepService.getQueue().put(point);
    }

    // DRY - наше все :-)
    private double rand() {
        return Math.random() * (10 - (-10)) + (-10);
    }
}
