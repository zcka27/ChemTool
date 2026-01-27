package com.chemicaltools.chemicaltools.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table (name = "antoine_properties")
public class AntoineProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "substance_name", referencedColumnName = "name")
    private Substance substance;

    @Column(name = "a_coefficient")
    private Double aCoefficient;

    @Column(name = "b_coefficient")
    private Double bCoefficient;

    @Column(name = "c_coefficient")
    private Double cCoefficient;

    @Column(name = "min_temperature")
    private Double minTemperature;

    @Column(name = "max_temperature")
    private Double maxTemperature;

    @Column(name = "boiling_enthalpy")
    private Double boilingEnthalpy;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Substance getSubstance() {
        return substance;
    }

    public void setSubstance(Substance substance) {
        this.substance = substance;
    }

    public Double getaCoefficient() {
        return aCoefficient;
    }

    public void setaCoefficient(Double aCoefficient) {
        this.aCoefficient = aCoefficient;
    }

    public Double getbCoefficient() {
        return bCoefficient;
    }

    public void setbCoefficient(Double bCoefficient) {
        this.bCoefficient = bCoefficient;
    }

    public Double getcCoefficient() {
        return cCoefficient;
    }

    public void setcCoefficient(Double cCoefficient) {
        this.cCoefficient = cCoefficient;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getBoilingEnthalpy() {
        return boilingEnthalpy;
    }

    public void setBoilingEnthalpy(Double boilingEnthalpy) {
        this.boilingEnthalpy = boilingEnthalpy;
    }
}
