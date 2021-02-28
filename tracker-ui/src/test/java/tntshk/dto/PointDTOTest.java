package tntshk.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointDTOTest {
    @Test
    public void toJson() throws JsonProcessingException {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(56);
        pointDTO.setLon(74);
        pointDTO.setAutoId("o567gfd");
        assertTrue(pointDTO.toJson().contains("\"lat\":57"));
    }

    @Test
    public void toObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PointDTO pointDTO = new PointDTO();

        pointDTO.setLat(56);
        pointDTO.setLon(74);
        pointDTO.setAutoId("o567gfd");

        String jsonString = pointDTO.toJson();

        PointDTO pointDTO1 = mapper.readValue(jsonString, PointDTO.class);

        assertEquals(pointDTO1.toJson(), jsonString);
    }
}
