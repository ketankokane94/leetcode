
// Given the roots of two binary trees, determine if these trees are identical or not.

/*
   need a way to generate a binary tree from the array
*/
public class prob9 {
  public static void main(String[] args) {
    System.out.println("Prob 9 : Check two Bin tree are identical");
    String [] arr = new String[] {"1", "0", "6" , "3"};
    String [] arr1 = new String[] {"1", "0", "6" , "3", "7"};
    BinTreeNode root1 = TreeUtil.generateTree(arr, 0);
    BinTreeNode root2 = TreeUtil.generateTree(arr1, 0);
    System.out.println(identical(root1, root2));

  }

/*
algo:
would be a recursive funtion
check if r1 and r2 are both either null or have same contents
*/
  static boolean identical(BinTreeNode r1, BinTreeNode r2){
    if (r1 == null && r2 == null){
      return true;
    }
    // means both of them are not null or either of them is null
    // if either of them is null return false
    if (r1 == null || r2 == null ){
      return false;
    }
    // means both of them are not null so check for their content
    if (r1.val.compareTo(r2.val) != 0 ){
      // both the values where nor same, not sure about the compare method would work for int, boolean
      return false;
    }
    // means both the content is same, now check for both left and
    return identical(r1.left, r2.left) && identical(r1.right , r2.right);
  }
}
