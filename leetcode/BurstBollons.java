
// Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

// Find the maximum coins you can collect by bursting the balloons wisely.

// Note:

// You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

class BurstBollons{

	public static void main(String[] args) {
		int[] ballons = new int[] {3, 2, 1};

		System.out.println(burstBallons(ballons));
	}

	public static int burstBallons(int[] ballons) {
		if (ballons == null || ballons.length == 0)
			return 0;

		int[][] result = new int[ballons.length][ballons.length];

		for(int i = 0; i < ballons.length; i++)
			for(int j = 0; j < ballons.length - i; j++) {
					int max = 0;
					int temp = 0;
					for (int k = 0; k <= i; k++) {
						temp = ballons[j + k] * (j == 0 ? 1 : ballons[j -1]) * (j + i == ballons.length - 1? 1 : ballons[j + i + 1 ]);

						if (k > 0) {
							temp += result[j][j + k - 1];
						}

						if (k < i) {
							temp += result[j + k + 1][j + i];
						}

						max = Math.max(max, temp);
					}

					result[j][j + i] = max;
				}
		return result[0][ballons.length - 1];
	}


// test cases
//	length 0: ignore

}