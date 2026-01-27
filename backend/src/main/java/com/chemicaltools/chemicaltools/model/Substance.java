 package com.chemicaltools.chemicaltools.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "substance")
public class Substance {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "formula", nullable = false, unique = true)
    private String formula;

    /**
     * OneToOne relationship with AntoineProperties
     * Each substance can have a bunch of termo properties
     *
     * @OneToOne: Define a one by one relation between identities
     * - mappedBy: "substance" identifies that foreign key will be
     *  found at AntoineProperties
     */
    @OneToOne(mappedBy = "substance", cascade = CascadeType.ALL)
    private AntoineProperties antoineProperties;

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFormula() {
        return formula;
    }
    public void setFormula(String formula) {
        this.formula = formula;
    }
    public AntoineProperties getAntoineProperties() {
        return antoineProperties;
    }
    public void setAntoineProperties(AntoineProperties antoineProperties) {
        this.antoineProperties = antoineProperties;
    }

}
