package tntshk.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tntshk.tracker.dao.Point;
import tntshk.tracker.dao.repo.PointRepository;

import java.util.List;

/**
 * @author tentoshka
 */

@SpringBootApplication
@EnableJpaRepositories("tntshk.tracker.dao")
@PropertySource("classpath:/application.properties")
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    PointRepository pointRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Point> pointList = (List<Point>) pointRepository.findAll();
        System.out.println("00000000000000000000000000");
        System.out.println(pointList.size());
        System.out.println("00000000000000000000000000");
    }
}
