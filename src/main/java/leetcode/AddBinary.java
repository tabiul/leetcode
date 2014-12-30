package leetcode;
/**
 * @author tabiul<tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/add-binary/">https://oj.leetcode.com/problems/add-binary/</a>
 */
public class AddBinary {

   public String addBinary(String a, String b) {
      StringBuilder result = new StringBuilder();
      char[] binaryA = a.toCharArray();
      char[] binaryB = b.toCharArray();
      int i = a.length() - 1, j = b.length() - 1;
      char carry = '0';
      while (true) {
         char num1 = '0';
         char num2 = '0';
         if (i >= 0 && j >= 0) {
            num1 = binaryA[i];
            num2 = binaryB[j];
         } else if (i >= 0) {
            num1 = binaryA[i];
         } else if (j >= 0) {
            num2 = binaryB[j];
         } else {
            break;
         }
         int sum = num1 + num2 + carry;
         if (sum == 144) {
            result.append('0');
            carry = '0';
         } else if (sum == 145) {
            result.append('1');
            carry = '0';
         } else if (sum == 146) {
            result.append('0');
            carry = '1';
         } else {
            result.append('1');
            carry = '1';
         }
         i--;
         j--;
      }
      if (carry == '1')
         result.append(carry);
      return result.reverse().toString();
   }

   public static void main(String args[]) {
      AddBinary b = new AddBinary();
      System.out.println(b.addBinary("1111", "1111"));
   }
}
