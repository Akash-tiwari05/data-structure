package LinkedList.dummynode;

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
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head != null){
            if(head.val != val){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;

        /*ListNode tem = dummy.next;
        while (tem != null){
            System.out.print(tem.val + " -> ");
            tem = tem.next;
        }*/
        return dummy.next;
    }
}
