import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
public class MyHashSet {
    private static final int BASE = 769;
    private List[] data;

    private int hash(int key) {
        return key % BASE;
    }

    public MyHashSet() {
        data = new ArrayList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new ArrayList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == key) {
                return;
            }
        }
        data[h].add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == key) {
                iterator.remove();
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == key) {
                return true;
            }
        }
        return false;
    }
}
