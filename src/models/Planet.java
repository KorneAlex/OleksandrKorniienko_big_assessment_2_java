package models;

public class Planet {
    private int id = 0;
    private int nextId = 0;
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

    public int getId() {
        return id;
    }

    public int getNextId(){
        return id++;
    }

    //=============================setters=========================================

    public void setSurfaceType(String surfaceType) {

    }

    public void setName(String name) {

    }

    public void setId(int id) {

    }

    public void setNextId(int nextId){
    }

    public void setMass(double mass) {

    }

    public void setDiameter(double diameter) {

    }

    public void setAverageTemperature(double averageTemperature) {

    }

    //=============================other_methods===================================

    public boolean hasLiquidWater() {
        return hasLiquidWater;
    }

    public double calculateGravity() {
        // Implementation needed: G * mass / (diameter/2)^2
        // where G is the gravitational constant
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isHasLiquidWater() {
        return false;
    }

    public String classifyBody(){
        return "";
    }

    public String displayInfo(){
        return "";
    }

    public String toSting(){
        return "";
    }
}