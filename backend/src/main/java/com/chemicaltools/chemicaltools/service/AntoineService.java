package com.chemicaltools.chemicaltools.service;

import com.chemicaltools.chemicaltools.exception.SubstanceNotFoundException;
import com.chemicaltools.chemicaltools.exception.TemperatureOutRangeException;
import com.chemicaltools.chemicaltools.model.AntoineProperties;
import com.chemicaltools.chemicaltools.model.Substance;
import com.chemicaltools.chemicaltools.repository.SubstanceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AntoineService {
    //TODO: Antoine Formula
    private final SubstanceRepository substanceRepository;

    /**
     * Older versions of Spring, like Spring 3 required
     * the tag @Autowired.
     */
    public AntoineService(SubstanceRepository substanceRepository) {
        this.substanceRepository = substanceRepository;
    }

    /**
     * Calculates vapor pressure of a given substance at a specific temperature using Antoine's equation.
     * Equation: Ln(P) = A - (B / (C+T))
     * Therefore: P = 10^(A-(B/ C + T)
     *
     * @param substance   Substance to be found by formula or name.
     * @param temperature The temperature must be given in Kelvin
     * @return pressure The pressure will be calculated in millimeters of mercury (mmHg).
     *
     */
    public Double calculateAntoineVaporPressure(String substance, Double temperature) {
        String normalizedSubstance = substance.toLowerCase().trim();
        Optional<Substance> searchResult = substanceRepository.findByName(normalizedSubstance);
        if (searchResult.isEmpty()) {
            searchResult = substanceRepository.findByFormula(normalizedSubstance);
        }
        if (searchResult.isEmpty()) {
            throw new SubstanceNotFoundException("Substance not found.");
        }
        Substance substanceFound = searchResult.get();
        AntoineProperties properties = substanceFound.getAntoineProperties();

        if (temperature < properties.getMinTemperature() || temperature > properties.getMaxTemperature()) {
            throw new TemperatureOutRangeException("Temperature out of range:[" + properties.getMinTemperature() + "," + properties.getMaxTemperature() + "]");
        }

        //Antoine Equation
        double exponent = properties.getaCoefficient() - (properties.getbCoefficient() / (properties.getcCoefficient() + temperature));


        return Math.pow(10, exponent);

    }
}



