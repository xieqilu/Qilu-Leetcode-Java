/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
      //two cases: fast is now null or fast is at the last node of list
			//so we need to check both fast and fast.next
			//if either fast or fast.next is null, we know there is no cycle
			//cannot check fast.next first, because if fast is now null, there
			//gonna be nullpointer exceptions
        if(fast==null ||fast.next == null) return null;
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
