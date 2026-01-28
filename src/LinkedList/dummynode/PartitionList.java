package LinkedList.dummynode;

public class PartitionList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(3);


        head.next = b;
        b.next = c; c.next = d; d.next = e;
        e.next = f;

        partition(head,3);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-2);
        ListNode temp1 = dummy1;
        ListNode temp2 = dummy2;

        while (head != null){
            if(head.val < x){
                temp1.next = head;
                temp1 = temp1.next;
            }
            else {
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        temp2.next = null;
        temp1.next = dummy2.next;


        return dummy1.next;
    }
}
