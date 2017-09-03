package com.residentevil.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "capitals")
public class Capital {

    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;

    private Set<Virus> viruses;

    public Capital() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "latitude")
    public Float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude")
    public Float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @ManyToMany(mappedBy = "capitals")
    public Set<Virus> getViruses() {
        return this.viruses;
    }

    public void setViruses(Set<Virus> viruses) {
        this.viruses = viruses;
    }
}