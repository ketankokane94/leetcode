

public class prob3{
  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6};
    ListNodeInt head = LinkedListUtil.convertToLinkedList(arr);
    LinkedListUtil.print(head);
    System.out.println("after reversing");
    head = reverse(head);
    LinkedListUtil.print(head);

  }

  static ListNodeInt reverse(ListNodeInt head){
    ListNodeInt cursor = head;
    ListNodeInt prev = null;
    ListNodeInt temp = null;
    while(cursor.next != null){
      temp = cursor.next;
      cursor.next = prev;
      prev = cursor;
      cursor = temp;
    }
    cursor.next = prev;
    return cursor;
  }
}
