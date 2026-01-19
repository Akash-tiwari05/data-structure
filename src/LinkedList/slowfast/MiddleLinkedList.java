package LinkedList.slowfast;

public class MiddleLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode ans = middleNode(head);
        System.out.println(ans.val);
    }
    public static ListNode middleNode(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        //this is for second middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
