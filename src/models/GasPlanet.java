package models;

public class GasPlanet extends Planet{
    private String gasComposition = "";
    private String coreComposition = "";
    private double radiationLevel = 0;
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

    }

    public void setCoreComposition(String coreComposition) {

    }

    public void setRadiationLevel(double radiationLevel) {
        if(radiationLevel >= 0 && radiationLevel <= 100){
            this.radiationLevel = radiationLevel;
        }else{
            System.out.println("Radiation level must be between 0 and 100");
        }
    }

    //=============================other_methods===================================

    @Override
    public String classifyBody(){
        return "";
    }
    @Override
    public String displayInfo(){
        return "";
    }
    @Override
    public String toSting() {
        return "";
    }

}
