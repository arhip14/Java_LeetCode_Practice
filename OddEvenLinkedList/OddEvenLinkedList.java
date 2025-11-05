package OddEvenLinkedList;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if ( head == null && head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while ( even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        OddEvenLinkedList obj = new OddEvenLinkedList();
        ListNode head = obj.oddEvenList(node1);

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}


//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//
//The first node is considered odd, and the second node is even, and so on.
//
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
//
//You must solve the problem in O(1) extra space complexity and O(n) time complexity.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
//Example 2:
//
//
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
//
//
//Constraints:
//
//The number of nodes in the linked list is in the range [0, 104].
//        -106 <= Node.val <= 106
