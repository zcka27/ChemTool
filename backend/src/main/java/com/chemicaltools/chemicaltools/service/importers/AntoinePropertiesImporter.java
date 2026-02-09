package com.chemicaltools.chemicaltools.service.importers;

import com.chemicaltools.chemicaltools.exception.CSVValidationException;
import com.chemicaltools.chemicaltools.model.entity.AntoineProperties;
import com.chemicaltools.chemicaltools.model.entity.Substance;
import com.chemicaltools.chemicaltools.repository.SubstanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AntoinePropertiesImporter extends CSVImporter<Substance> {
    private final SubstanceRepository substanceRepository;

    private static final int FORMULA = 1;
    private static final int NAME=2;
    private static final int CONST_A=4;
    private static final int CONST_B=5;
    private static final int CONST_C=6;
    private static final int T_MIN=7;
    private static final int T_MAX=8;

    @Override
    protected Substance mapRowToEntity(String[]row, int lineNumber){
    // Last lines from the csv are chunk. Regular rows[0] are a full number.
        if(row[0].contains(" ")){
            return null;
        }
        if(row[FORMULA].isEmpty() || row[NAME].isEmpty() || row[CONST_A].isEmpty() || row[CONST_B].isEmpty() ||
        row[CONST_C].isEmpty() || row[T_MIN].isEmpty() || row[T_MAX].isEmpty()){
        throw new CSVValidationException("Missing some data from the CSV.");
        }
        Substance s = new Substance();
        s.setName(row[NAME].toUpperCase().trim());
        s.setFormula(row[FORMULA].toUpperCase().trim());

        AntoineProperties ap = new AntoineProperties();
        ap.setaCoefficient(Double.parseDouble(row[CONST_A]));
        ap.setbCoefficient(Double.parseDouble(row[CONST_B]));
        ap.setcCoefficient(Double.parseDouble(row[CONST_C]));
        ap.setMinTemperature(Double.parseDouble(row[T_MIN]));
        ap.setMaxTemperature(Double.parseDouble(row[T_MAX]));
        //Define Antoine properties for substance, and set substance to Antoine properties with the ForeignKey
        s.setAntoineProperties(ap);
        ap.setSubstance(s);

        return s;
    }
    @Override
    protected void saveEntities(List<Substance> entities) {
        if(!entities.isEmpty()){
            substanceRepository.saveAll(entities);
        }
    }

}
