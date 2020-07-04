//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1421 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
        System.out.println(solution.trap(new int[]{4,2,3}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();

        while (current < height.length) {
            while (!st.isEmpty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();

                if (st.isEmpty()) {
                    break;
                }

                int distance = current - st.peek() -1;
                int bounded_height = Math.min(height[current], height[st.peek()] - height[top]);

                ans += distance * bounded_height;
            }

            st.push(current++);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}