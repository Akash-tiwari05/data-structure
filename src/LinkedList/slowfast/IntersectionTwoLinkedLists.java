package LinkedList.slowfast;

public class IntersectionTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(8);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        headA.next = b;
        b.next = c; c.next = d;
        d.next = e;

        ListNode headB = new ListNode(6);
        ListNode b2 = new ListNode(5);
        ListNode c2 = new ListNode(1);


        headB.next = b2;
        b2.next = c2; c2.next = c;

        ListNode ans = getIntersectionNode(headA,headB);
        System.out.println(ans.val);
    }
    /*
     *key idea to solve these question is
     * 1. Check if both List end with same tail node
     * 2. Somehow make both pointers start at the same distance from the tail
     * 3. Then move them forward together
     * 4. When two pointers move in sync,
     *      the first node where they match is the intersection.
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int l1 = 0;
         int l2 = 0;
         ListNode tempA = headA;
         ListNode tempB = headB;
         while(tempA.next != null){
             l1++;
             tempA = tempA.next;
         }
         l1 += 1;
         while(tempB.next != null){
            l2++;
            tempB = tempB.next;
         }
         l2 += 1;

         if(tempA != tempB) return null;
         tempA = headA;
         tempB = headB;

         if(l1 > l2){
             for (int i = 0; i < l1- l2; i++) {
                 tempA = tempA.next;
             }
         }
         else if(l2 > l1){
             for (int i = 0; i < l2- l1; i++) {
                 tempB = tempB.next;
             }
         }

         while(tempA != null){

             if(tempA == tempB) return tempA;
             tempA = tempA.next;
             tempB = tempB.next;
         }

        return null;
    }

}
