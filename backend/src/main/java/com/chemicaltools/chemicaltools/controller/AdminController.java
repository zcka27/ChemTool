package com.chemicaltools.chemicaltools.controller;

import com.chemicaltools.chemicaltools.service.importers.AntoinePropertiesImporter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AntoinePropertiesImporter antoineImporter;

    @GetMapping("/upload")
    public  String upload() {
        return "forward:/adminUpload.html";
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<?> csvHandlerUpload(@RequestParam("file")MultipartFile file,
                                             @RequestParam("type") String type){
        // TODO: More cases will be added.
        switch(type){
            case "antoineProperties":
               antoineImporter.importCsv(file);
                break;
            case "null":
                return ResponseEntity.badRequest().body(Map.of("error","Not implemented."));
        }

        return ResponseEntity.ok().body(Map.of("status","Csv Uploaded"));
    }
}
