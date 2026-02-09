package com.chemicaltools.chemicaltools.model.dto;

import com.chemicaltools.chemicaltools.model.entity.AntoineProperties;

public class AntoinePropertiesDTO {

    private String substanceName;
    private String substanceFormula;

    private Double aCoefficient;
    private Double bCoefficient;
    private Double cCoefficient;
    private Double minTemperature;
    private Double maxTemperature;

    public AntoinePropertiesDTO() {}

    public AntoinePropertiesDTO(AntoineProperties entity) {
        this.substanceName = entity.getSubstance().getName();
        this.substanceFormula = entity.getSubstance().getFormula();
        this.aCoefficient = entity.getaCoefficient();
        this.bCoefficient = entity.getbCoefficient();
        this.cCoefficient = entity.getcCoefficient();
        this.minTemperature = entity.getMinTemperature();
        this.maxTemperature = entity.getMaxTemperature();
    }

    public String getSubstanceName() {
        return substanceName;
    }

    public void setSubstanceName(String substanceName) {
        this.substanceName = substanceName;
    }

    public String getSubstanceFormula() {
        return substanceFormula;
    }

    public void setSubstanceFormula(String substanceFormula) {
        this.substanceFormula = substanceFormula;
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
}
