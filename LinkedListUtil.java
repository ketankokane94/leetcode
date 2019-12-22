public class LinkedListUtil{

  public static void main(String[] args) {
    // mainly to be used for testing purpose
    // given a array convert it to linked list
    int [] testArray = new int[] {1,2,3,4,5,6,7,8,9};
    ListNodeInt ll = convertToLinkedList(testArray);
    print(ll);
  }

  public static void print(ListNodeInt head){
    ListNodeInt cursor = head;
    StringBuilder sb = new StringBuilder();
    while(cursor != null){
        sb.append(cursor.val + " --> ");
        cursor = cursor.next;
    }
    if (sb.length() > 0){
      sb.delete(sb.length()-5, sb.length()-1);
    }
    System.out.println(sb.toString());
  }

  public static ListNodeInt convertToLinkedList(int[] arr){
      // dummy head trick
      ListNodeInt head = new ListNodeInt(-1, null);
      ListNodeInt cursor = head;
      for(int ele : arr){
        cursor.next = new ListNodeInt(ele, null);
        cursor = cursor.next;
      }
      return head.next;
  }
}
