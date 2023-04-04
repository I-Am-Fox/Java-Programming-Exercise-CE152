package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Forest {
    private List<Tree> trees;
    private char[][] forestArray;
    private int maxTreeHeight;

    // Constructor
    public Forest(int numberOfTrees, int maxSize) {
        trees = new ArrayList<>();
        Random random = new Random();

        // Create random trees and add them to the trees list
        for (int i = 0; i < numberOfTrees; i++) {
            int height = random.nextInt(maxSize) + 1;
            int treeType = random.nextInt(3);

            switch (treeType) {
                case 0:
                    trees.add(new Bamboo(height));
                    break;
                case 1:
                    trees.add(new BroadleafTree(height));
                    break;
                case 2:
                    trees.add(new PineTree(height));
                    break;
            }
        }

        // Find the maximum tree height in the forest
        maxTreeHeight = trees.stream().mapToInt(Tree::getHeight).max().orElse(0);

        // Calculate the total width of the forest
        int totalWidth = trees.stream().mapToInt(tree -> tree.getSegment(1).length()).sum();

        // Create a 2D array to store the forest structure
        forestArray = new char[maxTreeHeight][totalWidth];

        // Fill the forest array with tree segments
        fillForestArray();
    }

    // Fill the 2D forest array with tree segments
    private void fillForestArray() {
        int currentWidth = 0;

        for (Tree tree : trees) {
            int treeHeight = tree.getHeight();
            for (int i = 0; i < maxTreeHeight; i++) {
                String segment;
                int treeSegmentIndex = i - (maxTreeHeight - treeHeight);

                // If the current row index is within the tree's height, get the corresponding segment
                if (treeSegmentIndex >= 0) {
                    segment = tree.getSegment(treeSegmentIndex);
                } else {
                    // Otherwise, fill the row with spaces
                    segment = " ".repeat(tree.getSegment(1).length());
                }

                // Copy the segment characters to the forestArray
                for (int j = 0; j < segment.length(); j++) {
                    forestArray[i][currentWidth + j] = segment.charAt(j);
                }
            }

            // Move to the next tree's starting width
            currentWidth += tree.getSegment(1).length();
        }
    }

    // Override the toString method to print the forest
    @Override
    public String toString() {
        StringBuilder forestString = new StringBuilder();

        // Iterate through the forestArray and append its characters to the forestString
        for (int i = 0; i < maxTreeHeight; i++) {
            for (int j = 0; j < forestArray[i].length; j++) {
                forestString.append(forestArray[i][j]);
            }
            forestString.append('\n');
        }

        return forestString.toString();
    }
}
