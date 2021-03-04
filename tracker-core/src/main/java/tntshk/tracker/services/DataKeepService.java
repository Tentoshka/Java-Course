package tntshk.tracker.services;

import org.springframework.stereotype.Service;
import tntshk.tracker.DTO.PointDto;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author tentoshka
 */

@Service
public class DataKeepService {
    // очередь, где хранятся все точки движения
    private BlockingDeque<PointDto> queue =  new LinkedBlockingDeque<>(100);

    public BlockingDeque<PointDto> getQueue() {
        return queue;
    }
}
