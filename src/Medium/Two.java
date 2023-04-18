package Medium;

/* 
    2. Add Two Numbers
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
    Example 2:
        Input: l1 = [0], l2 = [0]
        Output: [0]
    Example 3:
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]

    Constraints:
        The number of nodes in each linked list is in the range [1, 100].
        0 <= Node.val <= 9
        It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class Two {

    /* Definition for singly-linked list */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public static void main (String[] args) {
        // case 1
        /*
        ListNode l1ToOne = new ListNode(3);
        ListNode l1ToTwo = new ListNode(4, l1ToOne);
        ListNode l1ToEnd = new ListNode(2, l1ToTwo);
        ListNode l2ToOne = new ListNode(4);
        ListNode l2ToTwo = new ListNode(6, l2ToOne);
        ListNode l2ToEnd = new ListNode(5, l2ToTwo);
        */
        // case 2
        /*
        ListNode l1ToEnd = new ListNode(0);
        ListNode l2ToEnd = new ListNode(0);
        */
        // case 3
        ListNode l1To1 = new ListNode(9);
        ListNode l1To2 = new ListNode(9, l1To1);
        ListNode l1To3 = new ListNode(9, l1To2);
        ListNode l1To4 = new ListNode(9, l1To3);
        ListNode l1To5 = new ListNode(9, l1To4);
        ListNode l1To6 = new ListNode(9, l1To5);
        ListNode l1ToEnd = new ListNode(9, l1To6);

        ListNode l2To1 = new ListNode(9);
        ListNode l2To2 = new ListNode(9, l2To1);
        ListNode l2To3 = new ListNode(9, l2To2);
        ListNode l2ToEnd = new ListNode(9, l2To3);
        
        ListNode l1 = l1ToEnd;
        ListNode l2 = l2ToEnd;

        addTwoNumbers(l1, l2);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            // 加總 l1
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // 加總 l2
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 加總 進位
            sum += carry;
            carry = sum/10;

            ListNode node = new ListNode(sum%10);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
