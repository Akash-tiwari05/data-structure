package LinkedList.dummynode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);

        head.next = b;
        b.next = c;

        deleteDuplicates(head);
        deleteDuplicates2(head);
    }

    //use of dummy node which is best
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(head != null){
            //while (temp.val == head.val) head = head.next;

            if(temp == dummy ||temp.val != head.val){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;

        return dummy.next;
    }

    /// there is simple method which is also best for interview
    public static ListNode deleteDuplicates2(ListNode head) {

        ListNode curr = head;
        while (curr.next != null){

            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }

        return head;
    }

}
