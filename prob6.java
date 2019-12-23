public class prob6{
  public static void main(String[] args) {
    System.out.println("Reverse word");
    System.out.println(revSent("ketan kokane Mr"));
    System.out.println(revSent("ketan  "));

  }
  // ketan kokane Mr
  //rM enakok natek
  //Mr
  public static String revSent(String sent){
    // reverse entire sentence, then reverse every word
    String rSent = revWord(sent);
    int start = 0;
    int end = 0;
    StringBuilder sb = new StringBuilder();
    while(end < rSent.length()){
      if (rSent.charAt(end) == ' '){
        sb.append(revWord(rSent.substring(start, end)) + " ");
        start = end + 1;
      }
      end++;
    }
    sb.append(revWord(rSent.substring(start, end)));
    return sb.toString();
  }

  public static String revWord(String str){
    char [] chars = str.toCharArray();
    int len = chars.length - 1;
    for (int i = 0; i < chars.length / 2 ; i++){
      char temp = chars[i];
      chars[i] = chars[len - i ];
      chars[len - i] = temp;
    }
    return new String(chars);
  }
}
