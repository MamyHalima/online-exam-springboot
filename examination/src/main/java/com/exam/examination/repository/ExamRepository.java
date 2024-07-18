package com.exam.examination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examination.model.ExamModel;

public interface ExamRepository extends JpaRepository<ExamModel, Long> {

}
