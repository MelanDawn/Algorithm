package com.dawn.lc;

import java.util.HashSet;
import java.util.Set;

public class _1_TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		if (result.length == 0) {
			System.out.println("未找到");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("indexs = [");
			for (int i : result) {
				sb.append(i).append(", ");
			}
			sb.replace(sb.length() - 2, sb.length() - 1, "]");
			System.out.println(sb.toString());
		}
	}

	/**
	 * https://leetcode.com/problems/two-sum/
	 * description：给定数组和目标数，在给定数组中找到不等的两个元素，其和等于目标数。
	 */
	public static int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) return new int[] {};
		Set<Integer> set = new HashSet<Integer>();
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				index = i;
				break;
			}
			set.add(target - nums[i]);
		}

		if (index != -1) {
			int subTarget = target - nums[index];
			for (int j = 0; j < index; j++) {
				if (nums[j] == subTarget) return new int[] { j, index };
			}
		}
		return new int[] {};
	}

}
