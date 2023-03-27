package ex2;

import java.io.*;
import java.util.*;

public class TreeData {

    private List<Tree> trees;

    public TreeData(String fileName) throws IOException {
        this.trees = new ArrayList<>();

        //Read the data from the file specified.
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {

            //Split the line into values using the comma as the delimiter.
            String[] values = line.split(",");
            String location = values[0].trim();
            String name = values[1].trim();
            int age = Integer.parseInt(values[2].trim());
            double height = Double.parseDouble(values[3].trim());

            // Create a new Tree object and add it to the list
            Tree tree = new Tree(location, name, age, height);
            trees.add(tree);
        }
        reader.close();
    }

    public void printTreesBorough() {
        //Create a map to store the number of trees per borough.

        Map<String, Integer> boroughs = new HashMap<>();

        //Count the number of trees in each borough.
        for (Tree tree : trees) {
            String borough = tree.getLocation();
            boroughs.put(borough, boroughs.getOrDefault(borough, 0) + 1);
        }

        //Prints the number of trees per borough to the command line.

        System.out.println("Number of trees per borough:");
        for (Map.Entry<String, Integer> entry : boroughs.entrySet()) {
            String borough = entry.getKey();
            int count = entry.getValue();
            System.out.println(borough + ": " + count);
        }
    }

}
