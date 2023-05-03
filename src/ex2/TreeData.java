package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeData {
    private String filename;
    private List<Tree> trees;

    // Constructor to initialize TreeData object with dataset filename
    public TreeData(String filename) {
        this.filename = filename;
        trees = new ArrayList<>();
        // Read the data from the file here (Step 5)
        //Read the file and populate the 'trees' list
    }

    // Method to print the number of trees per borough (Step 6)
    public void printTreesPerBorough() {
        //Calculate the number of trees per borough
        Map<String, Integer> treesPerBorough = null; // Replace 'null' with the actual implementation
        System.out.println("Number of trees per borough:");
        for (Map.Entry<String, Integer> entry : treesPerBorough.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to print the most common age category of trees (Step 7)
    public void printMostCommonAge() {
        //Calculate the most common age category of trees
        int mostCommonAge = 0; // Replace '0' with the actual implementation
        System.out.println("Most common tree age: " + mostCommonAge);
    }

    // Method to print the least common age category of trees (Step 8)
    public void printLeastCommonAge() {
        //Calculate the least common age category of trees
        int leastCommonAge = 0; // Replace '0' with the actual implementation
        System.out.println("Least common tree age: " + leastCommonAge);
    }

    // Method to print the average height of trees for each unique name (Step 9)
    public void printAverageHeightPerTreeName() {
        //Calculate the average height of trees for each unique name
        Map<String, Double> averageHeightPerTreeName = null; // Replace 'null' with the actual implementation
        System.out.println("Average height per tree name:");
        for (Map.Entry<String, Double> entry : averageHeightPerTreeName.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to print the average height for a specific tree name (Step 10)
    public void printAverageHeightForTree(String treeName) {
        //Calculate the average height for the specified tree name
        double averageHeight = 0.0; // Replace '0.0' with the actual implementation
        System.out.println("Average height for " + treeName + ": " + averageHeight);
    }
}
