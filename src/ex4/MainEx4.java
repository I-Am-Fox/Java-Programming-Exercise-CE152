package ex4;

import java.awt.Dimension;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFrame;

public class MainEx4 {
    public static void main(String[] args) {
        try {
            // read the tree price data from the CSV file
            TreePriceData treePriceData = new TreePriceData("C:\\Users\\Josh\\IdeaProjects\\Java-Programming-Exercise-CE152\\src\\treePrices.csv");

            // create a new JFrame to display the plot
            JFrame frame = new JFrame("Tree Prices");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(800, 600));

            // create a new TreePricePlot object and add it to the JFrame
            TreePricePlot plot = new TreePricePlot();
            plot.setTreePriceData(treePriceData);
            frame.add(plot);

            // display the JFrame
            frame.setVisible(true);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

