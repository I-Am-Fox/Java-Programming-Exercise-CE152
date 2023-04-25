package ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreePriceData {
    private List<TreePrice> treePrices; // data structure to store the tree prices

    public TreePriceData(String filename) throws IOException, ParseException {
        this.treePrices = new ArrayList<>(); // initialize the data structure as an empty ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // split the line into separate values using the comma as the delimiter
                if (values[0].equals("Date")) {
                    continue; // skip the header row
                }
                // parse the date, nominal price, and real price from the CSV file
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(values[0]);
                double nominalPrice = Double.parseDouble(values[1]);
                double realPrice = Double.parseDouble(values[2]);
                // create a new TreePrice object and add it to the list
                this.treePrices.add(new TreePrice(new PriceDate(date), nominalPrice, realPrice));
            }
        }
    }

    public List<TreePrice> getTreePrices() {
        return treePrices;
    }
}

