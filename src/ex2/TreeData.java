package ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TreeData {

    private List<Tree> trees;
    private Map<String, Integer> treesPerBorough;

    public TreeData(String fileName) {
        trees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String objectId = tokens[0];
                String borough = tokens[1];
                String name = tokens[2];
                String ageGroup = tokens[3];
                double height = Double.parseDouble(tokens[4]);
                Tree tree = new Tree(objectId, borough, name, ageGroup, height);
                trees.add(tree);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

        /**
         * Prints the number of trees per borough.
         */
    public void printTreesPerBorough() {
        // Create a map to store the number of trees per borough
        Map<String, Integer> treesPerBorough = new HashMap<>();
        for (Tree tree : trees) {
            // Increment the tree count for the current tree's borough
            treesPerBorough.put(tree.getLocation(), treesPerBorough.getOrDefault(tree.getLocation(), 0) + 1);
        }
        // Print the number of trees per borough
        for (Map.Entry<String, Integer> entry : treesPerBorough.entrySet()) {
            System.out.println("Borough: " + entry.getKey() + ", Trees: " + entry.getValue());
        }
    }

    public void printMostCommonAge() {
        // Create a map to store the number of trees for each age
        Map<Integer, Integer> ageCounts = new HashMap<>();
        int mostCommonAge = 0;
        int mostCommonAgeCount = 0;

        // Count the number of trees for each age and determine the most common age
        for (Tree tree : trees) {
            int age = tree.getAge();
            ageCounts.put(age, ageCounts.getOrDefault(age, 0) + 1);

            int count = ageCounts.get(age);
            if (count > mostCommonAgeCount) {
                mostCommonAgeCount = count;
                mostCommonAge = age;
            }
        }
    }

    //Creates a list of the trees
    public List<Tree> getTrees() {
        return trees;
    }

}



