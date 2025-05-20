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

    /**
     * Adds a new planet to the universe.
     *
     * @param planet the Planet object to be added
     * @return true if the planet is successfully added
     */
    public boolean addPlanet(Planet planet) {
        universe.add(planet);
        return true;
    }

    public Planet updateIcePlanet(int id, Planet IcePlanet) {
//        getPlanetI
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

    /**
     * Generates a formatted string representation of all planetary bodies in the universe.
     * If no planets are present, it returns a default message indicating that the system is empty.
     * The output includes a header, table-like information for each planet, and a list margin divider.
     *
     * @return a string containing all planetary bodies in a formatted structure,
     *         or a message indicating no planets exist in the system.
     */
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

    /**
     * Generates a formatted header containing a title and additional information with flexible alignment
     * based on the given program width.
     *
     * @param programWidth the total width of the header, used to center-align content and print dividers
     * @param name the main title or name to be displayed in the header
     * @param nameParameter additional details or parameters paired with the name
     * @param additionalInfo secondary information to be displayed below the main title
     * @param additionalInfoParameter additional parameters paired with the secondary information
     * @return a formatted string representing the header with centered alignment and consistent structure
     */
    public String header(int programWidth, String name, String nameParameter, String additionalInfo, String additionalInfoParameter) {
        String output = "";
        output += StringUtilities.printStars(programWidth) + "\n";
        int margin = (programWidth - (int) Checkers.maxOfTwo(name.length() + nameParameter.length(), additionalInfo.length() + additionalInfoParameter.length())) / 2;
        output += StringUtilities.printSymbols(" ", margin) + name + nameParameter;
        output += StringUtilities.printSymbols(" ", margin) + additionalInfo + additionalInfoParameter + "\n";
        output += StringUtilities.printStars(programWidth) + "\n";
        return output;
    }

    /**
     * Generates a formatted table representation of planetary data.
     * The table includes a header row and is formatted according to the specified string format in the Driver class.
     *
     * @param format the format string used to specify the layout of the table's content and structure
     * @return a string containing the formatted table representation of planetary data
     */
    public String tableInfo(String format){
        String output = "";
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + String.format(format, "█ ", "ID ", " █ ", "Planet Name          ", " █ ", "Mass   ", " █ ", "Diameter ", " █ ", "Surface Type    ", " █ ", "Av. Temp", " █ ", "Liquid Water", " █ ", "Ice/Gas Composition     ", " █ ", "Core Composition       ", " █ ", "RadLevel % ", " █ ");
        output += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
    return output;
    }



    /**
     * Generates a formatted string containing details of all ice planets in the system.
     * If no ice planets are present, it returns a default message indicating their absence.
     * The output includes a header, table-like information for each planet, and a styled margin divider.
     *
     * @return a string containing all ice planets in a formatted structure,
     *         or a message stating that there are no ice planets in the system.
     */
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

    /**
     * Generates a formatted string containing details of all gas planets in the system.
     * If no gas planets are present, it returns a default message indicating their absence.
     * The output includes a header, table-like information for each planet, and a styled margin divider.
     *
     * @return a string containing all gas planets in a formatted structure,
     *         or a message stating that there are no gas planets in the system.
     */
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

    /**
     * Retrieves the total number of planetary bodies currently present in the universe.
     *
     * @return the number of planetary bodies stored in the universe
     */
    public int numberPlanetBodies() {
        return universe.size(); // since the universe is an array list of Planets im assuming we don't need to check for isinstanseof
    }

    /**
     * Counts the total number of ice planets present in the universe.
     * Ice planets are identified based on their class type using the instanceof operator.
     *
     * @return the number of ice planets currently stored in the universe
     */
    public int numberOfIcePlanets() {
        int counter = 0;
        for (Planet planet : universe) {
            if (planet instanceof IcePlanet){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Counts the total number of gas planets in the universe.
     * Gas planets are identified based on their class type using the instanceof operator.
     *
     * @return the number of gas planets currently stored in the universe
     */
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

    /**
     * Checks whether the given planet ID is valid by verifying if a planet
     * with the specified ID exists in the universe.
     *
     * @param id the unique identifier of the planet to validate
     * @return true if a planet with the given ID exists
     */
    public boolean isValidId(int id) {
        if (getPlanetById(id) != null) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the provided index is valid within the bounds of the universe list.
     *
     * @param index the index to be validated
     * @return true if the index is non-negative and less than the size of the universe list, false otherwise
     */
    public boolean isValidIndex(int index) {
        if (index >= 0 && index < universe.size()) {
            return true;
        }
        return false;
    }

    /**
     * Finds and returns the highest planet ID currently present in the universe.
     * Iterates through the list of planets to determine the maximum ID.
     *
     * @return the highest planet ID in the universe, or 0 if the list is empty
     */
    private int theHightestId() {
        int highestId = 0;
        for (Planet planet : universe) {
            if(highestId < planet.getId()){
                highestId = planet.getId();
            }
        }
        return highestId;
    }

    //TODO ========================get_Planet_methods========================

    /**
     * Retrieves a planet from the universe list based on the specified index.
     * If the index is valid, the corresponding planet is returned; otherwise, null is returned.
     *
     * @param index the index of the planet to retrieve, must be within the bounds of the universe list
     * @return the Planet object at the specified index, or null if the index is invalid
     */
    public Planet getPlanetByIndex(int index) {
        if (isValidIndex(index)) {
            return universe.get(index);
        }
        return null;
    }

    public int getPlanetIndexById(int id) {
        if (isValidId(id)) {
            for(int i = 0; i < universe.size(); i++){
                if(universe.get(i).getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Retrieves a planet from the universe based on its unique identifier.
     *
     * @param id the unique identifier of the planet to retrieve
     * @return the Planet object with the specified ID, or null if no planet is found with the given ID
     */
    public Planet getPlanetById(int id) {
        for(Planet planet : universe){
            if(planet.getId() == id){
                return planet;
            }
        }
        return null;
    }

    /**
     * Deletes a planet from the universe based on its unique identifier.
     * The planet with the specified ID is removed from the universe if it exists.
     *
     * @param id the unique identifier of the planet to be deleted
     * @return the Planet object that was deleted, or null if no planet was found with the given ID
     */
    public Planet deletePlanetById(int id) {
        Planet planetToDelete = getPlanetById(id);
        System.out.println(planetToDelete.getId() + " " + id);
        universe.remove(getPlanetById(id));
        return planetToDelete;
    }


    //TODO - ========================sort_methods========================

    /**
     * Retrieves and generates a formatted string of all planetary objects in the universe
     * that have a mass greater than the specified weight. The output includes
     * a header indicating the total number of matching planets, a formatted table,
     * and a divider. If no planets meet the criteria, a message stating their absence is returned.
     *
     * @param weight the minimum weight (mass) threshold; only planets heavier than this value
     *               will be included in the results
     * @return a formatted string containing the list of all planets heavier than the specified weight,
     *         or a message stating that no planets meet the criteria
     */
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

    /**
     * Generates a formatted string containing details of all planetary bodies in the universe
     * that have a diameter smaller than the specified value. The output includes a header
     * indicating the total number of matching planets, a formatted table, and a styled margin divider.
     * If no planets meet the criteria, a message stating their absence is returned.
     *
     * @param diameter the maximum diameter threshold; only planets with a diameter smaller than this value
     *                 will be included in the results
     * @return a formatted string containing the list of all planets smaller than the specified diameter,
     *         or a message stating that no planets meet the criteria
     */
    public String listAllPlanetObjectsSmallerThan(double diameter) {
        String output1 = "";
        String output2 = "";
        int counter = 0;
        for (Planet planet : universe) {
            if (planet.getDiameter() < diameter) {
                output2 += planet.toTable();
                counter++;
            }
        }
        if (counter == 0) {
            return "There are no planets smaller than " + diameter + " in the system.\n";
        }
            output1 += header(Driver.programWidth, "Universe has: ", String.valueOf(counter + " Planets smaller than " + diameter), "", "");
            output1 += tableInfo(Driver.format);
            output2 += StringUtilities.printSymbols(" ", Driver.listMargin) + StringUtilities.printSymbols("█", Driver.listWidth) + "\n";
//            System.out.println(output1 + output2);
        return output1 + output2;
    }

    /**
     * Sorts the list of planets in the universe based on their diameters in ascending order.
     * The planets are sorted using a bubble sort algorithm, comparing the diameters
     * of adjacent planets and swapping their positions if necessary.
     * The changes are applied directly to the internal list managing the planets.
     */
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

    /**
     * Retrieves the name of the file where the universe data is stored.
     *
     * @return the name of the file as a string, typically "universe.xml"
     */
    public String fileName() {
        return "universe.xml";
    }

    /**
     * Loads the universe data from an XML file into the program's internal state.
     *
     * This method uses the XStream library to deserialize XML data into a list of planets.
     * It specifies the allowed types (Planet, IcePlanet, and GasPlanet) for security and ensures
     * that the data structure is compatible with the internal representation. The resulting universe
     * list is populated with planets read from the file specified by the `fileName` method.
     * After loading, the next ID for new planets is set based on the highest existing planet ID in the list.
     *
     * @throws IOException if an I/O error occurs while reading from the file
     */
    public void load() throws IOException {
            XStream xstream = new XStream(new DomDriver());
            xstream.allowTypes(new Class[]{Planet.class, IcePlanet.class, GasPlanet.class});
            FileReader reader = new FileReader(fileName());
            universe = (ArrayList) xstream.fromXML(reader);
            reader.close();
            Planet.setNextId(theHightestId()+1);
    }


    /**
     * Saves the current state of the universe to an XML file.
     *
     * This method uses the XStream library to serialize the universe object into XML format.
     * The XML will include type information for the classes: Planet, IcePlanet, and GasPlanet.
     * The serialized data is written to the file whose name is determined by the `fileName` method.
     *
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void save() throws IOException {

            XStream xstream = new XStream(new DomDriver());
            xstream.allowTypes(new Class[]{Planet.class, IcePlanet.class, GasPlanet.class});
            FileWriter writer = new FileWriter(fileName());
            xstream.toXML(universe, writer);
            writer.close();
    }
}
