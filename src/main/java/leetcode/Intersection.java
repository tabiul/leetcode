package leetcode;

/**
 * 
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/intersection-of-two-linked-lists">https://oj.leetcode.com/problems/intersection-of-two-linked-lists</a>
 */
public class Intersection {

   public class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }
   }

   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

      if (headA == null || headB == null) {
         return null;
      }

      if (headA.val == headB.val) {
         return headA;
      }

      int sizeOfA = 0;
      int sizeOfB = 0;

      ListNode A = headA;
      while (true) {
         sizeOfA++;
         if (A.next != null) {
            A = A.next;
         }
         else {
            break;
         }
      }

      ListNode B = headB;
      while (true) {
         sizeOfB++;
         if (B.next != null) {
            B = B.next;
         }
         else {
            break;
         }
      }

      A = headA;
      B = headB;
      if (sizeOfA > sizeOfB) {
         int count = sizeOfA - sizeOfB;
         while (true) {
            A = A.next;
            if (--count == 0) {
               break;
            }
         }
      }
      else if (sizeOfB > sizeOfA) {
         int count = sizeOfB - sizeOfA;
         while (true) {
            B = B.next;
            if (--count == 0) {
               break;
            }
         }
      }

      while (true) {
         if (B.val == A.val) {
            return B;
         }
         else {
            B = B.next;
            A = A.next;

            if (A == null || B == null) {
               return null;
            }
         }
      }

   }
}
