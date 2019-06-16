package com.dawn.lc;

import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String t1 = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(t1));

		String t2 = "bbbb";
		System.out.println(lengthOfLongestSubstring(t2));

		String t3 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(t3));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;

		int result = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.keySet().contains(ch)) {
				start = Math.max(start, map.get(ch) + 1);
			}
			map.put(ch, i);
			result = Math.max(result, i - start + 1);
		}
		return result;
	}
}
