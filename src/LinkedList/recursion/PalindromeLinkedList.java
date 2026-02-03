package LinkedList.recursion;

public class PalindromeLinkedList {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return check(head);
    }

    public boolean check(ListNode right){
        if(right == null) return true;

        boolean result = check(right.next);

        if(!result) return false;
        if(left.val != right.val) return false;

        left = left.next;

        return true;
    }
}
