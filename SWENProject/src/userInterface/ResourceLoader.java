package userInterface;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showConfirmDialog;

/**
 * This class can be used to read jar-contained resource files.
 * <br>
 * <strong>Usage:</strong>
 * Create a folder called 'resources' in the root of your source folder.
 * <br><br>       
 * Here are a few examples:
 * <br><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 * BufferedImage img = ResourceLoader.openImage("images/clip.png");
 * <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 * BufferedReader reader = ResourceLoader.openReader("log.txt");
 * <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 * ArrayList<String> lines = ResourceLoader.readLines("input.txt");
 * <br><br>
 * <strong>Important:</strong>
 * Remember to always close streams when you're done with them.
 * 
 * @author Rudi Theunissen
 */
public class ResourceLoader {

    /**
     * Location of the resource files relative to the root of the jar file
     */
    public static final String RESOURCE_FOLDER = "/resources/";

    /**
     * Returns an {@link java.io.InputStream} from a requested file path
     *
     * @param path path to the file with the resource folder as root
     * @return an {@link java.io.InputStream} from a requested file path
     */
    public static InputStream openStream(String path) {
        path = RESOURCE_FOLDER + path;
        InputStream in = ResourceLoader.class.getResourceAsStream(path);
        if (in == null) error("Not Found: " + path);
        return in;
    }

    /**
     * Returns a {@link java.io.BufferedReader} from a requested file path
     *
     * @param path path to the file with the resource folder as root
     * @return a {@link java.io.BufferedReader} from a requested file path
     */
    public static BufferedReader openReader(String path) {
        InputStreamReader in = new InputStreamReader(openStream(path));
        return new BufferedReader(in);
    }

    /**
     * Returns an {@link java.util.ArrayList} containing the lines in a file
     *
     * @param path path to the file with the resource folder as root
     * @return an {@link java.util.ArrayList} containing the lines in a file
     */
    public static ArrayList<String> readLines(String path) {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = openReader(path);
        try {
            for (String s; (s = reader.readLine()) != null; list.add(s));
        } catch (IOException ex) {
            close(reader);
            error(ex);
        }
        close(reader);
        return list;
    }

    /**
     * Returns a {@link java.awt.Image.BufferedImage} from a file path
     *
     * @param path path to the file with the resource folder as root
     * @return a {@link java.awt.Image.BufferedImage} from a file path
     */
    public static BufferedImage openImage(String path) {
        try {
            InputStream is = openStream(path);
            if (is != null) return ImageIO.read(is);
        } catch (IOException ex) {
            error(ex);
        }
        return null;
    }

    /**
     * Closes a {@link Closeable} object 'quietly'.
     *
     * @param closeable
     */
    public static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException ex) {
            error(ex.getMessage());
        }
    }

    // Simply displays an error dialog and exits.
    private static void error(Object message) {
        message = message + "\nContinue anyway?";
//        if (showConfirmDialog(null, message, "Error", 0, 0) == 1) {
//            System.exit(0);
//        }
    }
}