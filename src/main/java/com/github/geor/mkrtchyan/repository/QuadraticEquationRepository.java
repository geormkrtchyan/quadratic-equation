package com.github.geor.mkrtchyan.repository;

import com.github.geor.mkrtchyan.entity.QuadraticEquation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadraticEquationRepository extends CrudRepository<QuadraticEquation, Long> {
}
