package controllers;


import main.Driver;
import models.GasPlanet;
import models.IcePlanet;
import models.Planet;
import utils.FileOperations;
import utils.ISerializer;
import utils.StringUtilities;
import utils.Utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class PlanetSystemAPI {

    //TODO Create a list to store the Planets

    private List<Planet> universe = new ArrayList<>();

    //TODO create a File field to store filename
    private File planetSystemFile = new File("universe.xml");


    //TODO create constructor to initialise filename and instantiate the planets list

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
    private final String format = "%2s %4s %3s %31s %3s %10s %3s %10s %3s %21s %3s %8s %3s %12s %3s %30s %2s \n";
    public String listAllPlanetBodies() {
        if (universe.isEmpty()) {
            return "There are no planets in the system.";
        } else {
            Utilities.header(Driver.programWidth, "Universe has: ", String.valueOf(universe.size() + " planets."), "", "");

            System.out.println(StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth));
            System.out.print(StringUtilities.printSymbols(" ", Driver.listMargin) + String.format(format, "█ ", "ID ", " █ ", "Planet Name          ", " █ ", "Mass   ", " █ ", "Diameter ", " █ ", "Surface Type    ", " █ ", "Av. Temp", " █ ", "Liquid Water", " █ ", "Composition         ", " █ "));
            System.out.println(StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth));
            for (Planet planet : universe) {
                System.out.print(StringUtilities.printSymbols(" ", Driver.listMargin) + planet.toTable());
            }
            System.out.println(StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth));
        }
        return ""; // waiting for the answer if i can change the type
    }



    public String listAllIcePlanets() {
        for (Planet planet : universe) {
            if (planet instanceof IcePlanet){
                System.out.print(planet.toTable());
            }
        }
        return ""; // waiting for the answer if i can change the type
    }

    public String listAllGasPlanets() {
        for (Planet planet : universe) {
            if (planet instanceof GasPlanet){
                System.out.print(planet.toTable());
            }
        }
        return ""; // waiting for the answer if i can change the type
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

//    public boolean isValidIndex(int index) {
//        for (Planet pl : planets) {
//            if (pl.getIndex() == index)
//                return false;
//        }
//        return true;
//    }


    //TODO ========================get_Planet_methods========================

    public String getPlanetByIndex(int index) {
        return "What?? return Planet??";
    }

    public String deletePlanetById(int id) {
        return "What?? return Planet??";
    }


    //TODO - ========================sort_methods========================

    public String listAllPlanetObjectsHeavierThan(double weight) {
        return "";
    }

    public String listAllPlanetObjectsSmallerThan(double diameter) {
        return "";
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
        universe.addAll(FileOperations.loadPlanetSystem(planetSystemFile));
    }

    public void save() {
        FileOperations.savePlanetSystem(universe, planetSystemFile);
    }

}
