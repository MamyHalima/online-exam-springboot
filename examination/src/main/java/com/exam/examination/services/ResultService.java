package com.exam.examination.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examination.model.ResultModel;
import com.exam.examination.repository.ResultRepository;

@Service
public class ResultService {

     @Autowired
    private  ResultRepository resultRepository;

    public List<ResultModel> getAllResults() {
        return resultRepository.findAll();
    }

    public ResultModel createResult(ResultModel result) {
        return resultRepository.save(result);
    }

    public Optional<ResultModel> getResultById(Long id) {
        return resultRepository.findById(id);
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }

}
