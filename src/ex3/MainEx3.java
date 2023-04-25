package ex3;

import javax.swing.JFrame;

public class MainEx3 {
    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("user.dir"));
            // Create a new VegetationData object using the filename "vegetationData.csv"
            VegetationData data = new VegetationData("C:\\Users\\Josh\\IdeaProjects\\Java-Programming-Exercise-CE152\\src\\vegetationData.csv");
            // Create a new PlotVegetation object using the VegetationData object and set the useColour and useMap booleans
            PlotVegetation plot = new PlotVegetation(data, true, true);
            // Create a new JFrame and add the PlotVegetation object to it
            JFrame frame = new JFrame("Vegetation Plot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(plot);

            // Pack the frame to fit the preferred size of the panel, and make it visible
            frame.pack();
            frame.setVisible(true);
        }

        catch (Exception e) {
            e.printStackTrace();

        }
    }
}
