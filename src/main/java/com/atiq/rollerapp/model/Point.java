package com.atiq.rollerapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "point")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "street"})
public class Point {

    @Id
    @Column
    private int id;

    @Column
    private double lat;

    @Column
    private double lng;

    @ManyToOne
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    public Point() {
    }

    public Point(int id, double lat, double lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("lat=" + lat)
                .add("lng=" + lng)
                .toString();
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
