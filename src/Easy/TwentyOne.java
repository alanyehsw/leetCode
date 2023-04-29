package Easy;

/*
    21. Merge Two Sorted Lists
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]

    Example 2:
        Input: list1 = [], list2 = []
        Output: []

    Example 3:
        Input: list1 = [], list2 = [0]
        Output: [0]

    Constraints:
        The number of nodes in both lists is in the range [0, 50].
        -100 <= Node.val <= 100
        Both list1 and list2 are sorted in non-decreasing order.
*/
public class TwentyOne {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main (String[] args) {
        // case 1 
        ListNode l1To1 = new ListNode(4);
        ListNode l1To2 = new ListNode(2, l1To1);
        ListNode l1End = new ListNode(1, l1To2);
        ListNode l2To1 = new ListNode(4);
        ListNode l2To2 = new ListNode(3, l2To1);
        ListNode l2End = new ListNode(1, l2To2);
        mergeTwoLists(l1End, l2End);
        mergeTwoListsWay2(l1End, l2End);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode mergeList = result;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                mergeList.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                mergeList.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            mergeList = mergeList.next;
        }
        if (list1 == null) {
            mergeList.next = list2;
        }
        if (list2 == null) {
            mergeList.next = list1;
        }
        return result.next;
    }

    private static ListNode mergeTwoListsWay2(ListNode list1, ListNode list2) {
        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            } else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null) {
            return list2;
        } else {
            return list1;
        }
    }
}
