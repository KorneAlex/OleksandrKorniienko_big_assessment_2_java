package models;

public class Planet {
    private int id = 0;
    private String name;
    private double mass;
    private double diameter;
    private double averageTemperature;
    private String surfaceType;
    private boolean hasLiquidWater;

    public Planet(String name, double mass, double diameter, double averageTemperature, 
                 String surfaceType, boolean hasLiquidWater) {
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
        this.averageTemperature = averageTemperature;
        this.surfaceType = surfaceType;
        this.hasLiquidWater = hasLiquidWater;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public boolean hasLiquidWater() {
        return hasLiquidWater;
    }

    public double calculateGravity() {
        // Implementation needed: G * mass / (diameter/2)^2
        // where G is the gravitational constant
        throw new UnsupportedOperationException("Not implemented yet");
    }
}