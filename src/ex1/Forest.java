package ex1;

import java.util.Random;

class Forest {
    private int numberOfTrees;  //Defines the number of trees in the forest.
    private int maxSize;        //Defines the maximum size of the trees.
    private Tree[] trees;       //Defines an array to hold the trees.

    //Chooses a random height for each tree.
    //Chooses a random tree type through a switch case defined to 3.
    Forest(int numberOfTrees, int maxSize) {
        this.numberOfTrees = numberOfTrees;
        this.maxSize = maxSize;
        trees = new Tree[numberOfTrees];
        Random rand = new Random();
        for (int i = 0; i < numberOfTrees; i++) {
            // choose a random height for each tree
            int height = rand.nextInt(maxSize) + 1;
            int treeType = rand.nextInt(3);
            switch (treeType) {
                case 0 -> trees[i] = new Bamboo(height);
                case 1 -> trees[i] = new BroadleafTree(height);
                case 2 -> trees[i] = new PineTree(height);
            }
        }
    }

    //Method to return a string representaiton of the forest.

    @Override
    public String toString() {
        // Create a StringBuilder to store the output
        StringBuilder sb = new StringBuilder();

        // Find the length of the longest segment among all trees in the forest
        int maxLength = 0;
        for (Tree tree : trees) {
            String[] segments = tree.toString().split("\n");
            for (String segment : segments) {
                maxLength = Math.max(maxLength, segment.length());
            }
        }

        // Append each segment of each tree to the StringBuilder, along with padding to center the segment
        for (Tree tree : trees) {
            String[] segments = tree.toString().split("\n");
            for (String segment : segments) {
                int padding = (maxLength - segment.length()) / 2;
                for (int i = 0; i < padding; i++) {
                    sb.append(" ");
                }
                sb.append(segment).append("\n");
            }
        }

        // Return the output as a string
        return sb.toString();
    }


}
