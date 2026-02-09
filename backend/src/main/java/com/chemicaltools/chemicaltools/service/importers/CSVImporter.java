package com.chemicaltools.chemicaltools.service.importers;

import com.chemicaltools.chemicaltools.exception.CSVUploadException;
import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public abstract class CSVImporter<T> {

    public void importCsv(MultipartFile file) {
        int lineNumber = 0;

        try (Reader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReader(reader)) {

            List<T> results = new ArrayList<>();

            for (String[] row : csvReader) {
                lineNumber++;

                if (lineNumber == 1) {
                    continue;
                }

                T entity = mapRowToEntity(row, lineNumber);
                if (entity != null) {
                    results.add(entity);
                }
            }

            saveEntities(results);

        } catch (Exception e) {
            throw new CSVUploadException("Error uploading CSV line " + lineNumber + ": " + e.getMessage());
        }
    }

    protected abstract T mapRowToEntity(String[] row, int lineNumber);

    protected abstract void saveEntities(List<T> entities);

}