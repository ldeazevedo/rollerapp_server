package com.atiq.rollerapp.model;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "place")
public class Place {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double lat;

    @Column
    private Double lng;

    @OneToMany(mappedBy = "place")
    private List<PlaceImage> images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public List<PlaceImage> getImages() {
        return images;
    }

    public void setImages(List<PlaceImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Place.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("lat=" + lat)
                .add("lng=" + lng)
                .add("images=" + images)
                .toString();
    }
}