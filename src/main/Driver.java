package main;

import controllers.PlanetSystemAPI;
import utils.ScannerInput;

public class Driver {


    private PlanetSystemAPI planetAPI;


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
        return ScannerInput.readNextInt("==>> ");
    }


    private void runMainMenu() {
        int option = mainMenu();
        //TODO - write code to call appropiate method based on value in option
        exitApp();
    }

    private void exitApp() {

        System.out.println("Exiting....");
        System.exit(0);
    }





    //todo update methods counting methods


    //---------------------
    //  General Menu Items
    //---------------------

    private void runPlanetAPIMenu(){

    }

    private int planetsMenu(int option){
        return ScannerInput.readNextInt("==>> ");
    }

    private int reportsMenu(int option){
        return ScannerInput.readNextInt("==>> ");
    }

    public void runReportsMenu(){

    }


    public int planetReportsMenu(int option){
        return ScannerInput.readNextInt("==>> ");
    }

    public void runPlanetReportsMenu(){

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
    private void listAllPlanetsSmallerThan(){

    }

    private void listAllPlanetsHeavierThan(){

    }

//TODO- write any helper methods that are required

    private void addPlanet(){

    }

    private void deletePlanet(){

    }

    private int getValidId(){
        return 0;
    }

    private void loadAllData(){

    }

    private void saveAllData(){

    }

}

