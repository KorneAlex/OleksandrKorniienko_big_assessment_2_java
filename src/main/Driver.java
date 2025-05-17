package main;

import controllers.PlanetSystemAPI;
import models.IcePlanet;
import utils.ScannerInput;
import utils.StringUtilities;

import java.text.DecimalFormat;

public class Driver {

    public static final DecimalFormat df = new DecimalFormat("0.00");
    public static int programWidth = 167;
    public static int menuWidth = 55;
    public static int menuMargin = (programWidth - menuWidth) / 2; // the number to use with utils.Utilities.printSymbol to make menus margin
    public static int listWidth = 167;
    public static int listMargin = (programWidth - listWidth) / 2;

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
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|=====================================================|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|                     Space Place                     |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  1. Planets CRUD MENU                               |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  2. Reports MENU                                    |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|-----------------------------------------------------|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  3. Search Planets                                  |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  4. Sort Planets                                    |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|-----------------------------------------------------|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  10. Save all                                       |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  11. Load all                                       |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "Enter choice : ");
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
                break;
            case 4:
                planetReportsMenu(2);
                break;
            case 5: // test
                loadAllData();
                listAllPlanets();
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
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|=====================================================|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|                  Planet Object Menu                 |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  1. Add a Planet Object                             |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  2. Delete a Planet Object                          |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|-----------------------------------------------------|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  3. List all Planet Objects                         |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  4. Update a Planet Object                          |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|-----------------------------------------------------|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  0. Return to the Main menu                         |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "Enter choice : ");
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
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|=====================================================|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|                      List Menu                      |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  1. List all Planets                                |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  2. List all Ice Planets                            |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  3. List all Gas Planets                            |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  4. List all Planets smaller than diameter          |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  5. List all Planets heavier than mass              |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|-----------------------------------------------------|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  0. Return to the Main menu                         |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "Enter choice : ");
        int option = ScannerInput.readNextInt("");
        switch (option) {
            case 1:
                listAllPlanets();
                break;
            case 2:
                planetAPI.listAllIcePlanets();
                break;
            case 3:
                planetAPI.listAllGasPlanets();
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

    private int planetsMenu(int option) {
        return ScannerInput.readNextInt("==>> ");
    }

    private int reportsMenu() {
        System.out.println(" ");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|=====================================================|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|                     Reports Menu                    |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  1. Planets Overview                                |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|  0. Return to the Main menu                         |\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "|_____________________________________________________|\n");
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "Enter choice : ");
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
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "Enter the minimum diameter of the planets to list : ");

    }

    private void listAllPlanetsHeavierThan() {
        System.out.print(StringUtilities.printSymbols(" ", menuMargin) + "Enter the minimum mass of the planets to list : ");
    }

//TODO- write any helper methods that are required

    private void addPlanet() {
        if(planetAPI.addPlanet(new IcePlanet("Test Planet", 22.5, 656.99, 65.8, "Rocks", false, "ICEEEE"))){
            System.out.println("Planet added successfully");
        } else {
            System.out.println("Planet could not be added");
        }
    }

    private void deletePlanet() {

    }

    private int getValidId() {
        return 0;
    }

    private void loadAllData() {
        planetAPI.load();
    }

    private void saveAllData() {
        planetAPI.save();
    }

private void listAllPlanets() {
    if (planetAPI.numberPlanetBodies() == 0) {
        System.out.println("There are no planets in the system");
    } else {
        System.out.println("There are " + planetAPI.numberPlanetBodies() + " planets in the system");
        System.out.println(planetAPI.listAllPlanetBodies());
    }
}
    }

