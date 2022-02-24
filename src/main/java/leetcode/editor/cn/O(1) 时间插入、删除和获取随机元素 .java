package leetcode.editor.cn;

//实现RandomizedSet 类： 
//
// 
// 
// 
// RandomizedSet() 初始化 RandomizedSet 对象 
// bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。 
// bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。 
// int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。 
// 
//
// 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。 
//
// 
//
// 示例： 
//
// 
//输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//输出
//[null, true, false, true, 2, true, false, 2]
//
//解释
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次 
// 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。 
// 
// 
// 
// Related Topics 设计 数组 哈希表 数学 随机化 👍 423 👎 0

import java.util.*;

class 时间插入删除和获取随机元素 {
    public static void main(String[] args) {
        RandomizedSet solution = new 时间插入删除和获取随机元素().new RandomizedSet();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        //存放集合的实际元素
        List<Integer> data;
        Random random;
        //存放每个元素以及其对应data的索引
        Map<Integer,Integer> map;

        public RandomizedSet() {
            data=new ArrayList<>();
            random=new Random();
            map=new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val,data.size());
            data.add(val);
            return true;
        }

        public boolean remove(int val) {
            //当前删除元素的索引
            Integer index = map.get(val);
            if (index == null) {
                return false;
            } else {
                //最后一个元素索引
                int lastIndex =data.size()-1;
                int deleteData = data.get(index);
                int lastData = data.get(lastIndex);
                //交换两个元素
                data.set(index,lastData);
                map.put(lastData,index);

                data.set(lastIndex,deleteData);
                map.put(deleteData,lastIndex);
                //删除最后一个元素
                data.remove(lastIndex);
                map.remove(deleteData);

                return true;
            }
        }

        public int getRandom() {
            int idx = random.nextInt(data.size());
            return data.get(idx);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
