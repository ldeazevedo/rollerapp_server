package com.atiq.rollerapp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "street")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int eval;

    @OneToMany(mappedBy = "street")
    private List<Point> points;

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

    public int getEval() {
        return eval;
    }

    public void setEval(int eval) {
        this.eval = eval;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> pointList) {
        this.points = pointList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Street.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("eval=" + eval)
                .add("pointList=" + points)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return eval == street.eval &&
                Objects.equals(id, street.id) &&
                Objects.equals(name, street.name) &&
                Objects.equals(points, street.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eval, points);
    }
}