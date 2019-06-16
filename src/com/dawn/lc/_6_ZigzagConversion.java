package com.dawn.lc;

public class _6_ZigzagConversion {

	public static void main(String[] args) {
		String t1 = "PAYPALISHIRING";
		assert "PYAIHRNAPLSIIG".equals(convert(t1, 2));
		assert "PAHNAPLSIIGYIR".equals(convert(t1, 3));
		assert "PINALSIGYAHRPI".equals(convert(t1, 4));
	}

	public static String convert(String s, int numRows) {
		if (s == null || s.length() < 2 || numRows == 1) return s;
		StringBuilder sb = new StringBuilder();
		// 周期长度
		int c = numRows + numRows - 2;
		// 包含周期数，如果不能整除则需要 + 1
		int count = s.length() / c + 1;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < count; j++) {
				int index = j * c + i;
				if (index < s.length()) sb.append(s.charAt(index));
				index = j * c + c - i;
				// 首行和尾行只能计算一次
				if (i != 0 && i != (numRows - 1) && index < s.length()) sb.append(s.charAt(index));
			}
		}
		return sb.toString();
	}

}
