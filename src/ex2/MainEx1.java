package ex2;

public class MainEx1 {
    public static void main(String[] args) {
        String fileName = "treesPruned.csv";
        TreeData treeData = new TreeData(fileName);

        treeData.printTreesPerBorough();
        System.out.println();
        treeData.printMostCommonAge();
    }
}
