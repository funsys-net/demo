package net.funsys.demo.model;

import javax.persistence.*;

@Entity
@Table(name="favorite")
public class FavoriteEntity {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FavoriteEntity [id=" + id + "]";
    }
}