package LinkedList.inplacereversal;

public class ReverseLinkedListII {



    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        reverseBetween(a,2,4);
    }

    public static ListNode reverseBetween(ListNode head,
                                          int left, int right) {

        if (head == null || left == right) return head;


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        for (int i = 1 ; i < left; i++) {
            temp = temp.next;
        }

        ListNode curr = temp.next;
        ListNode prev = null;
        for (int i = 0; i <= right - left ; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        temp.next.next = curr;
        temp.next = prev;

        return dummy.next;
    }
}
