/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head1) {
        ListNode mainHead = head1;
        ListNode mid = getmid(head1);
        ListNode head2 = reverseList(mid);
        while(head1!=null && head2!=null){
            ListNode temp1 = head1.next;
            head1.next = head2;
            head1 = temp1;

            ListNode temp2 = head2.next;
            head2.next = head1;
            head2 = temp2;
        }
        if(head1!=null){
            head1.next = null;
        } 
    }
    public ListNode getmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = head.next;
        while(pres!=null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next!=null){
                next = next.next;
            }
        }
        return prev;
    }
}