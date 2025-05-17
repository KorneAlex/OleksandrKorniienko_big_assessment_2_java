package models;

public class GasPlanet extends Planet{
    private String gasComposition = ""; // max 20 chars
    private String coreComposition = "UNKNOWN"; //Must be one of:
    // Rocky and Metallic, Proportionally Small, Liquid Metallic Hydrogen Compressed Hydrogen or Ice Giant
    // default UNKNOWN can use CoreCompositionUtility class
    private double radiationLevel = 0.9; // Higher in gas giant min .01 max 200.05 default .9
    public GasPlanet(String name, double mass, double diameter, double averageTemperature, String surfaceType, boolean hasLiquidWater, String gasComposition, String coreComposition, double radiationLevel) {
        super(name, mass, diameter, averageTemperature, surfaceType, hasLiquidWater);


    }
    //=============================getters=========================================

    public String getGasComposition() {
        return gasComposition;
    }

    public String getCoreComposition() {
        return coreComposition;
    }

    public double getRadiationLevel() {
        return radiationLevel;
    }

    //=============================setters=========================================

    public void setGasComposition(String gasComposition) {
        this.gasComposition = gasComposition;
    }

    public void setCoreComposition(String coreComposition) {
        this.coreComposition = coreComposition;
    }

    public void setRadiationLevel(double radiationLevel) {
        if(radiationLevel >= 0 && radiationLevel <= 100){
            this.radiationLevel = radiationLevel;
        }else{
            System.out.println("Radiation level must be between 0 and 100");
        }
    }

    //=============================other_methods===================================

    /**
     *
     * @return the String with the the text "Gas Planet" in it
     */
    @Override
    public String classifyBody(){
        return "Gas Planet";
    }

    /**
     * @return the String with the field information
     * e.g. Gas Composition: mostly Gas, Core Composition: Rocky and Metallic radiationLevel: 200
     *
     */
    @Override
    public String displayInfo(){
        return "Gas Composition: " + gasComposition + ", Core Composition: " + coreComposition + " Radiation level: " + radiationLevel + "%";
    }

    /**
     * This method should build a one line string containing the following information and return it (note: no \n should be included in the String):
     * details from the Planet toString() as well as fields above
     * @return
     */
    @Override
    public String toString() {
        return classifyBody() + ": " + displayInfo() + " " + super.toString();
    }
    @Override
    public String toTable(){
        return String.format("%2s %4s %3s %-31s %3s %6s %3s %10s %3s %21s %3s %12s %3s %12s %3s %30s %2s \n", "█ ", getId(), " █ ", getName(), " █ ", getMass(), " █ ", getDiameter(), " █ ", getSurfaceType(), " █ ", getAverageTemperature(), " █ ", isHasLiquidWater(), " █ ", getGasComposition(), " █ ");
    }
}
