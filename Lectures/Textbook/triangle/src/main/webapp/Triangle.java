package com.example.triangle;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;
    
    public Triangle() {}
    
    public double getSideA() {
        return sideA;
    }
    
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
    
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
    
    public boolean isValid() {
        return (sideA + sideB > sideC) && 
               (sideA + sideC > sideB) && 
               (sideB + sideC > sideA);
    }
}