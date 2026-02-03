package LinkedList.inplacereversal;

public class ReverseNodesEvenLengthGroups {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        a = reverseEvenLengthGroups(a);
        ListNode temp = a;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode temp = head;
        int group = 1;
        while (temp != null){
            if(group % 2 == 0){
                int count = 0;
                ListNode curr = temp.next;
                ListNode prev = null;
                for (int i = 0; i <group ; i++) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                temp.next.next = curr;
                temp.next = prev;
            }
            temp = temp.next;
            group++;
        }
        return head;
    }
}
