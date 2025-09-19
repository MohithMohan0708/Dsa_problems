/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alen = getLength(headA);
        int blen = getLength(headB);
        int maxlen = Math.max(alen,blen);
        int k = maxlen - Math.min(alen,blen);
        if(maxlen == alen){
            while(k-->0){
                headA = headA.next;
            }
        }
        else{
            while(k-->0){
                headB = headB.next;
            }
        }
        while(headA!=null && headB!=null){
            if(headA == headB) return headA;
            if(headA.next == headB.next){
                return headA.next;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public int getLength(ListNode head){
        int count = 0;
        while(head!=null){
            count+=1;
            head = head.next;
        }
        return count;
    }
}