package tntshk.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

public class PointTest {
    double longitude = 12.004;
    double latitude = 12.004;
    double azimuth = 12.004;
    double speed = 12.004;

    Point point = new Point(longitude, latitude, azimuth, speed);

    @Test
    public void toJson() throws JsonProcessingException {

        String testJson = "{" +
                "\"longitude\":" + longitude + "," +
                "\"latitude\":" + latitude + "," +
                "\"azimuth\":" + azimuth + "," +
                "\"speed\":" + speed +
                "}";

        assert(testJson.equals(point.toJson()));
    }

    @Test
    public void getLongitude() {
        assert(point.getLongitude() == longitude);
    }

    @Test
    public void setLongitude() {
        double newLongitude = 14.02;

        point.setLongitude(newLongitude);

        assert(point.getLongitude() == newLongitude);
    }

    @Test
    public void getLatitude() {
        assert(point.getLatitude() == latitude);
    }

    @Test
    public void setLatitude() {
        double newLatitude = 14.03;

        point.setLatitude(newLatitude);

        assert(point.getLatitude() == newLatitude);
    }

    @Test
    public void getAzimuth() {
        assert(point.getAzimuth() == azimuth);
    }

    @Test
    public void setAzimuth() {
        double newAzimuth = 14.04;

        point.setAzimuth(newAzimuth);

        assert(point.getAzimuth() == newAzimuth);
    }

    @Test
    public void getSpeed() {
        assert(point.getSpeed() == speed);
    }

    @Test
    public void setSpeed() {
        double newSpeed = 14.05;

        point.setSpeed(newSpeed);

        assert(point.getSpeed() == newSpeed);
    }
}