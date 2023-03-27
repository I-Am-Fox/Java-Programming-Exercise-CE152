package ex2;

public class Tree {
    private String location; // location of the tree
    private String name; // name of the tree
    private int age; // age of the tree
    private double height; // height of the tree

    public Tree(String location, String name, int age, double height) {
        this.location = location;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // Getter method for location
    public String getLocation() {
        return location;
    }

    // Setter method for location
    public void setLocation(String location) {
        this.location = location;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method for height
    public double getHeight() {
        return height;
    }

    // Setter method for height
    public void setHeight(double height) {
        this.height = height;
    }
}
