import java.io.*;
import java.util.*;

/*
 * zipCodes = [98052, 95050, 55141, 85151, 67171, ...]
 * Sort them in most optimal fashion
 * 1. first solution, sort by interger value, 
 * Quick sort: 
 * Time: O(n log(n))
 * Space: O(log(n))
 * 2. string solution,
 */

class QuickSort {
  public static void main(String[] args) {
    //String[] results = new String[] {"98052", "95050", "85151", "67171", "55141"};
      
    String[] results = new String[] { "3"};
    
    quickSort(results, 0, results.length-1);
    
    System.out.println(Arrays.toString(results));
    
  }
  
  public static void quickSort(String[] results, int left, int right) {
  
    if (left >= right) {
      return;
    }
    
    int pivotal = right;
    int rightIndex = right - 1;

    int leftWall = left;

    for(int i = left; i <= rightIndex; i++) {
      if (results[i].compareTo(results[pivotal]) < 0) {
          swap(results, leftWall, i);
          leftWall++;
      }
    }

    swap(results, leftWall, pivotal);
  //  System.out.println(leftWall + " " + pivotal);
   // System.out.println(Arrays.toString(results));
    
   //  while(leftIndex < rightIndex) {
   //    System.out.println("-");
   //    if (results[leftIndex].compareTo(results[pivotal]) <= 0) {
   //      leftIndex++;
   //    } else {
   //      swap(results, leftIndex, rightIndex);
   //      rightIndex--;
   //    }
   //  }
    
   //  // leftIndex == rightIndex
   // int num = results[leftIndex].compareTo(results[pivotal]) <= 0 ? leftIndex : leftIndex - 1;

    
    
    quickSort(results, left, leftWall - 1);
    quickSort(results, leftWall + 1, right);
  }
  
  static void swap(String[] results, int left, int right) {
      String temp = results[left];
      results[left] = results[right];
      results[right] = temp;
  }
}
