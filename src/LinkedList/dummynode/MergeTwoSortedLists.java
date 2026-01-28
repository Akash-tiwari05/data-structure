package LinkedList.dummynode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        headA.next = b;
        b.next = c;

        ListNode headB = new ListNode(1);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        headB.next = d;
        d.next = e;

        mergeTwoLists(headA,headB);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }
        if(list1 != null){
            temp.next = list1;
        }

        if(list2 != null){
            temp.next = list2;
        }
        ListNode tem = dummy.next;
        while (tem != null){
            System.out.print(tem.val + " -> ");
            tem = tem.next;
        }
        return dummy.next;
    }

}
