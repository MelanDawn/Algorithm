package com.dawn.lc;

public class _a_11_ContainerWithMostWater {

	public static void main(String[] args) {
		assert 0 == maxArea(new int[] {});
		assert 0 == maxArea(null);
		assert 49 == maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });

	}

	// 双指针探测法
	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) return 0;

		int max = 0;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			max = Math.max(max, (r - l) * Math.min(height[r], height[l]));
			if (height[r] < height[l]) {
				r--;
			} else {
				l++;
			}
		}
		return max;
	}

	public static int maxArea2(int[] height) {
		if (height == null || height.length < 2) return 0;

		int max = 0;
		for (int i = 1; i < height.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int result = (i - j) * Math.min(height[i], height[j]);
				if (result > max) max = result;
			}
		}
		return max;
	}

}
