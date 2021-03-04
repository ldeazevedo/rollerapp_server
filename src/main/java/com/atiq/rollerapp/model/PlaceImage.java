package com.atiq.rollerapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "place_image")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "place"})
public class PlaceImage {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlaceImage.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("url='" + url + "'")
                .add("place=" + place)
                .toString();
    }
}