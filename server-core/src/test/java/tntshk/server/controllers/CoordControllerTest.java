package tntshk.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tntshk.domain.Point;
import tntshk.domain.Response;

public class CoordControllerTest {
    @Mock
    Point point = new Point(15, 14, 13, 12);

    @Mock
    Response response = new Response("true");

    @InjectMocks
    CoordController mockedController = new CoordController();

    @Test
    public void index() {
        String result = mockedController.index();
        assert result.equals("index");
    }

    @Test
    public void coord() throws JsonProcessingException {
        String result = mockedController.coord(point);
        assert result.equals(response.toJson());
    }
}