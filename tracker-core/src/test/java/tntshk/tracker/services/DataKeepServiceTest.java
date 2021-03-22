package tntshk.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.mockito.Mock;
import tntshk.domain.Point;

import static org.junit.Assert.*;

public class DataKeepServiceTest {
    DataKeepService dataKeepService = new DataKeepService();

    @Test
    public void getQueue() throws InterruptedException, JsonProcessingException {
        Point point = new Point(15, 14, 13, 12);

        dataKeepService.getQueue().put(point);
        assert(dataKeepService.getQueue().take().toJson().equals(point.toJson()));
    }
}