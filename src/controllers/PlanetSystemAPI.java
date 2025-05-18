package controllers;


import main.Driver;
import models.GasPlanet;
import models.IcePlanet;
import models.Planet;
import utils.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class PlanetSystemAPI {

    //TODO Create a list to store the Planets

    private List<Planet> universe;

    //TODO create a File field to store filename
    private File planetSystemFile;


    //TODO create constructor to initialise filename and instantiate the planets list
public PlanetSystemAPI() {
    planetSystemFile = new File("universe.xml");
    universe  = new ArrayList<>();
}
    //TODO - ========================CRUD_Methods========================

    public boolean addPlanet(Planet planet) {
        universe.add(planet);
        return true;
    }

    public Planet updateIcePlanet(int number, Planet IcePlanet) {
        return Planet.class.cast(null); //?????
    }

    public Planet updateGasPlanet(int number, Planet GasPlanet) {
        return Planet.class.cast(null); //?????
    }

    //TODO - ========================delete_methods========================

    public String deletePlanetIndex(int index) {
        return "What?? return Planet??";
    }

    public String deletePlanetId(int id) {
        return "What?? return Planet??";
    }

    private void swapPlanet(List<Planet> planets, int index1, int index2) {
        Planet temp = planets.get(index1);
        planets.set(index1, planets.get(index2));
        planets.set(index2, temp);
    }

    // TODO ========================Reporting_Methods========================

    public String listAllPlanetBodies() {
        String output = "There are no planets in the system.\n";
        if (numberPlanetBodies() == 0) {
            return output;
        } else {
            output = "";
            output += header(Driver.programWidth, "Universe has: ", String.valueOf(universe.size() + " planets."), "", "");
            output += tableInfo(Driver.format);

            for (Planet planet : universe) {
                output += StringUtilities.printSymbols(" ", Driver.listMargin) + planet.toTable();
            }
            output += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth);
        }
        return output;
    }

    public String header(int programWidth, String name, String nameParameter, String additionalInfo, String additionalInfoParameter) {
        String output = "";
        output += StringUtilities.printStars(programWidth) + "\n";
        int margin = (programWidth - (int) Checkers.maxOfTwo(name.length() + nameParameter.length(), additionalInfo.length() + additionalInfoParameter.length())) / 2;
        output += StringUtilities.printSymbols(" ", margin) + name + nameParameter;
        output += StringUtilities.printSymbols(" ", margin) + additionalInfo + additionalInfoParameter + "\n";
        output += StringUtilities.printStars(programWidth) + "\n";
        return output;
    }

    public String tableInfo(String format){
        String output = "";
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + String.format(format, "█ ", "ID ", " █ ", "Planet Name          ", " █ ", "Mass   ", " █ ", "Diameter ", " █ ", "Surface Type    ", " █ ", "Av. Temp", " █ ", "Liquid Water", " █ ", "Ice/Gas Composition     ", " █ ", "Core Composition       ", " █ ", "RadLevel % ", " █ ");
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
    return output;
    }



    public String listAllIcePlanets() {
        String output = "There are no ice planets in the system.\n";
        if (numberOfIcePlanets() == 0) {
            return output;
        }
        output += header(Driver.programWidth, "Universe has: ", String.valueOf(numberOfIcePlanets() + " Ice Planets."), "", "");
        output += tableInfo(Driver.format);
        for (Planet planet : universe) {
            if (planet instanceof IcePlanet){
                output += (planet.toTable());
            }
        }
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
        return output;
    }

    public String listAllGasPlanets() {
        String output = "There are no gas planets in the system.\n";
        if (numberOfGasPlanets() == 0) {
            return output;
        }
        output += header(Driver.programWidth, "Universe has: ", String.valueOf(numberOfGasPlanets() + " Gas Planets."), "", "");
        output += tableInfo(Driver.format);
        for (Planet planet : universe) {
            if (planet instanceof GasPlanet){
                output += (planet.toTable());
            }
        }
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
        return output;
    }

    // TODO ========================number_methods========================

    public int numberPlanetBodies() {
        return universe.size();
    }

    public int numberOfIcePlanets() {
        int counter = 0;
        for (Planet planet : universe) {
            if (planet instanceof IcePlanet){
                counter++;
            }
        }
        return counter;
    }

    public int numberOfGasPlanets() {
        int counter = 0;
        for (Planet planet : universe) {
            if (planet instanceof GasPlanet){
                counter++;
            }
        }
        return counter;
    }


    //TODO validation method below:
    //the following is isValidId can be updated
    //to suit your code - checks is the id already there in the list

    public boolean isValidId(int id) {
        for (Planet planet : universe) {
            if (planet.getId() == id)
                return false;
        }
        return true;
    }

    public boolean isValidIndex(int index) {
        for (Planet planet : universe) {
            if (universe.indexOf(planet) == index)
                return false;
        }
        return true;
    }

    //TODO ========================get_Planet_methods========================

    public String getPlanetByIndex(int index) {
        return "What?? return Planet??";
    }

    public String deletePlanetById(int id) {
        return "What?? return Planet??";
    }


    //TODO - ========================sort_methods========================

    public String listAllPlanetObjectsHeavierThan(double weight) {
        String output1 = "";
        String output2 = "";
        int counter = 0;
        for(Planet planet : universe){
            if(planet.getMass() > weight){
                output2 += planet.toTable();
                counter++;
            }
        }
        if(counter == 0){
            return "There are no planets heavier than " + weight + " in the system.\n";
        }
        output1 += header(Driver.programWidth, "Universe has: ", String.valueOf(counter + " Planets heavier than " + weight), "", "");
        output1 += tableInfo(Driver.format);
        output2 += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
        return output1 + output2;
    }

    public String listAllPlanetObjectsSmallerThan(double diameter) {
        String output1 = "";
        String output2 = "";
        int counter = 0;
        for(Planet planet : universe){
            if(planet.getDiameter() < diameter){
                output2 += planet.toTable();
                counter++;
            }
        }
        if(counter == 0){
            return "There are no planets smaller than " + diameter + " in the system.\n";
        }
        output1 += header(Driver.programWidth, "Universe has: ", String.valueOf(counter + " Planets smaller than " + diameter), "", "");
        output1 += tableInfo(Driver.format);
        output2 += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
        return output1 + output2;
    }

    public void sortByDiameterAscending() {

    }

    //TODO ========================Top_5_methods========================

    public String topFiveHighestRadiationGasPlanet() {
        return "";
    }

    // TODO ========================Persistence_methods========================

    public String fileName() {
        return "The file ... has been created.";
    }

    public void load() {
        universe.clear();
//        universe.addAll(FileOperations.loadPlanetSystem(planetSystemFile));
    }

    public void save() {
//        FileOperations.savePlanetSystem(universe, planetSystemFile);
    }

}
