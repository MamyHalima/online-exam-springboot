package com.exam.examination.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examination.model.ResultModel;
import com.exam.examination.services.ResultService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/results")
public class ResultController {

     @Autowired
    private ResultService resultService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public ResponseEntity<List<ResultModel>> getAllResults() {
        List<ResultModel> results = resultService.getAllResults();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/")
    public ResponseEntity<ResultModel> createResult(@RequestBody ResultModel result) {
        ResultModel newResult = resultService.createResult(result);
        return new ResponseEntity<>(newResult, HttpStatus.CREATED);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<ResultModel> getResultById(@PathVariable Long id) {
        Optional<ResultModel> result = resultService.getResultById(id);
        return result.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return new ResponseEntity<>("Result deleted successfully", HttpStatus.OK);
    }

     // Mbinu ya PUT kwa kuhariri matokeo yaliyopo kwa kutumia ID
    @PutMapping("/{id}")
    public ResponseEntity<ResultModel> updateResult(@PathVariable Long id, @RequestBody ResultModel resultUpdate) {
        Optional<ResultModel> existingResultOptional = resultService.getResultById(id);
        
        if (existingResultOptional.isPresent()) {
            ResultModel existingResult = existingResultOptional.get();
            existingResult.setResult(resultUpdate.getResult()); // Update the result field or other fields as needed

            ResultModel updatedResult = resultService.createResult(existingResult); // Save updated result
            return new ResponseEntity<>(updatedResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

