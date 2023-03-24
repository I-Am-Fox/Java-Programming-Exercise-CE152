package ex1;
import java.lang.*;

abstract class Tree {

    //Private variable to store the height of the tree.
    private int height;

    //Constructor to initialize the height of the tree.
    Tree(int height) {
        this.height = height;
    }

    //Method to be able to get the height of the tree(s). Returns the height.
    int getHeight() {
        return height;
    }

    //Method that requires filling from classes that inherit from it.
    //Returns a string representation of a part of the tree generated. (Also known as a concrete subclass)
    abstract String getSegment(int i);

    //Method to return the string representation of the tree
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //Add the top symbol of the tree as needed.
        sb.append("^" + System.lineSeparator());
        for (int i = 0; i < height; i++) {
            //Add the segment of the tree beneath.
            sb.append(getSegment(i) + System.lineSeparator());
        }
        return sb.toString();
    }

}
