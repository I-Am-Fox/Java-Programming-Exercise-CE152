package ex2;

public class Tree {
    private String location;
    private String name;
    private int age;
    private int height;

    public Tree(String location, String name, int age, int height) {
        this.location = location;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
