// Find Maximum in Sliding Window
// In this challenge, we must find the maximum value in a window.
//
// Given a large array of integers and a window of size w, find the current maximum value in the window as the window slides through the entire array.
//
// Consider the array below. Let’s try to find all maximums for a window size = 3.
//

import java.util.PriorityQueue;
import java.util.Comparator;
public class prob1{
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int window_size = 3;
    Comparator<Integer> Comparator = new Comparator<Integer>(){
      public int compare(Integer a, Integer b ){
          return b-a;
      }
    };

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator);

    for (int i = 0; i < arr.length; i++ ) {
      if (queue.size() >= window_size){
        System.out.print(queue.peek() + " ");
        queue.remove(arr[i - window_size]);
      }
      queue.add(arr[i]);
    }
   System.out.print(queue.peek());
  }
}
