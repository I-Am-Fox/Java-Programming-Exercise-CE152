package ex2;

import java.util.Scanner;

// MainEx1 class to interact with the user
public class MainEx1 {
    public static void main(String[] args) {
        // Initialize TreeData instance with dataset filename (Step 12)
        TreeData treeData = new TreeData("C:\\Users\\Josh\\IdeaProjects\\Java-Programming-Exercise-CE152\\src\\ex2\\treesPruned.csv");

        Scanner scanner = new Scanner(System.in);
        String input;

        // Loop to display menu and process user input (Step 13)
        while (true) {
            System.out.println("Please enter:");
            System.out.println("1 to print number of trees per borough");
            System.out.println("2 to print most common tree age");
            System.out.println("3 to print least common tree age");
            System.out.println("4 to print average height per tree name");
            System.out.println("5 to enter tree name and print average height");
            System.out.println("quit to quit");

            input = scanner.nextLine();

            // Process user input and call corresponding methods (Step 20)
            switch (input) {
                case "1":
                    treeData.printTreesPerBorough();
                    break;
                case "2":
                    treeData.printMostCommonAge();
                    break;
                case "3":
                    treeData.printLeastCommonAge();
                    break;
                case "4":
                    treeData.printAverageHeightPerTreeName();
                    break;
                case "5":
                    System.out.println("Enter tree name:");
                    String treeName = scanner.nextLine();
                    treeData.printAverageHeightForTree(treeName);
                    break;
                case "quit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
