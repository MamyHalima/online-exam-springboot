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

import com.exam.examination.model.ExamModel;
import com.exam.examination.services.ExamService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/exams")
public class ExamController {

     @Autowired
    private ExamService examService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public ResponseEntity<List<ExamModel>> getAllExams() {
        List<ExamModel> exams = examService.getAllExams();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/")
    public ResponseEntity<ExamModel> createExam(@RequestBody ExamModel exam) {
        ExamModel newExam = examService.createExam(exam);
        return new ResponseEntity<>(newExam, HttpStatus.CREATED);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<ExamModel> getExamById(@PathVariable Long id) {
        Optional<ExamModel> exam = examService.getExamById(id);
        return exam.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return new ResponseEntity<>("Exam deleted successfully", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
@PutMapping("/{id}")
public ResponseEntity<ExamModel> updateExam(@PathVariable Long id, @RequestBody ExamModel examDetails) {
    Optional<ExamModel> optionalExam = examService.getExamById(id);
    if (!optionalExam.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    ExamModel existingExam = optionalExam.get();
    existingExam.setQuestion1(examDetails.getQuestion1());
    existingExam.setQuestion2(examDetails.getQuestion2());
    existingExam.setQuestion3(examDetails.getQuestion3());

    ExamModel updatedExam = examService.createExam(existingExam); // Use your service method to update

    return ResponseEntity.ok(updatedExam);
}

}