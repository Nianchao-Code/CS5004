/**
 * This class represents a folder (directory) in the file system. This is the "Composite" in the
 * Composite Design Pattern.
 */

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSys {

  /** List of child nodes (files and folders) contained in this folder */
  private List<FileSys> children;

  /**
   * Creates a new folder with the specified name.
   *
   * @param name the name of the folder
   */
  public Folder(String name) {
    super(name);
    this.children = new ArrayList<>();
  }

  /**
   * Adds a child node (file or folder) to this folder.
   *
   * @param node the node to add
   */
  public void addNode(FileSys node) {
    children.add(node);
  }

  @Override
  public void prettyPrintName(String indent) {
    System.out.print(indent + "d " + name);

    String newIndent = indent + "   ";
    for (FileSys child : children) {
      System.out.println();
      child.prettyPrintName(newIndent);
    }
  }
}