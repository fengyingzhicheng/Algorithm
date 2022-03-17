package leetcode.editor.cn;

//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。 
//
// 实现 AllOne 类： 
//
// 
// AllOne() 初始化数据结构的对象。 
// inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。 
// dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例
//保证：在减少计数前，key 存在于数据结构中。 
// getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", 
//"getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//输出
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//解释
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "leet"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length <= 10 
// key 由小写英文字母组成 
// 测试用例保证：在每次调用 dec 时，数据结构中总存在 key 
// 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 10⁴ 次 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 213 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class 全O1的数据结构 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {
        class Node {
            int cnt;
            Set<String> set = new HashSet<>();
            Node left, right;
            Node(int _cnt) {
                cnt = _cnt;
            }
        }

        Node hh, tt;
        Map<String, Node> map = new HashMap<>();
        public AllOne() {
            hh = new Node(-1000); tt = new Node(-1000);
            hh.right = tt; tt.left = hh;
        }

        void clear(Node node) {
            if (node.set.size() == 0) {
                node.left.right = node.right;
                node.right.left = node.left;
            }
        }

        public void inc(String key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.set.remove(key);
                int cnt = node.cnt;
                Node next = null;
                if (node.right.cnt == cnt + 1) {
                    next = node.right;
                } else {
                    next = new Node(cnt + 1);
                    next.right = node.right;
                    next.left = node;
                    node.right.left = next;
                    node.right = next;
                }
                next.set.add(key);
                map.put(key, next);
                clear(node);
            } else {
                Node node = null;
                if (hh.right.cnt == 1) {
                    node = hh.right;
                } else {
                    node = new Node(1);
                    node.right = hh.right;
                    node.left = hh;
                    hh.right.left = node;
                    hh.right = node;
                }
                node.set.add(key);
                map.put(key, node);
            }
        }

        public void dec(String key) {
            Node node = map.get(key);
            node.set.remove(key);
            int cnt = node.cnt;
            if (cnt == 1) {
                map.remove(key);
            } else {
                Node prev = null;
                if (node.left.cnt == cnt - 1) {
                    prev = node.left;
                } else {
                    prev = new Node(cnt - 1);
                    prev.right = node;
                    prev.left = node.left;
                    node.left.right = prev;
                    node.left = prev;
                }
                prev.set.add(key);
                map.put(key, prev);
            }
            clear(node);
        }

        public String getMaxKey() {
            Node node = tt.left;
            for (String str : node.set) return str;
            return "";
        }

        public String getMinKey() {
            Node node = hh.right;
            for (String str : node.set) return str;
            return "";
        }
    }


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
