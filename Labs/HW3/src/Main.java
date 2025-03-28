/**
 * This is the test class to demonstrate the Composite Pattern implementation of a file system.
 */
public class Main {

  public static void main(String[] args) {
    // Create the root folder
    Folder root = new Folder("root");

    // Create home folder under root
    Folder home = new Folder("home");
    root.addNode(home);

    // Create mlmiller folder under home
    Folder mlmiller = new Folder("mlmiller");
    home.addNode(mlmiller);

    // Create files under mlmiller
    File markFileA = new File("markFileA.txt");
    File markFileB = new File("markFileB.txt");
    mlmiller.addNode(markFileA);
    mlmiller.addNode(markFileB);

    // Print the file system structure
    root.prettyPrintName("");
    System.out.println(); // Add a newline at the end
  }
}