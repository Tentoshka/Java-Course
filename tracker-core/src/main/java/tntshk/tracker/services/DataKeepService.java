package tntshk.tracker.services;

import org.springframework.stereotype.Service;
import tntshk.domain.Point;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author tentoshka
 */

@Service
public class DataKeepService {
    // очередь, где хранятся все точки движения
    private final BlockingDeque<Point> queue =  new LinkedBlockingDeque<>(100);

    public BlockingDeque<Point> getQueue() {
        return queue;
    }
}
