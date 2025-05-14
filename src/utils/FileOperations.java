//package utils;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//import controllers.PlanetSystemAPI;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
// * Utilities for file operations related to planet system persistence.
// */
//public class FileOperations {
//    private static final String DEFAULT_FILE_NAME = "course.xml";
//
//    public static boolean savePlanetSystem(PlanetSystemAPI planetSystem, String fileName) {
//        fileName = (fileName != null) ? fileName : DEFAULT_FILE_NAME;
//
//        try (FileWriter writer = new FileWriter(fileName)) {
//            XStream xstream = createSecureXStream();
//            xstream.toXML(planetSystem, writer);
//            return true;
//        } catch (IOException e) {
//            Logger.error("Failed to save planet system to " + fileName, e);
//            return false;
//        }
//    }
//
//    public static PlanetSystemAPI loadPlanetSystem(String fileName) {
//        fileName = (fileName != null) ? fileName : DEFAULT_FILE_NAME;
//
//        if (!new File(fileName).exists()) {
//            Logger.warn("File not found: " + fileName);
//            return null;
//        }
//
//        try (FileReader reader = new FileReader(fileName)) {
//            XStream xstream = createSecureXStream();
//            return (PlanetSystemAPI) xstream.fromXML(reader);
//        } catch (IOException e) {
//            Logger.error("Failed to load planet system from " + fileName, e);
//            return null;
//        }
//    }
//
//    private static XStream createSecureXStream() {
//        XStream xstream = new XStream(new DomDriver());
//        XStream.setupDefaultSecurity(xstream);
//        xstream.allowTypes(new Class[]{PlanetSystemAPI.class});
//        return xstream;
//    }
//}