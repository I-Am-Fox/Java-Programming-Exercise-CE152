package ex4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.text.SimpleDateFormat;
import javax.swing.JComponent;

public class TreePricePlot extends JComponent {
    @Serial
    private static final long serialVersionUID = 1L;
    private TreePriceData treePriceData;
    private double nominalMax;
    private double realMax;
    private TreePrice closestPrice;

    public TreePricePlot() {
        this.treePriceData = null;
        this.nominalMax = 0;
        this.realMax = 0;
        this.closestPrice = null;

        // add a mouse adapter to the plot
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (treePriceData != null) {
                    // calculate the width and height of the plot area
                    int width = getWidth() - 40;
                    int height = getHeight() - 60;

                    // calculate the x and y scales
                    double xScale = width / (double) (treePriceData.getTreePrices().size() - 1);
                    double yScale = height / realMax;

                    // calculate the x and y values of the mouse click
                    int x = e.getX();
                    int y = e.getY();

                    // find the closest TreePrice object to the mouse click
                    TreePrice closestPrice = treePriceData.getTreePrices().get(0);
                    double closestDistance = Double.MAX_VALUE;
                    for (TreePrice treePrice : treePriceData.getTreePrices()) {
                        int px = (int) (20 + (treePriceData.getTreePrices().indexOf(treePrice) * xScale));
                        int py = height - (int) (treePrice.getRealPrice() * yScale);
                        double distance = Math.sqrt(Math.pow(x - px, 2) + Math.pow(y - py, 2));
                        if (distance < closestDistance) {
                            closestPrice = treePrice;
                            closestDistance = distance;
                        }
                    }

                    // print the closest price to the command line
                    System.out.printf("Closest price to (%d, %d): %s\n", x, y, closestPrice.toString());
                }
            }
        });
    }

    public void setTreePriceData(TreePriceData treePriceData) {
        this.treePriceData = treePriceData;
        // calculate the maximum nominal and real prices in the data set
        for (TreePrice treePrice : treePriceData.getTreePrices()) {
            if (treePrice.getNominalPrice() > nominalMax) {
                nominalMax = treePrice.getNominalPrice();
            }
            if (treePrice.getRealPrice() > realMax) {
                realMax = treePrice.getRealPrice();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (treePriceData == null) {
            return; // if no tree price data has been set, do nothing
        }

        // calculate the width and height of the plot area
        int width = getWidth() - 40;
        int height = getHeight() - 60;

        // calculate the x and y scales
        double xScale = width / (double) (treePriceData.getTreePrices().size() - 1);
        double yScale = height / realMax;

        // create a new SimpleDateFormat object to format the dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");

        // set the initial x and y values
        int x = 20;
        int yNominal = height - (int) (treePriceData.getTreePrices().get(0).getNominalPrice() * yScale);
        int yReal = height - (int) (treePriceData.getTreePrices().get(0).getRealPrice() * yScale);

        // draw the nominal price line
        g.setColor(Color.RED);
        for (int i = 1; i < treePriceData.getTreePrices().size(); i++) {
            x += xScale;
            int newY = height - (int) (treePriceData.getTreePrices().get(i).getNominalPrice() * yScale);
            g.drawLine((int) (x - xScale), yNominal, (int) x, newY);
            yNominal = newY;
            g.drawString(dateFormat.format(treePriceData.getTreePrices().get(i).getPriceDate().toDate()),
                    (int) x - 20, height + 15);
        }

        // reset the x value and draw the real price line
        x = 20;
        g.setColor(Color.BLUE);
        for (int i = 1; i < treePriceData.getTreePrices().size(); i++) {
            x += xScale;
            int newY = height - (int) (treePriceData.getTreePrices().get(i).getRealPrice() * yScale);
            g.drawLine((int) (x - xScale), yReal, (int) x, newY);
            yReal = newY;
        }
    }
}

