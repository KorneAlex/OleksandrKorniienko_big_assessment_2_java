package models;

public abstract class Planet {
    private int id = 1000; // >= 1000
    private static int nextId = 1000; // >= 1000
    private String name = ""; // max 30 chars
    private double mass = 0.1;
    private double diameter = 0.5;
    private double averageTemperature = 0; // Average surface temperature in °C must be a value between -400 and 400 default 0.
    // Note: i changed the min temp to -273.15 because the absolute min temp of the Universe is -273.15 Celsius.
    private String surfaceType = ""; // max 20 chars
    private boolean hasLiquidWater = false;

    public Planet(String name, double mass, double diameter, double averageTemperature, 
                 String surfaceType, boolean hasLiquidWater) {
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
        this.averageTemperature = averageTemperature;
        this.surfaceType = surfaceType;
        this.hasLiquidWater = hasLiquidWater;
        this.id = nextId;
        nextId++;
    }

    //=============================getters=========================================
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

    public int getId() { return id; } // FIX THIS

    public static int getNextId(){
        return nextId;
    }

    //=============================setters=========================================

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id; // FIX THIS / IS EXIST
    }

    public static void setNextId(int newNextId){
        nextId = newNextId;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public void setHasLiquidWater(boolean hasLiquidWater) {
        this.hasLiquidWater = hasLiquidWater;
    }

    //=============================other_methods===================================

    /**
     * Calculates the gravitational force for the planet.
     * @return (mass multipled by 6.67430e-11) divided by (half the diameter to the power of 2)
     */
    public double calculateGravity() {
        // Implementation needed: G * mass / (diameter/2)^2
        // where G is the gravitational constant
        return (this.mass * 6.67430e-11)/ Math.pow(this.diameter/2, 2);
    }

    public boolean isHasLiquidWater() {
        return hasLiquidWater;
    }

    /**
     *
     * @return the type of the planet
     */
    public abstract String classifyBody();

    /**
     * This method displays certain information from the class, and shows a different String to that of the toString()
     * @return certain information from the class
     */
    public abstract String displayInfo();

    public abstract String toTable();

    public String toString(){
        return id + name + mass + diameter + averageTemperature + surfaceType + hasLiquidWater;

    }
}