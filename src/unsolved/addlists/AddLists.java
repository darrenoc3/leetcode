package unsolved.addlists;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddLists {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode result = new ListNode(0);
        addTwoNumbers(result, 0, l1, l2);
        return result;
    }
    public static ListNode addTwoNumbers(ListNode result, int oneCarried,ListNode l1, ListNode l2) {
        int total = l1.val + l2.val + oneCarried;
        int carryOneForward = 0;
        if(total > 9) {
        	carryOneForward = 1;
        }
        result.val = total;
        result.next = new ListNode(0);
        if(l1.next == null && l2.next == null) {
        	return result;
        }
        return addTwoNumbers(result.next, carryOneForward, l1.next, l2.next);
    }
    public static void main(String[] args) {
    	ListNode left = new ListNode(2);
    	left.next = new ListNode(4);
    	left.next.next = new ListNode(3);
    	
    	ListNode right = new ListNode(5);
    	right.next = new ListNode(6);
    	right.next.next = new ListNode(4);
    	
    	ListNode result = addTwoNumbers(left, right);
    	return;
    }
}
