package com.dawn.lc;

public class _h_71_Search_A_2D_Matrix {

	public static void main(String[] args) {
		int[][] t0 = null;
		int[][] t1 = {};
		int[][] t2 = { {} };
		int[][] t3 = { { 1 } };
		int[][] t4 = { { 1, 2, 3, 4, 5, 6 } };
		int[][] t5 = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 } };
		int[][] t6 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		assert !searchMatrix(t0, 0);

		assert !searchMatrix(t1, 1);

		assert !searchMatrix(t2, 1);

		assert !searchMatrix(t3, 0);
		assert searchMatrix(t3, 1);

		assert searchMatrix(t4, 1);
		assert searchMatrix(t4, 6);
		assert searchMatrix(t4, 3);
		assert !searchMatrix(t4, 0);
		assert !searchMatrix(t4, 7);

		assert searchMatrix(t5, 1);
		assert searchMatrix(t5, 6);
		assert searchMatrix(t5, 3);
		assert !searchMatrix(t5, 0);
		assert !searchMatrix(t5, 7);

		assert searchMatrix(t6, 1);
		assert searchMatrix(t6, 7);
		assert searchMatrix(t6, 20);
		assert searchMatrix(t6, 23);
		assert searchMatrix(t6, 50);
		assert searchMatrix(t6, 11);
		assert searchMatrix(t6, 5);
		assert searchMatrix(t6, 30);
		assert searchMatrix(t6, 16);
		assert !searchMatrix(t6, 15);
		assert !searchMatrix(t6, 0);
		assert !searchMatrix(t6, 51);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;

		int m = matrix.length;
		int n = matrix[0].length;
		if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;

		int low = 0;
		int high = m - 1;
		int i = high;
		while (low <= high) {
			if (matrix[i][0] > target) {
				high = i - 1;
			} else if (matrix[i][n - 1] < target) {
				low = i + 1;
			} else {
				low = i;
				break;
			}
			i = (high + low) >> 1;
		}

		int row = low;
		low = 0;
		high = n - 1;
		i = high;
		while (low <= high) {
			if (matrix[row][i] > target) {
				high = i - 1;
			} else if (matrix[row][i] < target) {
				low = i + 1;
			} else {
				return true;
			}
			i = (high + low) >> 1;
		}

		return false;
	}
}
