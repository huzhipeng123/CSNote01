package demo0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author Administrator
 *输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 */
public class Demo06 {
	public static void main(String[] args) {
		Integer N = 10;
		ListNode head = generateListNode(N);
		System.out.println("=========生成的正序链表===========");
		printListNode(head);
		System.out.println("\n=========栈实现的倒序链表=========");
		Stack<Integer> stack = printListFromTailToHead01(head);
		printStack(stack);
		System.out.println("\n=========递归实现的倒序链表=========");
		List<Integer> list = printListFromTailToHead02(head);
		printList(list);
		System.out.println("\n=======头插法实现的倒序链表=========");
		ListNode phead = printListFromTailToHead03(head);
		phead = phead.next;
		printListNode(phead);
	}
	
	/**
	 * 头插法构建倒序链表
	 * @param head
	 * @return
	 */
	private static ListNode printListFromTailToHead03(ListNode head) {
		isNULL(head);
		ListNode phead = new ListNode(-1);
		while(head != null) {
			ListNode memo = head.next;
			head.next = phead.next;
			phead.next = head;
			head = memo;
		}
		return phead;
	}

	/**
	 * 打印List类
	 * @param list
	 */
	private static void printList(List<Integer> list) {
		if(list == null || list.isEmpty()) {
			throw new NullPointerException("list为空，无法输出！");
		}
		System.out.print("head");
		for(Integer i : list) {
			System.out.print("->"+i);
		}
		
	}

	/**
	 * 使用递归实现倒序
	 * @param listNode
	 * @return
	 */
	public static List<Integer> printListFromTailToHead02(ListNode listNode) {
	    List<Integer> ret = new ArrayList<>();
	    if (listNode != null) {
	        ret.addAll(printListFromTailToHead02(listNode.next));
	        ret.add(listNode.data);
	    } 
	    return ret;
	}

	
	/**
	 * 打印栈
	 * @param stack
	 */
	private static void printStack(Stack<Integer> stack) {
		if(stack == null || stack.isEmpty()) {
			throw new NullPointerException("栈为空，无法输出！");
		}
		System.out.print("head");
		
		while(!stack.isEmpty()) {
			System.out.print("->"+stack.pop());
		}
	}


	/**
	 * 使用栈实现倒序
	 * @param head
	 */
	private static Stack<Integer> printListFromTailToHead01(ListNode head) {
		isNULL(head);
		Stack<Integer> stack = new Stack<>();
		ListNode temp = head;
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		return stack;
	}

	private static void isNULL(ListNode head) {
		if(head == null) {
			throw new NullPointerException("链表结点为空！");
		}
	}


	/**
	 * 生成链表大小为N的单链表
	 * @param n
	 * @return
	 */
	private static ListNode generateListNode(Integer n) {
		if(n < 1) {
			throw new IllegalArgumentException("给定的链表大小不合理！");
		}
		ListNode head = new ListNode();
		Random random = new Random();
		head.data = random.nextInt(n);
		ListNode temp = head;
		for(int i = 1; i < n; i++) {
			ListNode node = new ListNode();
			node.data = random.nextInt(n);
			node.next = null;
			temp.next = node;
			temp = temp.next;
		}
		return head;
	}




	/**
	 * 打印链表
	 * @param head
	 */
	private static void printListNode(ListNode head) {
		isNULL(head);
		ListNode temp = head;
		System.out.print("head");
		while(temp != null) {
			System.out.print("->"+temp.data);
			temp = temp.next;
		}
		
	}
}
