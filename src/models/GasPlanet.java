package models;

import main.Driver;
import utils.CoreCompositionUtility;
import utils.Utilities;

public class GasPlanet extends Planet{
    private String gasComposition = ""; // max 20 chars
    private String coreComposition = "UNKNOWN"; //Must be one of:
    // Rocky and Metallic, Proportionally Small, Liquid Metallic Hydrogen Compressed Hydrogen or Ice Giant
    // default UNKNOWN can use CoreCompositionUtility class
    private double radiationLevel = 0.9; // Higher in gas giant min .01 max 200.05 default .9
    public GasPlanet(String name, double mass, double diameter, double averageTemperature, String surfaceType, boolean hasLiquidWater, String gasComposition, String coreComposition, double radiationLevel) {
        super(name, mass, diameter, averageTemperature, surfaceType, hasLiquidWater);
        this.gasComposition = gasComposition;
        this.coreComposition = coreComposition;
        this.radiationLevel = radiationLevel;
    }
    //=============================getters=========================================

    /**
     * Retrieves the gas composition of the gas planet.
     *
     * @return the gas composition as a String, such as "Mostly Hydrogen and Helium"
     */
    public String getGasComposition() {
        return gasComposition;
    }
    /**
     * Retrieves the Core Composition of the gas planet.
     *
     * @return the Core Composition as a String, e.g. "Rocky and Metallic" or "Liquid Metallic Hydrogen Compressed Hydrogen or Ice Giant"
     */
    public String getCoreComposition() {
        return coreComposition;
    }

    /**
     * Retrieves the radiation level of the gas planet.
     *
     * @return the radiation level as a double
     */
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
        this.radiationLevel = radiationLevel;
    }

    //=============================other_methods===================================

    /**
     *
     * @return the String with the text "Gas Planet" in it
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
        return "Gas Composition: " + gasComposition + " Radiation level: " + radiationLevel + "%" + ", Core Composition: " + coreComposition + " " + CoreCompositionUtility.getCoreDescription(CoreCompositionUtility.isValidCoreType(coreComposition) ? coreComposition : "UNKNOWN");
    }

    /**
     * This method should build a one line string containing the following information and return it (note: no \n should be included in the String):
     * details from the Planet toString() as well as fields above
     * @return
     */
    @Override
    public String toString() {
        return classifyBody() + ": " + super.toString() + " " + displayInfo();
    }
    @Override
    public String toTable(){
        return String.format(Driver.format, "█ ", getId(), " █ ", getName(), " █ ", getMass(), " █ ", getDiameter(), " █ ", getSurfaceType(), " █ ", getAverageTemperature(), " █ ", Utilities.booleanToYN(isHasLiquidWater()) + "     ", " █ ", getGasComposition(), " █ ", getCoreComposition(), " █ ", getRadiationLevel(), " █ ");
    }
}
