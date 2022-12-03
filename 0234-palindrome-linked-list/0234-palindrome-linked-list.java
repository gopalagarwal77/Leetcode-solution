/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
   ListNode slow = head;
    ListNode fast = head;
        while(fast!=null && fast.next.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        
       ListNode revhead= reverse(slow);
        while(revhead!=null){
        if(revhead.val!=head.val){
            return false;
        }
        revhead=revhead.next;
        head=head.next;
        }
        return true;
        
    
    }
    public static ListNode reverse( ListNode head){
        ListNode prev=null;
        ListNode curr= head;
        while(curr!=null)
        {
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=head;
            curr=nextnode;
        }
        return  prev;
    }
    
}*/





class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode reversed = null;
        ListNode slow = head;
        ListNode fast = head;

        // found middle of list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversed second half of list
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = reversed;
            reversed = slow;
            slow = next;
        }

        // compared first and second half
        while (reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }
}
/*Using Stack:

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null || fast.next == null) {
                if (fast != null) slow = slow.next;
                while (slow != null) {
                    if (stack.empty() || stack.pop() != slow.val) return false;
                    slow = slow.next;
                }
            }
        }
        return true;
    }
}*/