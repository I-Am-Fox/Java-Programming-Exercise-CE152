package ex3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

public class PlotVegetation extends JComponent {
    private VegetationData vd;
    private boolean useColour;
    private boolean useMap;

    public PlotVegetation(VegetationData vd, boolean useColour, boolean useMap) {
        this.vd = vd;
        this.useColour = useColour;
        this.useMap = useMap;
        setPreferredSize(new Dimension(800, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Loop through all 2D array indices to retrieve the tree density values
        for (int x = 0; x < 2000; x++) {
            for (int y = 0; y < 1000; y++) {
                int density;

                if (useMap) {
                    density = vd.getFromMap(x * 0.36 - 180, y * 0.18 - 90);
                } else {
                    density = vd.getFromArray(x, y);
                }

                // Use blue for ocean areas with tree density values
                if (density == 254) {
                    g.setColor(Color.BLUE);
                } else {
                    if (useColour) {
                        // Use a color map for areas with trees
                        float hue = (density / 100f) * 0.3f; // Use a hue range from brown to green
                        g.setColor(Color.getHSBColor(hue, 0.5f, 1.0f));
                    } else {
                        // Use a gray scale for areas with trees
                        int grayValue = 255 - density * 2;
                        g.setColor(new Color(grayValue, grayValue, grayValue));
                    }
                }
                // Set the color and draw a rectangle for each pixel in the plot
                g.fillRect(x * 2, y * 2, 2, 2);
            }
        }
    }
}

