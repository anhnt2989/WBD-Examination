package com.codegym.exam.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Không để trống!")
    @Size(min = 4, max = 16,message = "Tối thiểu 4 ký tự, tối đa 16 ký tự")
    private String name;

    @NotNull(message = "Không để trống!")
    @Min(value = 1000, message = "Diện tích không phù hợp!")
    private float area;

    @NotNull(message = "Không để trống!")
    @Min(value = 1000, message = "Dân số không phù hợp!")
    private int population;

    @NotNull(message = "Không để trống!")
    @Min(value = 1000, message = "GDP không phù hợp!")
    private int gdp;


    private String description;

    public City() {
    }

    public City(String name, float area, int population, int gdp, String description, Nation nation) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.nation = nation;
    }

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

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

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
