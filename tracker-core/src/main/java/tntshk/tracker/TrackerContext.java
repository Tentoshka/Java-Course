package tntshk.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author tentoshka
 */

@Configuration
// включаем работу по расписанию
@EnableScheduling
// указываем файл с properties
@PropertySource("classpath:/application.properties")
public class TrackerContext {
    // настройка работы по расписанию
    @Bean
    public TaskScheduler trackerScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("trackerScheduler");
        scheduler.setPoolSize(30);
        return scheduler;
    }
}
