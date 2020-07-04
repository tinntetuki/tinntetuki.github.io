//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
//
// 滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

//java:滑动窗口最大值
public class P239SlidingWindowMaximum{
    public static void main(String[] args){
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        int[] s = solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int x : s ) {
            System.out.println(x);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*int[] max = new int[nums.length];
        int[] maxIndex = {0,0};
        int left = 0, right = left + k;

        int maxValue = 0;
        for (int i = 0; i < right; i++) {
            if (maxValue <= nums[i]) {
                maxIndex[0] = i;
                maxIndex[1] = nums[i];
            }
        }
        while (right < nums.length) {


            left++;
            right++;
        }

        return max;*/

        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}