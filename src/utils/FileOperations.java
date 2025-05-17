package utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.GasPlanet;
import models.IcePlanet;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilities for file operations related to planet system persistence.
 */
public class FileOperations {
    private static final String DEFAULT_FILE_NAME = "planets.xml";

    public static boolean savePlanetSystem(List universe, File fileName) {

        /**
         * This method saves classes Course and Student to the .xml file
         *
         * @param xstream creates new object of class Xstream using DomDriver
         * @param writer creates new object of class FileWriter that will write the file to the course.xml
         * @return Returns true if the operation is successful
         */
        try {
            XStream xstream = new XStream(new DomDriver());
            xstream.allowTypes(new Class[]{IcePlanet.class, GasPlanet.class});
            FileWriter writer = new FileWriter("universe.xml");
            xstream.toXML(universe, writer);
            writer.close();
            System.out.println("Saved course to universe.xml");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList loadPlanetSystem(File fileName) {
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
            xstream.allowTypes(new Class[]{IcePlanet.class, GasPlanet.class});
            FileReader reader = new FileReader(fileName);
            ArrayList universe = (ArrayList) xstream.fromXML(reader);
            reader.close();
            System.out.println("Loaded universe from universe.xml");
            return universe;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading universe.");
            return null;
        }
    }
}