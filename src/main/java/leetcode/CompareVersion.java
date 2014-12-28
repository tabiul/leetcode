package leetcode;

/**
 * @author tabiul <tabiul@gmail.com>
 * @see <a href="https://oj.leetcode.com/problems/compare-version-numbers/">https://oj.leetcode.com/problems/compare-version-numbers/</a>
 */
public class CompareVersion {
   /**
    * @param version1
    * @param version2
    * @return If version1 > version2 return 1, if version1 < version2 return -1,
    *         otherwise return 0.
    */
   public int compareVersion(String version1, String version2) {
      if (version1.length() == 0 && version2.length() == 0) {
         return 0;
      }
      else if (version1.length() == 0) {
         return -1;
      }
      else if (version2.length() == 0) {
         return 1;
      }
      else {
         String[] ver1 = version1.split("\\.");
         String[] ver2 = version2.split("\\.");
         int size = ver1.length > ver2.length ? ver1.length : ver2.length;
         for (int i = 0; i < size; i++) {
            int v1Value = 0;
            int v2Value = 0;
            if (i <= ver1.length - 1) {
               v1Value = Integer.parseInt(ver1[i]);
            }
            if (i <= ver2.length - 1) {
               v2Value = Integer.parseInt(ver2[i]);
            }
            if (v1Value > v2Value) {
               return 1;
            }
            else if (v1Value < v2Value) {
               return -1;
            }
         }

         return 0;
      }

   }
}
