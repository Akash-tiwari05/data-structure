package sorting.techneques.insertionSort;


public class InsertionSortList {

    public static void main(String[] args) {

        ListNode head = new ListNode(-1);
        ListNode A = new ListNode(5);
        ListNode B = new ListNode(3);
        ListNode C = new ListNode(4);
        ListNode D = new ListNode(0);

        head.next = A;
        A.next = B;
        B.next = C;
        C.next = D;

        ListNode ans = insertionSortList(head);
        while (ans != null){
            System.out.print(ans.val +" -->");
            ans = ans.next;
        }

    }

    public static ListNode insertionSortList(ListNode head) {

        if(head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;

            curr = nextNode;

        }

        return dummy.next;
    }

}
