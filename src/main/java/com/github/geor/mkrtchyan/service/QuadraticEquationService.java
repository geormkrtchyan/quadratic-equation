package com.github.geor.mkrtchyan.service;

import com.github.geor.mkrtchyan.dto.QuadraticEquationCoefficientsDto;
import com.github.geor.mkrtchyan.dto.RootsQuadraticEquationDto;
import com.github.geor.mkrtchyan.entity.QuadraticEquation;
import com.github.geor.mkrtchyan.repository.QuadraticEquationRepository;
import org.springframework.stereotype.Service;

@Service
public class QuadraticEquationService {

    private final QuadraticEquationRepository repository;

    public QuadraticEquationService(QuadraticEquationRepository repository) {
        this.repository = repository;
    }

    public RootsQuadraticEquationDto calculationAndSave(QuadraticEquationCoefficientsDto equationCoefficients) {
        RootsQuadraticEquationDto rootsQuadraticEquation = calculation(equationCoefficients);
        QuadraticEquation quadraticEquation = new QuadraticEquation(equationCoefficients, rootsQuadraticEquation);
        repository.save(quadraticEquation);
        return rootsQuadraticEquation;
    }

    private RootsQuadraticEquationDto calculation(QuadraticEquationCoefficientsDto equationCoefficients) {
        RootsQuadraticEquationDto roots = new RootsQuadraticEquationDto();
        double d = Math.pow(equationCoefficients.getB(), 2) - 4 * equationCoefficients.getA() * equationCoefficients.getC();
        if (d > 0) {
            roots.setX1((-equationCoefficients.getB() - Math.sqrt(d)) / (2 * equationCoefficients.getA()));
            roots.setX2((-equationCoefficients.getB() + Math.sqrt(d)) / (2 * equationCoefficients.getA()));
        } else if (d == 0) {
            roots.setX1(-equationCoefficients.getB() / (2 * equationCoefficients.getA()));
        } else {
            throw new RuntimeException("Уравнение не имеет действительных корней!");
        }
        return roots;
    }
}
