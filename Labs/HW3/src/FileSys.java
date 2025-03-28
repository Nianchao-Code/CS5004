/**
 * It is the abstract class representing a node in the file system. This is the "Component" in
 * the Composite Design Pattern.
 */
public abstract class FileSys {

  /**
   * The name of this file system node
   */
  protected String name;

  /**
   * Creates a new file system node with the specified name.
   *
   * @param name the name of the node
   */
  public FileSys(String name) {
    this.name = name;
  }

  /**
   * Gets the name of the file system node.
   *
   * @return the name of the node
   */
  public String getName() {
    return name;
  }

  /**
   * Pretty prints the name of this node with appropriate indentation.
   *
   * @param indent the indentation string to use
   */
  public abstract void prettyPrintName(String indent);
}