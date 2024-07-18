package com.exam.examination.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examination.model.ExamModel;
import com.exam.examination.repository.ExamRepository;

@Service
public class ExamService {

     @Autowired
    private ExamRepository examRepository;

    public List<ExamModel> getAllExams() {
        return examRepository.findAll();
    }

    public ExamModel createExam(ExamModel exam) {
        return examRepository.save(exam);
    }

    public Optional<ExamModel> getExamById(Long id) {
        return examRepository.findById(id);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }


}
