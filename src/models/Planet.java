public class Planet {
    private int id = 0;
    private String name;
    private double mass;
    private double diameter;
    private double averageTemperature;
    private String surfaceType;
    private boolean hasLiquidWater;

    public Planet(String name, double mass, double diameter, double averageTemperature, String surfaceType, boolean hasLiquidWater) {
      this.name = name;
      this.mass = mass;
      this.diameter = diameter;
      this.averageTemperature = averageTemperature;
      this.surfaceType = surfaceType;
      this.hasLiquidWater = hasLiquidWater;
    }

    public double getMass(){return mass;}
    public String getSurfaceType(){return surfaceType;}
    public void getSurfaceType(String surfaceType){}
    public double calculateGravity(){}

}
