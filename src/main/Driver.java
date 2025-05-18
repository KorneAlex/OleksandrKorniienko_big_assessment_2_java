package main;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import controllers.PlanetSystemAPI;
import models.GasPlanet;
import models.IcePlanet;
import models.Planet;
import utils.Checkers;
import utils.ScannerInput;
import utils.StringUtilities;
import utils.Utilities;


import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;


public class Driver {

    public static final DecimalFormat df = new DecimalFormat("0.00");
    public static int programWidth = 167;
    public static int menuWidth = 55;
    public static int menuMargin = (programWidth - menuWidth) / 2; // the number to use with utils.Utilities.printSymbol to make menus margin
    public static int listWidth = 220;
    public static int listMargin = (programWidth - listWidth) / 2;
    public static final String format = "%2s %4s %3s %31s %3s %10s %3s %10s %3s %21s %3s %8s %3s %12s %3s %30s %3s %30s %3s %13s %2s\n";
    private PlanetSystemAPI planetAPI = new PlanetSystemAPI();


    public static void main(String[] args) throws Exception {
        new Driver().start();
    }

    public void start() {
        //TODO - construct fields

        //TODO - load all data once the serializers are set up
        runMainMenu();
    }
//TODO - construct menus

    private int mainMenu() {

        //TODO write menu that user will see
        System.out.println(" ");
        menuMargin("|=====================================================|\n");
        menuMargin("|                     Space Place                     |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("|  1. Planets CRUD MENU                               |\n");
        menuMargin("|  2. Reports MENU                                    |\n");
        menuMargin("|-----------------------------------------------------|\n");
        menuMargin("|  3. Search Planets                                  |\n");
        menuMargin("|  4. Sort Planets                                    |\n");
        menuMargin("|-----------------------------------------------------|\n");
        menuMargin("|  10. Save all                                       |\n");
        menuMargin("|  11. Load all                                       |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("Enter choice: ");
        return ScannerInput.readNextInt("");
    }

    private void runMainMenu() {
        int option = mainMenu();
        //TODO - write code to call appropiate method based on value in option
        switch (option) {
            case 1:
                runPlanetAPIMenu();
                break;
            case 2:
                runReportsMenu();
                break;
            case 3:
//                searchPlanets();
                planetAPI.addPlanet(new GasPlanet("TEST GAS", 55, 44, 87, "gas", false, "GAS", "BLABLA", 68));
                planetAPI.addPlanet(new IcePlanet("TEST Ice", 65, 42.1, 134, "rock", false, "ice"));
                System.out.println("next ID: " + Planet.getNextId());
                break;
            case 4:
                planetReportsMenu(2);
                break;
            case 5: // test
                loadAllData();
                listAllPlanets();
                break;
            case 6: // test
                System.out.println(planetAPI.listAllPlanetObjectsSmallerThan(0));
                break;
            case 10:
                saveAllData();
                break;
            case 11:
                loadAllData();
                break;
            case 0:
                exitApp();
            default:
                System.out.println("Invalid option");
                runMainMenu();
        }
        runMainMenu();
    }

    private void exitApp() {

        System.out.println("Exiting....");
        System.exit(0);
    }


    //todo update methods counting methods


    //---------------------
    //  General Menu Items
    //---------------------

    private void runPlanetAPIMenu() {
        System.out.println(" ");
        menuMargin("|=====================================================|\n");
        menuMargin("|                  Planet Object Menu                 |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("|  1. Add a Planet Object                             |\n");
        menuMargin("|  2. Delete a Planet Object                          |\n");
        menuMargin("|-----------------------------------------------------|\n");
        menuMargin("|  3. List all Planet Objects                         |\n");
        menuMargin("|  4. Update a Planet Object                          |\n");
        menuMargin("|-----------------------------------------------------|\n");
        menuMargin("|  0. Return to the Main menu                         |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("Enter choice: ");
        int option = ScannerInput.readNextInt("");
        switch (option) {
            case 1:
                addPlanet();
                break;
            case 2:
                deletePlanet();
                break;
            case 3:
                listMenu();
                break;
            case 4:
//                updatePlanet();
                break;
            case 0:
                runMainMenu();
                break;
            default:
                System.out.println("Invalid option");
                runPlanetAPIMenu();
        }
        runPlanetAPIMenu();
    }

    private void listMenu() {
        menuMargin("|=====================================================|\n");
        menuMargin("|                      List Menu                      |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("|  1. List all Planets                                |\n");
        menuMargin("|  2. List all Ice Planets                            |\n");
        menuMargin("|  3. List all Gas Planets                            |\n");
        menuMargin("|  4. List all Planets smaller than diameter          |\n");
        menuMargin("|  5. List all Planets heavier than mass              |\n");
        menuMargin("|-----------------------------------------------------|\n");
        menuMargin("|  0. Return to the Main menu                         |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("Enter choice: ");
        int option = ScannerInput.readNextInt("");
        switch (option) {
            case 1:
                listAllPlanets();
                break;
            case 2:
                System.out.print(planetAPI.listAllIcePlanets());
                break;
            case 3:
                System.out.print(planetAPI.listAllGasPlanets());
                break;
            case 4:
                listAllPlanetsSmallerThan();
                break;
            case 5:
                listAllPlanetsHeavierThan();
                break;
            case 0:
                runMainMenu();
                break;
            default:
                System.out.println("Invalid option");
                listMenu();
        }
        listMenu();
    }

    private void planetTypeMenu() {
        menuMargin("|=====================================================|\n");
        menuMargin("|                  Choose Planet Type                 |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("|  1. Ice Planet                                      |\n");
        menuMargin("|  2. Gas Planet                                      |\n");
        menuMargin("|  0. Return to the Main menu                         |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("Enter choice : ");
    }

    private int planetsMenu(int option) {
        return ScannerInput.readNextInt("==>> ");
    }

    private int reportsMenu() {
        System.out.println(" ");
        menuMargin("|=====================================================|\n");
        menuMargin("|                     Reports Menu                    |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("|  1. Planets Overview                                |\n");
        menuMargin("|  0. Return to the Main menu                         |\n");
        menuMargin("|_____________________________________________________|\n");
        menuMargin("Enter choice: ");
        return ScannerInput.readNextInt("");
    }



    public void runReportsMenu() {
        int option = reportsMenu();
        switch (option) {
            case 1:
                runPlanetReportsMenu();
                break;
            case 0:
                runMainMenu();
                break;
            default:
                System.out.println("Invalid option");
        }
    }


    public int planetReportsMenu(int option) {
        return ScannerInput.readNextInt("==>> ");
    }

    public void runPlanetReportsMenu() {

    }

    //TODO - write all the methods that are called from your menu
    //---------------------
    //  Search/Sort
    //---------------------

    // TODO search by different criteria i.e. look at the list methods and give options based on that.
// TODO sort  (and give a list of options - not a recurring menu thou)
    //---------------------
    //  Helper Methods
    //---------------------
    private void listAllPlanetsSmallerThan() {
        menuMargin("Enter the minimum diameter of the planets to list: ");

    }

    private void listAllPlanetsHeavierThan() {
        menuMargin("Enter the minimum mass of the planets to list: ");
    }

//TODO- write any helper methods that are required

    private void addPlanet() {
        menuMargin("Enter planet name: ");
        String planetName = Utilities.truncateString(ScannerInput.nextLine(), 30);
        menuMargin("Enter planet mass: ");
        double planetMass = Checkers.inputIsBiggerThan(0);
        menuMargin("Enter planet diameter: ");
        double planetDiameter = Checkers.inputIsBiggerThan(0);
        menuMargin("Enter planet average temperature: ");
        double planetAverageTemperature = Checkers.inputIsInRange(-273.15,400); // 400 max is not the limit either btw
        menuMargin("Enter planet surface type: ");
        String planetSurfaceType = Utilities.truncateString(ScannerInput.nextLine(), 20);
        menuMargin("Does it have a liquid water? y/true/+ for yes or enter anything else to say no: ");
        boolean planetHasLiquidWater = Checkers.YesNotTF(ScannerInput.nextLine());
        planetTypeMenu();
        int choice = Checkers.isInRange(0,2);
        if (choice == 1) {
            menuMargin("Enter Ice Composition: ");
            String iceComposition = Utilities.truncateString(ScannerInput.nextLine(), 30);
            planetAPI.addPlanet(new IcePlanet(planetName, planetMass, planetDiameter, planetAverageTemperature, planetSurfaceType, planetHasLiquidWater, iceComposition));
            menuMargin("Planet added successfully");
        } else if (choice == 2) {
            menuMargin("Enter Gas Composition: ");
            String gasComposition = Utilities.truncateString(ScannerInput.nextLine(), 30);
            menuMargin("Enter Core Composition: ");
            String coreComposition = Utilities.truncateString(ScannerInput.nextLine(), 30);
            menuMargin("Enter Radiation Level min 0.01 max 200.05: ");
            double radiationLevel = Checkers.inputIsInRange(0.01, 200.05);
            planetAPI.addPlanet(new GasPlanet(planetName, planetMass, planetDiameter, planetAverageTemperature, planetSurfaceType, planetHasLiquidWater,  coreComposition, gasComposition, radiationLevel));
            menuMargin("Planet added successfully");
        } else {
            menuMargin("Something went wrong while adding planet");
        }
    }


    private void deletePlanet() {

    }

    private int getValidId() {
        return 0;
    }

    private void loadAllData() {
//        planetAPI.load();
        /**
         * This method loads classes Course and Student from the .xml file
         *
         * @param xstream creates new object of class Xstream using DomDriver
         * @param reader creates new object of class FileReader that will read the file from the universe.xml
         * @param universe creates list "universe" and reads it from the file
         * @return Returns arraylist "universe"
         */
        try {
            XStream xstream = new XStream(new DomDriver());
            xstream.allowTypes(new Class[]{PlanetSystemAPI.class, Planet.class, IcePlanet.class, GasPlanet.class});
            FileReader reader = new FileReader("universe.xml");
            planetAPI = (PlanetSystemAPI) xstream.fromXML(reader);
            reader.close();
            System.out.println("Loaded universe from universe.xml");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading universe.");

        }
    }


    private void saveAllData() {
//        planetAPI.save();
        /**
         * This method saves classes Course and Student to the .xml file
         *
         * @param xstream creates new object of class Xstream using DomDriver
         * @param writer creates new object of class FileWriter that will write the file to the course.xml
         * @return Returns true if the operation is successful
         */
        try {
            XStream xstream = new XStream(new DomDriver());
            xstream.allowTypes(new Class[]{PlanetSystemAPI.class, Planet.class, IcePlanet.class, GasPlanet.class});
            FileWriter writer = new FileWriter("universe.xml");
            xstream.toXML(planetAPI, writer);
            writer.close();
            System.out.println("Saved universe to universe.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listAllPlanets() {
        if (planetAPI.numberPlanetBodies() == 0) {
            System.out.println("There are no planets in the system");
        } else {
            System.out.println("There are " + planetAPI.numberPlanetBodies() + " planets in the system");
            System.out.println(planetAPI.listAllPlanetBodies());
        }
    }

    public void menuMargin(String string) {
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + string);
    }
}
