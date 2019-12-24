/*
Gonna make the Binary tree generated using something like leet code tree generator
using array, I want to keep it generic, the user of the TreeNode should specify the type

*/

public class TreeUtil{

  public static void main(String[] args) {
    System.out.println("Tree util");
    String [] arr = new String[] {"1", "0", "6" , "3"};
    BinTreeNode root = generateTree(arr, 0);
    printTree(root, 0);

  }

  public static BinTreeNode generateTree(String[] arr, int pIndex){

    if (pIndex >= arr.length)
      return null;
    BinTreeNode root = new BinTreeNode(arr[pIndex]);
    root.left =  generateTree(arr, (pIndex*2) + 1 );
    root.right =  generateTree(arr, (pIndex*2) +2);
    return root;
  }

  private static void printTree(BinTreeNode root, int depth) {
    if (root == null) {
      return;
    }
    for (int i = 0; i < depth; ++i)
      System.out.print("\t");
    System.out.print(root.val + "\n");
    printTree(root.left, depth + 1);
    printTree(root.right, depth + 1);

  }
}
