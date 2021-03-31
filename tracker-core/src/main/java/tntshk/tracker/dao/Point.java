package tntshk.tracker.dao;

import javax.persistence.*;

@Entity
@Table(name = "POINTS")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "AZIMUTH")
    private double azimuth;

    @Column(name = "SPEED")
    private double speed;

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", azimuth=" + azimuth +
                ", speed=" + speed +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
