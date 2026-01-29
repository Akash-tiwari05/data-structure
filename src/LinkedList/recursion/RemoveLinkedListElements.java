package LinkedList.recursion;

public class RemoveLinkedListElements {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);


        head.next = b;
        b.next = c; c.next = d; d.next = e;
        e.next = f; f.next = g;

        removeElements(head,6);
    }
    public static ListNode removeElements(ListNode head, int val) {

        if(head == null && head.next == null) return head;

        head.next = removeElements(head.next,val);

        if(head.val == val) return head.next;

        return head;
    }
}
