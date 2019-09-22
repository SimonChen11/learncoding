import java.util.*;

class FindMedianItem {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // what is median
        // sizeof smaller <  < size of bigger
        
        // even 4   count/2  x + y == (nums1.length + nums2.length)/2;
        // even 3 count/2   
        
        int n = nums1.length;
        int m = nums2.length;
        
        if (n == 0)
            return m % 2 == 0 ? (nums2[m/2-1] + nums2[m/2])/2.0 : nums2[m/2] * 1.0;
        
        if (m == 0)
            return n % 2 == 0 ? (nums1[n/2-1] + nums1[n/2])/2.0 : nums1[n/2] * 1.0;
        
        int[] bigger = nums2.length > nums1.length ? nums2 : nums1;
        int[] smaller = nums2.length > nums1.length ? nums1 : nums2;
        int total = n + m;
        
        // if (bigger[bigger.length - 1] <= smaller[0]) {
            
        //     if (total % 2 != 0) {
        //         return bigger[total/2];
        //     } else if (bigger.length == smaller.length) {
        //         return (bigger[bigger.length - 1] + smaller[0]) / 2.0;
        //     } else {
        //         return (bigger[total/2 - 1] + bigger[total/2]) / 2.0;
        //     }
        // }
        
        // if (smaller[smaller.length - 1] <= bigger[0]) {
            
        //     if (total % 2 != 0) {
        //         return bigger[total/2 - smaller.length];
        //     } else if (bigger.length == smaller.length) {
        //         return (smaller[smaller.length - 1] + bigger[0]) / 2.0;
        //     } else {
        //         return (bigger[total/2 - smaller.length - 1] + bigger[total/2 - smaller.length]) / 2.0;
        //     }
        // }
        
        int big = bigger.length/2;
        int small = total/2 - big;
        
        int left = total/2 - smaller.length;
        int right = Math.min(total/2, bigger.length);
        
        while(left < right) { // 1 , 3
            
            int result = isGood(big, small, bigger, smaller);
            
            if (result == 0) {
                break;
            } else if (result < 0) {
                right = big -1;
                big = (left + right) / 2;
                small = total/2 - big;
            } else {
                left = big + 1;
                big = (left + right) / 2;
                small = total/2 - big;
            }
        }

        int midLeft = 0;

        if (big == 0) {
            midLeft = smaller[small - 1];    
        } else if (small == 0) {
            midLeft = bigger[big - 1];
        } else {
            midLeft = bigger[big - 1] > smaller[small - 1] ? bigger[big - 1] : smaller[small - 1];
        }

        int midRight = 0;

        if (big == bigger.length) {
            midRight = smaller[small];
        }
        else if (small == smaller.length) {
            midRight = bigger[big];
        } else {
            midRight = bigger[big] > smaller[small] ? smaller[small] : bigger[big];
        }

        return total % 2 == 0 ? (midLeft + midRight)/2.0 : midRight;

// 1,2
//2,3



    }
    
    private static int isGood(int big, int small, int[] bigger, int[] smaller) {
       // System.out.println(big + " " + small);

        if ((big == 0 || small == smaller.length || bigger[big-1] <= smaller[small]) 
            && (small == 0 || big == bigger.length || smaller[small - 1] <= bigger[big])) {
            return 0;
        }
        
        if (big != 0 && small != smaller.length && bigger[big-1] > smaller[small]) { // make it explict
            return -1;
        }
        
        return 1;
    }


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {2}, new int[] {1, 3, 4, 5}));  //3
        //two empty
        System.out.println(findMedianSortedArrays(new int[0], new int[] {1, 2}));  //1.5
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[0]));  // 1.5
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {1}));  // 1.         1,2.   1

        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3,4})); //2.5
        System.out.println(findMedianSortedArrays(new int[] {2}, new int[] {1, 3,4,5})); //3.5
        System.out.println(findMedianSortedArrays(new int[] {1,2}, new int[] {3,4,5})); //3
        System.out.println(findMedianSortedArrays(new int[] {3,4,5,6,7}, new int[] {1, 2, 5})); //4.5
        System.out.println(findMedianSortedArrays(new int[] {3,4,5,6,7}, new int[] {1, 2}));  // 4
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3,4,5,6,7}));  //4

        //2,3,4
        System.out.println(findMedianSortedArrays(new int[] {1, 11}, new int[] {3,4,5,6}));   //4.5
        System.out.println(findMedianSortedArrays(new int[] {1, 2, 4}, new int[] {3}));  //2.5

        System.out.println(findMedianSortedArrays(new int[] {1, 2, 4, 5}, new int[] {2}));  //2

        System.out.println(findMedianSortedArrays(new int[] {1, 2, 4, 5, 9, 100, 200, 201, 202}, new int[] {2, 5,8,11,13,19}));  //9
        //1,2,2,4,5,5,8,9,11,13,19,100,200,201,202



    }
}