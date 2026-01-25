package LinkedList.slowfast;

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);

        head.next = b;
        b.next = c; c.next = d;
        d.next = b;
        System.out.println(detectCycle(head));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast= head;

        if(head == null || head.next == null) return null;

        boolean isCyclic = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                isCyclic = true;
                break;
            }
        }

        ListNode temp = head;
        while(isCyclic && temp != slow){
            temp = temp.next;
            slow = slow.next;
        }

        return isCyclic?temp:null;
    }
}
