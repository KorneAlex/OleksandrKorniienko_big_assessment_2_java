package controllers;


import models.Planet;
import utils.FileOperations;
import utils.ISerializer;

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

    public String listAllPlanetBodies() {
        return "";
    }

    public String listAllIcePlanets() {
        return "";
    }

    public String listAllGasPlanets() {
        return "";
    }

    // TODO ========================number_methods========================

    public int numberPlanetBodies() {
        return 0;
    }

    public int numberOfIcePlanets() {
        return 0;
    }

    public int numberOfGasPlanets() {
        return 0;
    }


    //TODO validation method below:
    //the following is isValidId can be updated
    //to suit your code - checks is the id already there in the list

    public boolean isValidId(int id) {
        for (Planet pl : universe) {
            if (pl.getId() == id)
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
        universe.addAll(FileOperations.loadPlanetSystem());
    }

    public void save() {
        FileOperations.savePlanetSystem(universe, planetSystemFile);
    }

}
