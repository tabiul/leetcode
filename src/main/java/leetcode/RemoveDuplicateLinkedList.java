package leetcode;


/**
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/">https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/</a>
 *
 */
public class RemoveDuplicateLinkedList {

   public class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }
   }

   public ListNode deleteDuplicates(ListNode head) {
      if (head == null) {
         return null;
      }
      ListNode prev = null;
      ListNode h = head;
      while (true) {
         if (prev != null) {
            // have I seen this node
            if (prev.val == h.val) {
               prev.next = h.next;
            }
            else {
               prev = h;
            }
         }
         else {
            prev = h;
         }
         if (h.next == null) {
            return head;
         }
         else {
            h = h.next;
         }
      }
   }
}
