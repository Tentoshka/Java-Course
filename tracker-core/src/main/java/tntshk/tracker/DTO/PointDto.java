package tntshk.tracker.DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author tentoshka
 */

// ДТО класс точки движения
public class PointDto {
    private double longitude;
    private double latitude;
    private double azimuth;
    private double speed;

    public PointDto() {}

    public PointDto(double longitude, double latitude, double azimuth, double speed) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.azimuth = azimuth;
        this.speed = speed;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "PointDto{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", azimuth=" + azimuth +
                ", speed=" + speed +
                '}';
    }
}
