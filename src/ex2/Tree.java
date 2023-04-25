package ex2;

public class Tree {
    private String objectId;
    private String borough;
    private String name;
    private String ageGroup;
    private double height;

    public Tree(String objectId, String borough, String name, String ageGroup, double height) {
        this.objectId = objectId;
        this.borough = borough;
        this.name = name;
        this.ageGroup = ageGroup;
        this.height = height;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getBorough() {
        return borough;
    }

    public String getName() {
        return name;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public double getHeight() {
        return height;
    }
}
