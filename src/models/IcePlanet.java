package models;

import main.Driver;
import utils.StringUtilities;
import utils.Utilities;

public class IcePlanet extends Planet{
    private String iceComposition = "Mostly Ice"; // max 30 chars
    public IcePlanet(String name, double mass, double diameter, double averageTemperature, String surfaceType, boolean hasLiquidWater, String iceComposition){
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


    /**
     *
     * @return the String with the the text "Ice Planet" in it
     */
    @Override
    public String classifyBody(){
        return "Ice Planet ";
    }
    @Override
    public String displayInfo(){
        return "Ice Composition: " + iceComposition;
    }
    @Override
    public String toString(){
        return classifyBody() + displayInfo() + " " + super.toString();

    }
    public String toTable(){
        return String.format(Driver.format, "█ ", getId(), " █ ", getName(), " █ ", getMass(), " █ ", getDiameter(), " █ ", getSurfaceType(), " █ ", getAverageTemperature(), " █ ",  Utilities.booleanToYN(isHasLiquidWater()) + "     ", " █ ", getIceComposition(), " █ ", "-", " █ ","-", " █ ");
    }
}
