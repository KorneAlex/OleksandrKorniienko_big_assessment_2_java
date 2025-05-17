package utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import controllers.PlanetSystemAPI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utilities for file operations related to planet system persistence.
 */
public class FileOperations {
    private static final String DEFAULT_FILE_NAME = "course.xml";

    public static boolean savePlanetSystem(PlanetSystemAPI planetSystem, String fileName) {
        fileName = (fileName != null) ? fileName : DEFAULT_FILE_NAME;

        try (FileWriter writer = new FileWriter(fileName)) {
            XStream xstream = createSecureXStream();
            xstream.toXML(planetSystem, writer);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static PlanetSystemAPI loadPlanetSystem(String fileName) {
        fileName = (fileName != null) ? fileName : DEFAULT_FILE_NAME;

        if (!new File(fileName).exists()) {
            return null;
        }

        try (FileReader reader = new FileReader(fileName)) {
            XStream xstream = createSecureXStream();
            return (PlanetSystemAPI) xstream.fromXML(reader);
        } catch (IOException e) {
            return null;
        }
    }

    private static XStream createSecureXStream() {
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(new Class[]{PlanetSystemAPI.class});
        return xstream;
    }
}