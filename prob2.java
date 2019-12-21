import java.util.*;


public class prob2 {
  public static void main(String[] args) {
    int[] arr = new int[] {100,101,102,3,5,6,7,9, 10, 11};
    System.out.println("Index is " + search(arr, 10));
    System.out.println("Index is " + search(arr, 3));
    System.out.println("Index is " + search(arr, 10));
  }

  public static int search(int [] arr, int target){

    return binSearch(0, arr.length-1, arr, target);

  }

  static int binSearch(int left, int right, int[] arr, int target){
    // to be split point, it has to be less than left and right element
    if (left > right){
      return -1;
    }
    int mid = (left + right) >> 1;
    if (target == arr[mid]){
        return mid;
    }

    // see if the target is in the range from left to mid and this range is sorted
    if (arr[left] <= arr[mid] && arr[left] <= target && target < arr[mid]){
      return binSearch(left, mid-1, arr, target);
    }
      // see if the target is in the range from  mid to right and this range is sorted
    if (arr[mid] <= arr[right] && arr[mid] < target && target <= arr[right]){
      return binSearch(mid+1, right, arr, target);
    }

    if (arr[right] <= arr[mid]){
      // means right side range was not sorted
      return binSearch(mid+1, right, arr, target);
    }
    else{
      // means left side range is not sorted
      return binSearch(left, mid-1, arr, target);
    }
  }
}
