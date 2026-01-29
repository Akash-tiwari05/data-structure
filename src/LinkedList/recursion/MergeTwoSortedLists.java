package LinkedList.recursion;



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

        //base case
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        //use recursion
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }

    }
}
