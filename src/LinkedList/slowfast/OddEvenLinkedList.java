package LinkedList.slowfast;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        System.out.println();
        oddEvenList(head);
        while(head != null){
            System.out.print(head.val +" -> ");
            head = head.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode odd= head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null){
            odd.next= even.next;
            odd = odd.next;

            even.next= odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
