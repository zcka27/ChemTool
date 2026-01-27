package com.chemicaltools.chemicaltools.controller;

import com.chemicaltools.chemicaltools.service.AntoineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/antoine")
public class AntoineController {
    private final AntoineService antoineService;

    public AntoineController(AntoineService antoineService) {
        this.antoineService = antoineService;
    }

    /**
     * We use @GetMapping because this is a READ operation (SELECT/Calculation).
     * We return ResponseEntity.ok() to explicitly send a HTTP 200 Status Code.
     * (HTTP 201 Created would be reserved for @PostMapping when saving to DB).
     */
    @GetMapping("/calculate")
    public ResponseEntity<Map<String, Object>> getSaturationPressure(@RequestParam String substance, @RequestParam Double temperature) {
        Map<String, Object> response = new HashMap<>();
        Double vaporPressure = antoineService.calculateAntoineVaporPressure(substance, temperature);
        response.put("substance", substance);
        response.put("temperature_K", temperature);
        response.put("vaporPressure_mmHg", vaporPressure);
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
}
