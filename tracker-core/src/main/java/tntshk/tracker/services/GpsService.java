package tntshk.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tntshk.domain.Point;

/**
 * @author tentoshka
 */

@Service
public class GpsService {
    float x, y, a, speed;

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

        Point point = new Point(x, y, a, speed);
        dataKeepService.getQueue().put(point);
    }

    // DRY - наше все :-)
    private float rand() {
        return (float) (Math.random() * (10 - (-10)) + (-10));
    }
}
