package com.github.geor.mkrtchyan.entity;

import com.github.geor.mkrtchyan.dto.QuadraticEquationCoefficientsDto;
import com.github.geor.mkrtchyan.dto.RootsQuadraticEquationDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuadraticEquation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double a;
    private double b;
    private double c;
    private Double x1;
    private Double x2;

    public QuadraticEquation() {
    }

    public QuadraticEquation(QuadraticEquationCoefficientsDto coefficients,
                             RootsQuadraticEquationDto rootsQuadraticEquation) {
        this.a = coefficients.getA();
        this.b = coefficients.getB();
        this.c = coefficients.getC();
        this.x1 = rootsQuadraticEquation.getX1();
        this.x2 = rootsQuadraticEquation.getX2();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }
}
