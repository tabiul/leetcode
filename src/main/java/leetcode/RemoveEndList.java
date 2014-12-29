package leetcode;

/**
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/">https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/</a>
 */
public class RemoveEndList {

   public static class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }

      @Override
      public String toString() {
         String str = Integer.toString(val);
         if (next != null) {
            str = str + "," + next.toString();
         }
         return str;
      }
   }

   public static ListNode removeNthFromEnd(ListNode head, int n) {
      int count = 0;
      ListNode start = head;
      ListNode end = head;
      boolean found = false;
      while (true) {
         end = end.next;

         if (!found) {
            if (++count == n + 1) {
               found = true;
            }
         } else {
            start = start.next;
         }
         if (end == null) {
            break;
         }

      }

      if (!found) {
         if (start.next == null) {
            return null;
         } else {
            head = head.next;
         }

      } else {
         start.next = start.next.next;

      }
      return head;
   }

   public static void main(String args[]) {
      ListNode node1 = new ListNode(1);
      System.out.println(removeNthFromEnd(node1, 1) == null);
      ListNode node2 = new ListNode(2);
      node1.next = node2;
      System.out.println(removeNthFromEnd(node1, 1).toString().equals("1"));
      System.out.println(removeNthFromEnd(node1, 2).toString().equals("2"));
      ListNode node3 = new ListNode(3);
      node2.next = node3;
      System.out.println(removeNthFromEnd(node1, 1).toString().equals("1,2"));
      System.out.println(removeNthFromEnd(node1, 2).toString().equals("1,3"));
      System.out.println(removeNthFromEnd(node1, 3).toString().equals("2,3"));

   }
}
