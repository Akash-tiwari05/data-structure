package LinkedList.slowfast;

public class RemoveNthNodeFromEndList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        head.next = b;
        b.next = c; c.next = d;
        d.next = e;
        System.out.println(removeNthFromEnd(head,2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        int count = 0;
        while(count != n && fast != null){
            fast = fast.next;
            count++;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        slow.next = temp.next;

        return head;
    }
}
