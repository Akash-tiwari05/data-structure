package LinkedList.inplacereversal;

public class ReorderList {

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

        reorderList(a);
        ListNode temp = a;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

    }

    /// 1 -> 2 -> 3 -> 4 -> 5 -> 6
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        /// 1 -> 2 -> 3
        /// 6 -> 5 - >4
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head != null && head2 != null){
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        if(head == null) temp.next = head2;
        if(head2 == null) temp.next = head;

    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
