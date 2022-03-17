package leetcode.editor.cn;

//假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。 
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。 
//
// 
//
// 示例 1: 
//
// 
//输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = [
//"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
// 
//
// 示例 2: 
//
// 
//输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC",
// "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= list1.length, list2.length <= 1000 
// 1 <= list1[i].length, list2[i].length <= 30 
// list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。 
// list1 的所有字符串都是 唯一 的。 
// list2 中的所有字符串都是 唯一 的。 
// 
// Related Topics 数组 哈希表 字符串 👍 182 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class 两个列表的最小索引总和 {
    public static void main(String[] args) {
        Solution solution = new 两个列表的最小索引总和().new Solution();
        solution.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Burger King","Tapioca Express","Shogun"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list2.length; i++) {
                String data = list2[i];
                map.put(data, i);
            }

            int min = Integer.MAX_VALUE;
            Map<Integer, List<String>> countMap = new HashMap<>();
            //数组1
            int length = list1.length;
            for (int i = 0; i < length; i++) {
                Integer data2 = map.getOrDefault(list1[i], -1);
                if (data2 != -1) {
                    List<String> list = countMap.getOrDefault(i + data2, new LinkedList<>());
                    list.add(list1[i]);
                    countMap.put(i + data2, list);
                    min = Math.min(min, i + data2);
                }
            }
            return min == Integer.MAX_VALUE ? new String[]{} : countMap.get(min).toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
