package leetcode.editor.cn;

//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。 
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 30 
// 所有输入的字符串 words[i] 都只包含小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 264 👎 0

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class 词典中最长的单词 {
    public static void main(String[] args) {
        Solution solution = new 词典中最长的单词().new Solution();
        solution.longestWord(new String[]{"1"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            //26个字母
            List<Node> list = new ArrayList<>(26);
            for (String word : words) {
                char charAt = word.charAt(0);
                //当前word落在的索引位置
                int index = charAt - 'a';
				Node linkedList = list.get(index);


                //LinkedList 给字母排序插入


            }
            //TODO
			return null;
        }

        class Node{
        	Node next;
        	String data;
		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}
