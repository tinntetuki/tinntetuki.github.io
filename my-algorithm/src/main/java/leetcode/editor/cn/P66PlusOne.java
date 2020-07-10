//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 492 👎 0


package leetcode.editor.cn;


//Java：加一
public class P66PlusOne{
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        /**
         * for (int i = digits.length - 1; i >= 0; i--) {
         *             digits[i]++;
         *             digits[i] = digits[i] % 10;
         *             if (digits[i] != 0) return digits;
         *         }
         *         digits = new int[digits.length + 1];
         *         digits[0] = 1;
         *         return digits;
         *
         */

        int i = 0;
        boolean flag = true;
        int len = digits.length ;
        while (flag) {
            int index = len - 1 - i;
            if (index < 0) {
                digits = new int[len + 1];
                digits[0] = 1;
                break;
            }
            if (digits[index] == 9) {
                digits[index] = 0;
                i++;
            } else {
                digits[index] = digits[index] + 1;
                return digits;
            }
        }

        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}