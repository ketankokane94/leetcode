import java.util.HashSet;


public class prob5{
  public static void main(String[] args) {
    System.out.println("Hello world");
    int[] arr = new int[] {1,1,2,3,3, 4,5,6};
    ListNodeInt head = LinkedListUtil.convertToLinkedList(arr);
    LinkedListUtil.print(head);
    head = remove_dupbs(head);
    LinkedListUtil.print(head);
  }


  public static ListNodeInt remove_dupbs(ListNodeInt head){
    ListNodeInt newHead = new ListNodeInt(-1, head);
    ListNodeInt cursor = newHead.next;
    ListNodeInt prev = newHead;
    HashSet<Integer> set = new HashSet<>();

    while(cursor!= null){
      if(set.contains(cursor.val)){
        prev.next = cursor.next;
      }
      else{
        set.add(cursor.val);
        prev = cursor;
      }
      cursor = cursor.next;
    }
    return newHead.next;
  }
}
