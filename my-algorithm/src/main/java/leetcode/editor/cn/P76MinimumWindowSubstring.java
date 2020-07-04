//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
//
// 示例：
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:最小覆盖子串
public class P76MinimumWindowSubstring{
    public static void main(String[] args){
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("sdfagfsdga", "fag"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        int left, right, valid;
        left = right = valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while ( right < s.length()) {
            char c = s.charAt(right);
            right ++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c) == need.get(c)) {
                    valid ++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (need.get(d) == window.get(d)) {
                        valid --;
                    }

                    window.put(d, window.get(d) -1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}