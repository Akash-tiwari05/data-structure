package LinkedList.dummynode;


public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode headA = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);


        headA.next = b;
        b.next = c;

        ListNode headB = new ListNode(5);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(4);


        headB.next = d;
        d.next = e;

        addTwoNumbers(headA,headB);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp  = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;

            if(l1 != null) val1 = l1.val;
            if(l2 != null) val2 = l2.val;

            int sum = val1 + val2 + carry;
            if(sum > 9) carry = 1;
            else carry = 0;
            ListNode add = new ListNode(sum % 10);
            temp.next = add;
            temp = temp.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry == 1){
            ListNode carryNode = new ListNode(1);
            temp.next = carryNode;
        }
        ListNode temp2 = dummy.next;
        while(temp2 != null){
            System.out.print(temp2.val +" -> ");
            temp2 = temp2.next;
        }

        return dummy.next;
    }
}
