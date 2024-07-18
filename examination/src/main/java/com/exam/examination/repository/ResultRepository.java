package com.exam.examination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examination.model.ResultModel;

public interface ResultRepository extends JpaRepository<ResultModel, Long> {

}
