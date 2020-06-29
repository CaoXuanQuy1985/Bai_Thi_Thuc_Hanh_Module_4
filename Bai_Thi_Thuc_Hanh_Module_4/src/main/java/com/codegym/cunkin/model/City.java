package com.codegym.cunkin.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Float area;

    @Column(nullable=false)
    private Float population;

    @Column(nullable=false)
    private Float  gdp;

    @Column(nullable=false)
    private String name_country;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @Column(nullable=false, columnDefinition="TEXT")
    private String introduce;

    public City() {}

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

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getPopulation() {
        return population;
    }

    public void setPopulation(Float population) {
        this.population = population;
    }

    public Float getGdp() {
        return gdp;
    }

    public void setGdp(Float gdp) {
        this.gdp = gdp;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
