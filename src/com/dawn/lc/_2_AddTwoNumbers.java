package com.dawn.lc;

public class _2_AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.print(result.val);
			result = result.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int addition = 0; // 进位
		ListNode result = new ListNode(0);
		ListNode tmp = result;
		while (l1 != null || l2 != null) {
			tmp.next = new ListNode(addition);
			tmp = tmp.next;
			if (l1 != null) tmp.val += l1.val;
			if (l2 != null) tmp.val += l2.val;

			if (tmp.val >= 10) {
				tmp.val -= 10;
				addition = 1;
			} else {
				addition = 0;
			}
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		if (addition == 1) {
			tmp.next = new ListNode(addition);
		}
		return result.next;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
