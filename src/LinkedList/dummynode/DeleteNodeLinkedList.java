package LinkedList.dummynode;

public class DeleteNodeLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(9);
        head.next = b;
        b.next = c; c.next = d;

        deleteNode(b);
    }
    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
