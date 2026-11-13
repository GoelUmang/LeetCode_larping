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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        //have two pointers, a dummy, prev,
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            //dhundo and add
            int prevNum = (prev != null) ? prev.val : 0;
            int currNum = curr.val;

            int gcdVal = findGCD(prevNum, currNum);
            ListNode temp = new ListNode(gcdVal);

            prev.next = temp;
            temp.next = curr;
            prev = prev.next.next;
            curr = curr.next;
        }
        return head;
    }
    public int findGCD(int num1, int num2){
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}