package LinkedList.recursion;

public class RemoveDuplicatesSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        head.next = deleteDuplicates(head.next);
        if (head.next != null && head.val == head.next.val){
            return head.next;
        }

        return head;
    }
}
