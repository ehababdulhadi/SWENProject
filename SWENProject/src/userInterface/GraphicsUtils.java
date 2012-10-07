/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import javax.swing.JComponent;

/**
 *
 * @author Paranoid
 */
public class GraphicsUtils {

    public static void enableAntiAliasing(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static void enableTextAntiAliasing(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    public static void enableBilinearInterpolation(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    }

    public static void disableBilinearInterpolation(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
    }

    public static void enableHighQuality(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public static BufferedImage cropImage(BufferedImage src, Rectangle rect) {
        return src.getSubimage(rect.x, rect.y, rect.width, rect.height);
    }

    public static Area imageToArea(BufferedImage image) {
        Area a = new Area();
        Rectangle r = new Rectangle();
        r.setSize(1, 1);
        for (int x = 0; x < image.getWidth(); x++)
            for (int y = 0; y < image.getHeight(); y++)
                if (image.getRGB(x, y) >>> 24 > 0) {
                    r.setLocation(x, y);
                    a.add(new Area(r));
                }
        return a;
    }
}
