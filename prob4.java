// delete a node with the given key in LL

public class prob4 {
  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6};
    ListNodeInt head = LinkedListUtil.convertToLinkedList(arr);
    LinkedListUtil.print(head);
    head = delete(head, 1);
    head = delete(head, 4);
    head = delete(head, 5);
    head = delete(head, 6);
    head = delete(head, 3);
    head = delete(null, 2);
    LinkedListUtil.print(head);
    System.out.println();
  }

  public static ListNodeInt delete(ListNodeInt head, int key){
    // delete a node in the linked list
    ListNodeInt newHead = new ListNodeInt(-1, head);
    ListNodeInt prev = newHead;
    ListNodeInt cursor = newHead.next;
//1 --> 2 --> 3 --> 4 --> 5 --> 6
    while(cursor != null){
      if (cursor.val == key){
          prev.next = cursor.next;
      }
      prev = cursor;
      cursor = cursor.next;
    }
    return newHead.next;
  }
}
