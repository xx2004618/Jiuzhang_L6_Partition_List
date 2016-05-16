package Jiuzhang;

//public class Solution {
//    /**
//     * @param head: The first node of linked list.
//     * @param x: an integer
//     * @return: a ListNode 
//     */
//    public ListNode partition(ListNode head, int x) {
//        // write your code here
//    	ListNode dummy = new ListNode(-1);
//    	dummy.next = head;
//    	for (int i = 0; i < x; i++){
//    		if (head == null){
//    			return null;
//    		}
//    		head = head.next;
//    	}
//    	ListNode breakPoint = head;
//    	System.out.println(breakPoint.val);
//    	ListNode larger = breakPoint;
//    	head = dummy;
//    	while (head.next.val != breakPoint.val){
//    		if (head.next.val > breakPoint.val){
//    			ListNode temp = head.next.next;
//    			head.next.next = larger.next;
//    			larger.next = head.next;
//    			head.next = temp;
//    			larger = larger.next;
//    		} else {
//    			head = head.next;
//    		}
//    	}
//    	ListNode smaller = head;
//    	while (head.next != null){
//    		if (head.next.val < breakPoint.val){
//    			ListNode temp = head.next;
//    			head.next = head.next.next;
//    			temp.next = breakPoint;
//    			smaller.next = temp;
//    			smaller = smaller.next;
//    		}
//        	head = head.next;
//    	}
//    	head = dummy.next;
//    	listNodeShow(head);
//    	return dummy.next;
//    }
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
	public void listNodeShow(ListNode head){
		if(head == null){
			System.out.println("The list node is empty");
			return;
		}
		while(head != null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("null");
	}
    public static void main(String args[]){
    	ListNode head = new ListNode(1);
    	ListNode node1 = new ListNode(5);
    	ListNode node2 = new ListNode(4);
    	ListNode node3 = new ListNode(2);
    	ListNode node4 = new ListNode(3);
    	ListNode node5 = new ListNode(2);
    	ListNode node6 = new ListNode(7);
    	head.next = node1;
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6;
    	Solution solution = new Solution();
    	solution.listNodeShow(head);
    	solution.partition(head, 4);
    	solution.listNodeShow(head);
    }
}