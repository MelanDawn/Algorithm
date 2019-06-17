package com.dawn.lc;

public class _b_26_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] t1 = { 1, 1, 2 };
		int len1 = removeDuplicates(t1);
		for (int i = 0; i < len1; i++) {
			System.out.print(t1[i] + "\t");
		}
		System.out.println();

		int[] t2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int len2 = removeDuplicates(t2);
		for (int i = 0; i < len2; i++) {
			System.out.print(t2[i] + "\t");
		}
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;

		int valid = 0;
		int checked = 1;
		while (checked < nums.length) {
			if (nums[checked] > nums[valid]) {
				valid++;
				nums[valid] = nums[checked];
				checked++;
			} else {
				checked++;
			}
		}
		return valid + 1;
	}

}
