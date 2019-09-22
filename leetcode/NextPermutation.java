import java.util.*;
class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 1 2 3
        // 1 3 2
        // 2 1 3
        // 2 3 1
        // 3 1 2
        // 3 2 1
        // how to do permutation by hand?

        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int i = 1;

        for (;i < nums.length; i++) {
            if (nums[nums.length -1 -i] < nums[nums.length - i]) {
                break;  
            }
        }
        
        if (i == nums.length) {
            Arrays.sort(nums);
            return;
        }

     //   System.out.println(i);
        
        // 1 to 2
       // System.out.println(nums[nums.length -1 -i] + 1);

        Arrays.sort(nums, nums.length -i, nums.length);

        int index = Arrays.binarySearch(nums, nums.length - i, nums.length, nums[nums.length -1 -i] + 1);
        
        index = index < 0 ? -index - 1 : index;
        
        int temp = nums[nums.length -1 -i];
        nums[nums.length -1 -i] = nums[index];
        nums[index] = temp;
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();
        int[] result = new int[] {1,  5, 2};
        sol.nextPermutation(result);

        System.out.println(Arrays.toString(result));

    }
}