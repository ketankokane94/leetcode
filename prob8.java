// Given a valid XML document, read it in a tree structure.

// <html>
//   <body>
//     <div>
//       <h1>CodeRust</h1>
//       <a>http://coderust.com</a>
//     </div>
//     <div>
//         <h2>Chapter 1</h2>
//     </div>
//     <div>
//         <h3>Chapter 2</h3>
//         <h4>Chapter 2.1</h4>
//     </div>
//   </body>
// </html>

/*
use of stack to match the latest closing tag,
tokenize the string, somehow
  * generate_tree
    ** for every token
      *** if opening token -
      create a node
      while corresponding closing tag is not meet
      call generate_tree and assign the tree generated by it as its child, its going to be an n-ary tree
      *** elseif closing node return null
      *** else create a node and simply return
*/

import java.util.*;

class TreeNode{
  String text;
  ArrayList<TreeNode> children;

  public TreeNode(String val, ArrayList<TreeNode> list){
    this.text = val;
    this.children = list;
  }

  public void addChild(TreeNode child){
    this.children.add(child);
  }
}

public class prob8{
  static HashMap <String, String> map;
  static HashSet<String> openingTags ;
  static HashSet<String> closingTags ;

  public static void main(String[] args) {
    System.out.println("XML to tree");
    map = new HashMap<>();
    map.put("<html>", "<//html>");
    map.put("<body>", "<//body>");
    map.put("<h1>", "<//h1>");
    map.put("<h2>", "<//h2>");
    map.put("<h3>", "<//h3>");
    map.put("<h4>", "<//h4>");
    map.put("<h5>", "<//h5>");
    map.put("<div>", "<//div>");
    map.put("<a>", "<//a>");

    openingTags = new HashSet<>();
    for (String key :map.keySet() ) {
          openingTags.add(key);
    }
    // because could not fnd an easy way to get values of map in a set,
    // could be because values need not to be unique. hence list and not set by default, which is the case for key, as they are for sure Unique
    closingTags = new HashSet<>();
    for (String val: map.values()){
        closingTags.add(val);
    }
    testCase1();
  }

  public static void testCase1(){
    String XMLStr = "<html><body><div><h1>CodeRust<//h1><a>http://coderust.com<//a><//div><div><h2>Chapter 1<//h2><//div><div><h3>Chapter 2<//h3><h4>Chapter 2.1<//h4><//div><//body><//html>";
    LinkedList<String> tokens = tokenize(XMLStr);
    TreeNode root = generateTree(tokens, new Stack<String>());
    printTree(root, 0);
    for (String str : tokens ) {
      System.out.println(str);
    }
  }


  static LinkedList<String> tokenize(String XMLStr){
    // O(n) function
    LinkedList<String> tokens = new LinkedList<>();

    // ArrayList<String> tokens = new ArrayList<>();
    char[] chars = XMLStr.toCharArray();
    StringBuilder sb = new StringBuilder();
    int start = 0;
    for(int end = 0 ; end < XMLStr.length(); end++){
      if(chars[end]== '>' || chars[end] == '<'){
        if (chars[end]== '>'){
          start = end + 1;
          sb.append('>');
          tokens.add(sb.toString());
          // tokens.add(s)
          sb.setLength(0);
        }
        else{
          if (sb.length()> 0)
            tokens.add(sb.toString());
          sb.setLength(0);
          sb.append('<');
        }
      }
      else{
        sb.append(chars[end]);
      }
    }
    return tokens;
  }

  private static boolean isOpeningTag(String token){
    return openingTags.contains(token);
  }

  private static boolean isClosingTag(String token){
    return closingTags.contains(token);
  }


  private static TreeNode generateTree(LinkedList<String> tokens, Stack<String> stack){

      String token = tokens.removeFirst();
      if(isOpeningTag(token)){
          stack.push(map.get(token));
          TreeNode root  = new TreeNode(token, new ArrayList<TreeNode>() );
          while(!stack.peek().equals(token)){
            token = tokens.getFirst();
            root.addChild(generateTree(tokens, stack));
          }
          stack.pop();
          return root;
      }
      else if (!isClosingTag(token)){
          return new TreeNode(token, new ArrayList<TreeNode>());
      }
      return null;
  }

  private static void printTree(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    for (int i = 0; i < depth; ++i)
      System.out.print("\t");
    System.out.print(root.text + "\n");
    for (TreeNode child : root.children) {
      printTree(child, depth + 1);
    }
  }
}
