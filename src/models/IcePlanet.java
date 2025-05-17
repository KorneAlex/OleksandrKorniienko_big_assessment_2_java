package models;

public class IcePlanet extends Planet{
    private String iceComposition = "";
    IcePlanet(String name, double mass, double diameter, double averageTemperature, String surfaceType, boolean hasLiquidWater, String iceComposition){
        super(name, mass, diameter, averageTemperature, surfaceType, hasLiquidWater);
        this.iceComposition = iceComposition;
    }
    //=============================getters=========================================

    public String getIceComposition() {
        return iceComposition;
    }
    //=============================setters=========================================

    public void setIceComposition(String iceComposition) {
        this.iceComposition = iceComposition;
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
    public String toSting(){
        return "";
    }
}
