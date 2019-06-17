package com.dawn.lc;

public class _b_27_RemoveElement {

	public static void main(String[] args) {
		int[] t1 = { 3, 2, 2, 3 };
		int val1 = 3;
		int len1 = removeElement(t1, val1);
		for (int i = 0; i < len1; i++) {
			System.out.print(t1[i] + "\t");
		}
		System.out.println();

		int[] t2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val2 = 2;
		int len2 = removeElement(t2, val2);
		for (int i = 0; i < len2; i++) {
			System.out.print(t2[i] + "\t");
		}
	}

	// 数组内不等于 val 值的元素向前集中，等于 val 值的元素不能占前面的位置
	/*
	 * 两个角标从左向右循环， 找到第一个非法的角标， 从非法角标开始找到第一个合法角标，交换值，非法角标+1 找不到说明后续全部是非法值，外层循环结束
	 */
	public static int removeElement(int[] nums, int val) {
		if (nums == null) return 0;
		int invalid = 0;
		int valid = 0;
		while (invalid < nums.length) {
			if (nums[invalid] == val) {
				valid = invalid + 1;
				while (valid < nums.length) {
					if (nums[valid] != val) {
						int tmp = nums[invalid];
						nums[invalid] = nums[valid];
						nums[valid] = tmp;
						invalid++;
					} else {
						valid++;
					}
				}
				if (valid >= nums.length) break;
			} else {
				invalid++;
			}
		}
		return invalid;
	}
}
