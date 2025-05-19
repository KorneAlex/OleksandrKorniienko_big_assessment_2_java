package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import main.Driver;
import models.GasPlanet;
import models.IcePlanet;
import models.Planet;
import utils.*;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PlanetSystemAPI implements ISerializer{

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

    public Planet updateIcePlanet(int id, Planet IcePlanet) {

        return universe.get(id);
    }

    public Planet updateGasPlanet(int number, Planet GasPlanet) {
        return Planet.class.cast(null); //?????
    }

    //TODO - ========================delete_methods========================

    public Planet deletePlanetIndex(int index) {
        return universe.remove(index);
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

    public Planet getPlanetByIndex(int index) {
        return universe.get(index);
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
        for (int i = universe.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (universe.get(j).getDiameter() > universe.get(j + 1).getDiameter()) {
                    swapPlanet(universe, j, j + 1);
                }
            }
        }
    }

    //TODO ========================Top_5_methods========================

    public String topFiveHighestRadiationGasPlanet() {
        ArrayList<Planet> temp = new ArrayList<>();
        Array[]topFive = new Array[5];
        for(Planet planet : universe){
            if (planet instanceof GasPlanet){
                temp.add(planet);
            }
        }
        if(temp.size() == 0){
            return "There are no Gas planets in the system.\n";
        } else {
            //sort
            for (int i = temp.size()-1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
//                    if (temp.get(j).> temp.get(j + 1).getDiameter()) {
//                        swapPlanet(temp, j, j + 1);
//                    }
                }
            }
        }
        return "";
    }

    // TODO ========================Persistence_methods========================

    public String fileName() {
        return "universe.xml";
    }

    public void load() throws IOException {
        /**
         * This method loads the universe from the .xml file
         *
         * @param xstream creates new object of class Xstream using DomDriver
         * @param reader creates new object of class FileReader that will read the file from the universe.xml
         * @param universe creates list "universe" and reads it from the file
         */
            XStream xstream = new XStream(new DomDriver());
            xstream.allowTypes(new Class[]{Planet.class, IcePlanet.class, GasPlanet.class});
            FileReader reader = new FileReader(fileName());
            universe = (ArrayList) xstream.fromXML(reader);
            reader.close();
    }

    public void save() throws IOException {
        /**
         * This method saves classes Course and Student to the .xml file
         *
         * @param xstream creates new object of class Xstream using DomDriver
         * @param writer creates new object of class FileWriter that will write the file to the course.xml
         */
            XStream xstream = new XStream(new DomDriver());
            xstream.allowTypes(new Class[]{Planet.class, IcePlanet.class, GasPlanet.class});
            FileWriter writer = new FileWriter(fileName());
            xstream.toXML(universe, writer);
            writer.close();
    }
}
