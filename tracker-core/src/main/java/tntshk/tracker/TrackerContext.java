package tntshk.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import tntshk.tracker.services.DataKeepService;
import tntshk.tracker.services.DataSendService;
import tntshk.tracker.services.GpsService;

/**
 * @author tentoshka
 */

@Configuration
// включаем работу по расписанию
@EnableScheduling
// указываем файл с properties
@PropertySource("classpath:/app.properties")
public class TrackerContext {
    @Bean
    public DataKeepService dataKeepService() {
        return new DataKeepService();
    }

    @Bean
    public DataSendService dataSendService() {
        return new DataSendService();
    }

    @Bean
    public GpsService gpsService() {
        return new GpsService();
    }

    // настройка работы по расписанию
    @Bean
    public TaskScheduler trackerScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("trackerScheduler");
        scheduler.setPoolSize(30);
        return scheduler;
    }
}
