package LinkedList.dummynode;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        head.next = b;
        b.next = c; c.next = d; d.next = e;

        rotateRight(head,3);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int n =0;
        while (temp != null){
            temp = temp.next;
            n++;
        }
        k = k%n;
        if(k == 0) return head;
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i <k ; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}
