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
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode secondHead = reverseList(middle);
        ListNode reverseHead = secondHead;
        while(head!=null && secondHead!=null){
            if(head.val!=secondHead.val){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        reverseList(reverseHead);
        return head == null || secondHead == null;
    }
    public ListNode middleNode(ListNode head){
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
        ListNode next = pres.next;
        while(pres!=null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next!=null) next = next.next;
        }
        return prev;
    }
}