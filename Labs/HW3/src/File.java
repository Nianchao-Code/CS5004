/**
 * This class represents a file in the file system. This is the "Leaf" in the Composite Design
 * Pattern.
 */
public class File extends FileSys {

  /**
   * Creates a new file with the specified name.
   *
   * @param name the name of the file
   */
  public File(String name) {
    super(name);
  }

  @Override
  public void prettyPrintName(String indent) {
    System.out.print(indent + name);
  }
}