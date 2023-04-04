package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Forest {
    private List<Tree> trees;
    private char[][] forestArray;
    private int maxTreeHeight;

    public Forest(int numberOfTrees, int maxSize) {
        trees = new ArrayList<>();
        Random random = new Random();

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

        maxTreeHeight = trees.stream().mapToInt(Tree::getHeight).max().orElse(0);
        int totalWidth = trees.stream().mapToInt(tree -> tree.getSegment(1).length()).sum();
        forestArray = new char[maxTreeHeight][totalWidth];

        fillForestArray();
    }

    private void fillForestArray() {
        int currentWidth = 0;

        for (Tree tree : trees) {
            for (int i = 0; i < maxTreeHeight; i++) {
                String segment;
                if (i < tree.getHeight()) {
                    segment = tree.getSegment(i);
                } else {
                    segment = " ".repeat(tree.getSegment(1).length());
                }
                for (int j = 0; j < segment.length(); j++) {
                    forestArray[i][currentWidth + j] = segment.charAt(j);
                }
            }
            currentWidth += tree.getSegment(1).length();
        }
    }


    @Override
    public String toString() {
        StringBuilder forestString = new StringBuilder();

        for (int i = 0; i < maxTreeHeight; i++) {
            for (int j = 0; j < forestArray[i].length; j++) {
                forestString.append(forestArray[i][j]);
            }
            forestString.append('\n');
        }

        return forestString.toString();
    }
}
