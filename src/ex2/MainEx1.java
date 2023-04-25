package ex2;

public class MainEx1 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Josh\\IdeaProjects\\Java-Programming-Exercise-CE152\\src\\ex2\\treesPruned.csv";
        TreeData treeData = new TreeData(fileName);

        treeData.printTreesPerBorough();
        System.out.println();
        treeData.printMostCommonAge();
    }
}
