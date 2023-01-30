package com.github.geor.mkrtchyan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.geor.mkrtchyan.dto.QuadraticEquationCoefficientsDto;
import com.github.geor.mkrtchyan.dto.RootsQuadraticEquationDto;
import com.github.geor.mkrtchyan.service.QuadraticEquationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/quadratic-equation")
public class QuadraticEquationController {

    private final QuadraticEquationService service;

    public QuadraticEquationController(QuadraticEquationService service) {
        this.service = service;
    }

    @GetMapping("/calc")
    public RootsQuadraticEquationDto calculation(@RequestParam String equationCoefficients) throws IOException {
        QuadraticEquationCoefficientsDto coefficients =
                new ObjectMapper().readValue(equationCoefficients, QuadraticEquationCoefficientsDto.class);
        return service.calculationAndSave(coefficients);
    }
}
