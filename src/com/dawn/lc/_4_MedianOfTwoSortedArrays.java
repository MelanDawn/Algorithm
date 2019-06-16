package com.dawn.lc;

public class _4_MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		System.out.println(findMedianSortedArrays(nums1, nums2));

		int[] nums3 = { 1, 2 };
		int[] nums4 = { 3, 4 };
		System.out.println(findMedianSortedArrays(nums3, nums4));

		int[] nums5 = {};
		int[] nums6 = { 1 };
		System.out.println(findMedianSortedArrays(nums5, nums6));
	}

	// 方案：
	// 1、合并两个数组，计算中间值
	// 2、只需要两个数组长度和的一半+1即可，采用方案2；
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 参数检查，如果数组中有空数组，优先保证空数组是 nums1.
		if (nums2 == null || nums2.length == 0) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;
		}
		if (nums1 == null || nums1.length == 0) {
			if (nums2 == null || nums2.length == 0) {
				return 0D;
			} else {
				if ((nums2.length & 1) == 0) {
					return (double) (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2;
				} else {
					return (double) nums2[nums2.length / 2];
				}
			}
		}

		// 只需要两个数组长度和的一半+1即可
		int count = (nums1.length + nums2.length) / 2 + 1;
		int[] mergedArr = new int[count];
		int i = 0;
		int j = 0;
		for (int k = 0; k < count; k++) {
			if (i < nums1.length && j < nums2.length) {
				if (nums1[i] < nums2[j]) {
					mergedArr[k] = nums1[i];
					i++;
				} else {
					mergedArr[k] = nums2[j];
					j++;
				}
			} else {
				// 其中一个数组遍历完毕，只剩下另外一个数组
				int m;
				int[] tmp;
				if (i < nums1.length) {
					tmp = nums1;
					m = i;
				} else {
					tmp = nums2;
					m = j;
				}
				for (; k < count; k++) {
					mergedArr[k] = tmp[m];
					m++;
				}
			}
		}
		if (((nums1.length + nums2.length) & 1) == 0) {
			return (double) (mergedArr[mergedArr.length - 1] + mergedArr[mergedArr.length - 2]) / 2;
		} else {
			return (double) mergedArr[mergedArr.length - 1];
		}
	}
}
