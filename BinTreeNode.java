public class BinTreeNode{
  String val;
  BinTreeNode left, right;

  public BinTreeNode(String val,BinTreeNode Left, BinTreeNode right){
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public BinTreeNode(String val){
    this (val, null, null);
  }
}
